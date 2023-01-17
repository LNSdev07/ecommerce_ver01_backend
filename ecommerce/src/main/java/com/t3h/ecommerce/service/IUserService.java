package com.t3h.ecommerce.service;

import com.t3h.ecommerce.entities.core.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String name); // Tìm kiếm User có tồn tai trong DB hay không?
    Boolean existsByUsername(String username);  // Kiểm tra xem Username cos tồn tại trong DB không?
    Boolean existsByEmail(String email); //  Kiểm tra xem email cos tồn tại trong DB không?


    User save(User user);
}
