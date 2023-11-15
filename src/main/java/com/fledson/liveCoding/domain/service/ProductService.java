package com.fledson.liveCoding.domain.service;

import com.fledson.liveCoding.domain.model.Product;
import com.fledson.liveCoding.domain.model.dto.ProductDTO;
import com.fledson.liveCoding.domain.model.dto.RequestProductDTO;
import com.fledson.liveCoding.domain.model.dto.RequestUpdateProductDTO;
import com.fledson.liveCoding.domain.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDTO> getAll() {
        List<Product> list = repository.findAllByActiveTrue();
        return list.stream().map(ProductDTO::new).toList();
    }

    @Transactional
    public ProductDTO insert(RequestProductDTO dto) {
        Product product = new Product(dto);
        product = repository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update(RequestUpdateProductDTO data){
        Product product = repository.findById( data.id() )
                            .orElseThrow(
                                    () -> new EntityNotFoundException("Produto não existe")
                            );

        BeanUtils.copyProperties(data, product, "id");

        return new ProductDTO(product);
    }

    @Transactional
    public void delete(String id) {
        Product product = repository.findById(id)
                            .orElseThrow( () -> new EntityNotFoundException("Produto não existe") );

        product.setActive(false);
    }

}
