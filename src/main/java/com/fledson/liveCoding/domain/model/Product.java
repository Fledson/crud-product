package com.fledson.liveCoding.domain.model;

import com.fledson.liveCoding.domain.model.dto.ProductDTO;
import com.fledson.liveCoding.domain.model.dto.RequestProductDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer price_in_cents;
    private Boolean active;

    public Product(ProductDTO dto) {
        BeanUtils.copyProperties(dto, this);
        this.active = true;
    }

    public Product(RequestProductDTO dto) {
        BeanUtils.copyProperties(dto, this);
        this.active = true;
    }
}
