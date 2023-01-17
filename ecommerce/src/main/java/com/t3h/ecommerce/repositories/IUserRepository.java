package com.t3h.ecommerce.repositories;


import com.t3h.ecommerce.entities.core.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name); // Tìm kiếm User có tồn tai trong DB hay không?
    Boolean existsByUsername(String username);  // Kiểm tra xem Username cos tồn tại trong DB không?
    Boolean existsByEmail(String email); //  Kiểm tra xem email cos tồn tại trong DB không?
}
