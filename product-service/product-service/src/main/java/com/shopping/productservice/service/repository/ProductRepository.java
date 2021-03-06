package com.shopping.productservice.service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shopping.productservice.model.Products;

@Repository
public interface ProductRepository extends MongoRepository<Products,String> {
	
	public List<Products> findProductByCategory(String category);
	

}
