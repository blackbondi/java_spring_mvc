package com.murtada.webshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.murtada.webshop.model.Product;
import com.murtada.webshop.model.Seller;

@Repository("sellerDao")
public class SellerDaoImpl extends AbstractDao<Integer, Seller> implements SellerDao {

	public Seller findById(int id) {
		return getByKey(id);
    }
	
	public void createSeller(Seller seller) {
		persist(seller);
	}

	public void editSeller(Seller seller) {
		persist(seller);
	}

	public void deleteSeller(String personnelNumber) {
		Query query = getSession().createSQLQuery("delete from seller where personnelNumber = :personnelNumber");
        query.setString("personnelNumber", personnelNumber);
        query.executeUpdate();	
	}

	public List<Seller> listAllSellers() {
		Criteria criteria = createEntityCriteria();
        return (List<Seller>) criteria.list();
	}
	
	public Seller findSellerByPersonnelNumber(String personnelNumber) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("personnelNumber", personnelNumber));
        return (Seller) criteria.uniqueResult();
    }
}
