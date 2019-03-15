package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.Product;

public interface ProductService {

	List<Product> getAllProducts();
	List<String> getCategoriesNames();
	boolean insertProduct(Product product);
	boolean checkProduct(Product product);
	boolean persistProduct(Product product);
}
