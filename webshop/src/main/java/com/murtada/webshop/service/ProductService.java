package com.murtada.webshop.service;

import java.util.List;

import com.murtada.webshop.model.Product;

public interface ProductService {

	void addProduct(Product product);
	
	void editProduct(Product product);
	
	void deleteProduct(String personnelNumber);	
	
	List<Product> listAllProducts();
	
	boolean isProductNumberUnique(Integer id, String number);
	
	Product findProductByNumber(String number);
	
	boolean isProductAvailable(String number);
	
}
