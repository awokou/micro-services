package com.server.product.service.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.server.product.service.dto.ProductRequestDto;
import com.server.product.service.dto.ProductResponseDto;
import com.server.product.service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductRequestDto productRequestDto) throws JsonProcessingException {
        productService.create(productRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long productId){
        return new ResponseEntity<>(productService.getById(productId), HttpStatus.OK);
    }
}
