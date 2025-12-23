package com.server.product.service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.product.service.dto.ProductEventModel;
import com.server.product.service.dto.ProductRequestDto;
import com.server.product.service.dto.ProductResponseDto;
import com.server.product.service.entity.Product;
import com.server.product.service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private static final String CREATE_PRODUCT_TOPIC = "create.product";

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProductServiceImpl(ProductRepository productRepository, ObjectMapper objectMapper, KafkaTemplate<String, String> kafkaTemplate) {
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }


    @Override
    @Transactional
    public void create(ProductRequestDto productRequestDto) throws JsonProcessingException {

        Product product = Product.builder()
                .ref(UUID.randomUUID().toString())
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .stockCount(productRequestDto.getStockCount())
                .inStock(productRequestDto.getInStock())
                .build();

        productRepository.save(product);

        ProductEventModel productEventModel = ProductEventModel.builder()
                .ref(product.getRef())
                .name(product.getName())
                .price(product.getPrice())
                .stockCount(product.getStockCount())
                .inStock(product.getInStock())
                .build();

        String productDtoAsString = objectMapper.writeValueAsString(productEventModel);

        kafkaTemplate.send(CREATE_PRODUCT_TOPIC, productDtoAsString);

        log.info("Sent product {}", productDtoAsString);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponseDto getById(Long id) {
        return productRepository.findById(id)
                .map(this::mapToDto)
                .orElse(null);
    }

    private ProductResponseDto mapToDto(Product product) {
        return ProductResponseDto.builder()
                .ref(product.getRef())
                .name(product.getName())
                .price(product.getPrice())
                .stockCount(product.getStockCount())
                .inStock(product.getInStock())
                .build();
    }
}
