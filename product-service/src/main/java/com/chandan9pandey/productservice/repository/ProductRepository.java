package com.chandan9pandey.productservice.repository;

import com.chandan9pandey.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
