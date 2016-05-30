package com.murtada.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.murtada.webshop.dao.SellerDao;
import com.murtada.webshop.model.Seller;

@Service("sellerService")
@Transactional
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerDao dao;

	public void createSeller(Seller seller) {
		dao.createSeller(seller);
	}
	
	public void editSeller(Seller seller) {
		Seller entity = dao.findById(seller.getId());
        if(entity != null){
            entity.setName(seller.getName());
            entity.setPersonnelNumber(seller.getPersonnelNumber());
        }
	}

	public void deleteSeller(String personnelNumber) {
		dao.deleteSeller(personnelNumber);
	}
	
	public List<Seller> listAllSellers() {
		return dao.listAllSellers();
	}
	
	public boolean isSellerPersonnelNumberUnique(Integer id, String personnelNumber) {
        Seller seller = findSellerByPersonnelNumber(personnelNumber);
        return ( seller == null || ((id != null) && (seller.getId() == id)));
    }
	
	public Seller findSellerByPersonnelNumber(String personnelNumber) {
		return dao.findSellerByPersonnelNumber(personnelNumber);
	}

}
