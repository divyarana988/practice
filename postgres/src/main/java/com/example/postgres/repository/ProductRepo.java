package com.example.postgres.repository;


import com.example.postgres.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepo extends JpaRepository<Product, Long> {



}
