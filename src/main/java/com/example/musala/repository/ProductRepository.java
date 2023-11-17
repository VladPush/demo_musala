package com.example.musala.repository;

import com.example.musala.entity.product.core.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProductRepository extends JpaRepository<Product, Long> {
}
