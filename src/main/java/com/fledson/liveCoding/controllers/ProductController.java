package com.fledson.liveCoding.controllers;

import com.fledson.liveCoding.domain.model.dto.ProductDTO;
import com.fledson.liveCoding.domain.model.dto.RequestProductDTO;
import com.fledson.liveCoding.domain.model.dto.RequestUpdateProductDTO;
import com.fledson.liveCoding.domain.service.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody @Valid RequestProductDTO data) {
        ProductDTO dto = service.insert(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ProductDTO> update(@RequestBody @Valid RequestUpdateProductDTO data) {
        ProductDTO dto = service.update(data);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
