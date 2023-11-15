package com.fledson.liveCoding.domain.repository;

import com.fledson.liveCoding.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findAllByActiveTrue();

}
