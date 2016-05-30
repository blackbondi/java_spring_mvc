package com.murtada.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.murtada.webshop.dao.ProductDao;
import com.murtada.webshop.model.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	public void addProduct(Product product) {
		dao.addProduct(product);
	}
	
	public void editProduct(Product product) {
		Product entity = dao.findById(product.getId());
        if(entity != null){
            entity.setName(product.getName());
            entity.setNumber(product.getNumber());
            entity.setCount(product.getCount());
        }
	}

	public void deleteProduct(String number) {
		dao.deleteProduct(number);
	}
	
	public List<Product> listAllProducts() {
		return dao.listAllProducts();
	}
	
	public boolean isProductNumberUnique(Integer id, String number) {
        Product product = findProductByNumber(number);
        return ( product == null || ((id != null) && (product.getId() == id)));
    }
	
	public Product findProductByNumber(String number) {
		return dao.findProductByNumber(number);
	}

	public boolean isProductAvailable(String number) {
		return dao.isProductAvailable(number);
	}
}
