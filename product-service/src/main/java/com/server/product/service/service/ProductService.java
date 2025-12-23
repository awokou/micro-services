package com.server.product.service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.server.product.service.dto.ProductRequestDto;
import com.server.product.service.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    void create(ProductRequestDto productRequestDto) throws JsonProcessingException;
    List<ProductResponseDto> getProducts();
    ProductResponseDto getById(Long id);
}
