package com.t3h.ecommerce.entities.core;


import com.t3h.ecommerce.entities.BaseEntity;
import com.t3h.ecommerce.entities.order.Orders;
import com.t3h.ecommerce.entities.product.Category;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "status")
    private Integer status;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;


    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Orders> orders;
}
