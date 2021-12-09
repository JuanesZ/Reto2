package com.ciclo4reto2.reto2.Interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

import com.ciclo4reto2.reto2.model.User;

public interface UserInterface extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);
}