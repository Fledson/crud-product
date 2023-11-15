package com.fledson.liveCoding.controllers;

import com.fledson.liveCoding.domain.product.Product;
import com.fledson.liveCoding.domain.product.ProductRepository;
import com.fledson.liveCoding.domain.product.RequestProductDTO;
import com.fledson.liveCoding.domain.product.RequestUpdateProductDTO;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity getAllProducts() {
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProductDTO data) {
        Product newProduct = new Product(data);
        newProduct = repository.save(newProduct);
        return ResponseEntity.ok(newProduct);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid RequestUpdateProductDTO data) {
        Product product = repository.findById(data.id()).orElseThrow( () -> new RuntimeException("Produto não existe"));
        BeanUtils.copyProperties(data, product, "id");
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
