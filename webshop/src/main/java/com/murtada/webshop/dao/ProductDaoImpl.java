package com.murtada.webshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.murtada.webshop.model.Product;


@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

	public Product findById(int id) {
		return getByKey(id);
    }
	
	public void addProduct(Product product) {
		persist(product);
	}

	public void editProduct(Product product) {
		persist(product);
	}

	public void deleteProduct(String number) {
		Query query = getSession().createSQLQuery("delete from product where number = :number");
        query.setString("number", number);
        query.executeUpdate();	
	}

	public List<Product> listAllProducts() {
		Criteria criteria = createEntityCriteria();
        return (List<Product>) criteria.list();
	}
	
	public Product findProductByNumber(String number) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("number", number));
        return (Product) criteria.uniqueResult();
    }

	public boolean isProductAvailable(String number) {
		return findProductByNumber(number).getCount() < 0;
	}
}
