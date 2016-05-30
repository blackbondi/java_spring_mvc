package com.murtada.webshop.dao;

import java.util.List;

import com.murtada.webshop.model.Seller;

public interface SellerDao {

	Seller findById(int id);
	
	void createSeller(Seller seller);
	
	void editSeller(Seller seller);
	
	void deleteSeller(String personnelNumber);	
	
	List<Seller> listAllSellers();
	
	Seller findSellerByPersonnelNumber(String personnelNumber);

}
