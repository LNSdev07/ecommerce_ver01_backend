package com.t3h.ecommerce.entities.product;

import com.t3h.ecommerce.entities.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "discount")
public class Discount extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "discount_Name")
    private String discountName;


    @Column(name = "discount_percent")
    private Float discountPercent;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
