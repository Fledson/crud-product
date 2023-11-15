package com.fledson.liveCoding.domain.model.dto;

import com.fledson.liveCoding.domain.model.Product;
import jakarta.validation.constraints.NotNull;
import org.aspectj.weaver.patterns.WithinAnnotationPointcut;
import org.springframework.beans.BeanUtils;

public record ProductDTO(
        String id,
        String name,
        Integer price_in_cents
) {
        public ProductDTO(Product product) {
                this(product.getId(), product.getName(), product.getPrice_in_cents());
        }
}
