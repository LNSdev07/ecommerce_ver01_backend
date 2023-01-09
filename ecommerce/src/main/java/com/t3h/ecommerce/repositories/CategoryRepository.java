package com.t3h.ecommerce.repositories;

import com.t3h.ecommerce.entities.product.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
