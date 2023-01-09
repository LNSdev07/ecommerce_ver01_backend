package com.t3h.ecommerce.repositories;

import com.t3h.ecommerce.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
