package com.ciclo4reto2.reto2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.ciclo4reto2.reto2.Interfaces.UserInterface;
import com.ciclo4reto2.reto2.model.User;

@Repository
public class UserRepository {
    @Autowired
    private UserInterface userMongoRepository;

    public List<User> getAll(){
        return (List<User>) userMongoRepository.findAll();
    }

    public Optional<User> getUser(int id){
        return userMongoRepository.findById(id);
    }

    public User create(User user){
        return userMongoRepository.save(user);
    }

    public void update(User user){
        userMongoRepository.save(user);
    }

    public void delete(User user){
        userMongoRepository.delete(user);
    }

    public boolean emailExists(String email){
        Optional<User> usuario = userMongoRepository.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> authenticateUser(String email, String password){
        return userMongoRepository.findByEmailAndPassword(email, password);
    }
}