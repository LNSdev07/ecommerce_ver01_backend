package com.t3h.ecommerce.service.Impl;

import com.t3h.ecommerce.entities.core.User;
import com.t3h.ecommerce.repositories.IUserRepository;
import com.t3h.ecommerce.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    @Autowired
    private final IUserRepository repository;

    @Override
    public Optional<User> findByUsername(String name) {
        return repository.findByUsername(name);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }
}
