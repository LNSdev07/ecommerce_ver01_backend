package com.t3h.ecommerce.entities.product;


import com.t3h.ecommerce.entities.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "size")
public class Size extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "size_code")
    private String signCode;

    @Column(name = "size_name")
    private String sizeName;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
