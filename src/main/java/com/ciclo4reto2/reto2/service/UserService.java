package com.ciclo4reto2.reto2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.ciclo4reto2.reto2.model.User;
import com.ciclo4reto2.reto2.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userMongoRepository;

    public List<User> getAll(){
        return userMongoRepository.getAll();
    }

    public Optional<User> getUser(int id){
        return userMongoRepository.getUser(id);
    }

    public User create(User user){
        if (user.getId() == null){
            return user;
        }else{
            Optional<User> e = userMongoRepository.getUser(user.getId());
            if (e.isEmpty()){
                if (emailExists(user.getEmail()) == false){
                    return userMongoRepository.create(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }
        }
    }

    public User update(User user){
        if (user.getId() != null){
            Optional<User> userDb = userMongoRepository.getUser(user.getId());
            if (!userDb.isEmpty()){
                if (user.getIdentification() != null){
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null){
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null){
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null){
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null){
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null){
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null){
                    userDb.get().setZone(user.getZone());
                }
                userMongoRepository.update(userDb.get());
                return userDb.get();
            }else{
                return user;
            }
        }else{
            return user;
        }
    }

    public boolean delete(int userId){
        Boolean aBoolean = getUser(userId).map(user -> {
            userMongoRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public boolean emailExists(String email){
        return userMongoRepository.emailExists(email);
    }

    public User authenticateUser(String email, String password){
        Optional<User> usuario = userMongoRepository.authenticateUser(email, password);
        if (usuario.isEmpty()){
            return new User();
        }else{
            return usuario.get();
        }
    }
}