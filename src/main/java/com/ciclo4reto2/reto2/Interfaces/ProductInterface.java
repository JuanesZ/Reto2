package com.ciclo4reto2.reto2.Interfaces;

import com.ciclo4reto2.reto2.model.Product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductInterface extends MongoRepository<Product, String> {

}
