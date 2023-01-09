package com.t3h.ecommerce.entities.core;

import com.t3h.ecommerce.entities.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "role")
public class Role extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false, length = 20)
    private String code;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> user;
}
