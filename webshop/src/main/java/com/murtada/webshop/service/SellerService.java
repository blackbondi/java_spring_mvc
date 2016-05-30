package com.murtada.webshop.service;

import java.util.List;

import com.murtada.webshop.model.Seller;

public interface SellerService {

	void createSeller(Seller seller);
	
	void editSeller(Seller seller);
	
	void deleteSeller(String personnelNumber);	
	
	List<Seller> listAllSellers();
	
	boolean isSellerPersonnelNumberUnique(Integer id, String personnelNumber);
	
	Seller findSellerByPersonnelNumber(String personnelNumber);
	
}
