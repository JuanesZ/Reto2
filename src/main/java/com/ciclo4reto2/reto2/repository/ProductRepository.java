package com.ciclo4reto2.reto2.repository;

import com.ciclo4reto2.reto2.Interfaces.ProductInterface;
import com.ciclo4reto2.reto2.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    @Autowired
    private ProductInterface productMongoRepository;

    public List<Product> getAll(){
        return (List<Product>) productMongoRepository.findAll();
    }

    public Optional<Product> getProduct(String reference){
        return productMongoRepository.findById(reference);
    }

    public Product create(Product product){
        return productMongoRepository.save(product);
    }

    public void update(Product product){
        productMongoRepository.save(product);
    }

    public void delete(Product product){
        productMongoRepository.delete(product);
    }
}
