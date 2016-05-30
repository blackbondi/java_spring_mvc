package com.murtada.webshop.dao;

import java.util.List;

import com.murtada.webshop.model.Product;

public interface ProductDao {

	Product findById(int id);
	
	void addProduct(Product product);
	
	void editProduct(Product product);
	
	void deleteProduct(String number);	
	
	List<Product> listAllProducts();
	
	Product findProductByNumber(String number);

	boolean isProductAvailable(String number);

}
