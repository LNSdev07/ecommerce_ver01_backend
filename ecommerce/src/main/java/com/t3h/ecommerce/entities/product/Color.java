package com.t3h.ecommerce.entities.product;


import com.t3h.ecommerce.entities.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "color")
public class Color extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "color_name")
    private String colorName;

    @Column(name ="color_code")
    private String colorCode;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
