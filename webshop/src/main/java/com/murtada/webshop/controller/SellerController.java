package com.murtada.webshop.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.murtada.webshop.model.Seller;
import com.murtada.webshop.service.SellerService;

@Controller
public class SellerController {

	@Autowired
	SellerService sellerService;
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/listAllSellers" }, method = RequestMethod.GET)
	public String listAllSellers(ModelMap model) {
		List<Seller> sellers = sellerService.listAllSellers();
		model.addAttribute("sellers", sellers);
		return "sellers/list";
	}

	/*
	 * This method will provide the view to create a new seller.
	 */
	@RequestMapping(value = { "/createSeller" }, method = RequestMethod.GET)
	public String createSellerForm(ModelMap model) {
		Seller seller = new Seller();
		model.addAttribute("seller", seller);
		return "sellers/detail";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving seller in database. It also validates the user input
	 */
	@RequestMapping(value = { "/createSeller" }, method = RequestMethod.POST)
	public String createSeller(@Valid Seller seller, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "sellers/detail";
		}

		if(!sellerService.isSellerPersonnelNumberUnique(seller.getId(), seller.getPersonnelNumber())){
			FieldError error = 
					new FieldError("seller", "personnelNumber", 
							messageSource.getMessage("unique.seller.personnelNumber", 
									new String[]{seller.getPersonnelNumber()}, Locale.getDefault()));
		    result.addError(error);
			return "sellers/detail";
		}

		sellerService.createSeller(seller);

		model.addAttribute("success", "Seller " + seller.getName()	+ " created successfully");
		return "sellers/success";
	}

	/*
	 * This method will provide the view to edit an existing seller.
	 */
	@RequestMapping(value = { "/edit-seller-{personnelNumber}" }, method = RequestMethod.GET)
	public String editSellerForm(@PathVariable String personnelNumber, ModelMap model) {
		Seller seller = sellerService.findSellerByPersonnelNumber(personnelNumber);
		model.addAttribute("seller", seller);
		return "sellers/detail";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * editing seller in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-seller-{personnelNumber}" }, method = RequestMethod.POST)
	public String editSeller(@Valid Seller seller, BindingResult result,
			ModelMap model, @PathVariable String personnelNumber) {

		if (result.hasErrors()) {
			return "sellers/detail";
		}

		if(!sellerService.isSellerPersonnelNumberUnique(seller.getId(), seller.getPersonnelNumber())){
			FieldError error = 
					new FieldError("seller", "personnelNumber", 
							messageSource.getMessage("unique.seller.personnelNumber", 
									new String[]{seller.getPersonnelNumber()}, Locale.getDefault()));
		    result.addError(error);
			return "sellers/detail";
		}

		sellerService.editSeller(seller);

		model.addAttribute("success", "Seller " + seller.getName() + " updated successfully");
		return "sellers/success";
	}

	@RequestMapping(value = { "/delete-seller-{personnelNumber}" }, method = RequestMethod.GET)
	public String deleteSeller(@PathVariable String personnelNumber) {
		sellerService.deleteSeller(personnelNumber);
		return "redirect:/listAllSellers";
	}

}
