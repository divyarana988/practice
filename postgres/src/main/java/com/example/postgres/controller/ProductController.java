package com.example.postgres.controller;


import com.example.postgres.repository.ProductRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepo productRepo;


    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping
    public ResponseEntity getAllProduct(){
        return ResponseEntity.ok(this.productRepo.findAll());
    }
}
