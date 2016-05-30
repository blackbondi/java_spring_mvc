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

import com.murtada.webshop.model.Product;
import com.murtada.webshop.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/listAllProducts" }, method = RequestMethod.GET)
	public String listAllProducts(ModelMap model) {
		List<Product> products = productService.listAllProducts();
		model.addAttribute("products", products);
		return "products/list";
	}

	/*
	 * This method will provide the view to create a new product.
	 */
	@RequestMapping(value = { "/addProduct" }, method = RequestMethod.GET)
	public String addProductForm(ModelMap model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "products/detail";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving product in database. It also validates the user input
	 */
	@RequestMapping(value = { "/addProduct" }, method = RequestMethod.POST)
	public String addProduct(@Valid Product product, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "products/detail";
		}

		if(!productService.isProductNumberUnique(product.getId(), product.getNumber())){
			FieldError error = 
					new FieldError("product", "number", 
							messageSource.getMessage("unique.product.number", 
									new String[]{product.getNumber()}, Locale.getDefault()));
		    result.addError(error);
			return "products/detail";
		}

		productService.addProduct(product);

		model.addAttribute("success", "Product " + product.getName() + " created successfully");
		return "products/success";
	}

	/*
	 * This method will provide the view to edit an existing product.
	 */
	@RequestMapping(value = { "/edit-product-{number}" }, method = RequestMethod.GET)
	public String editProductForm(@PathVariable String number, ModelMap model) {
		Product product = productService.findProductByNumber(number);
		model.addAttribute("product", product);
		return "products/detail";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * editing product in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-product-{number}" }, method = RequestMethod.POST)
	public String editProduct(@Valid Product product, BindingResult result,
			ModelMap model, @PathVariable String number) {

		if (result.hasErrors()) {
			return "products/detail";
		}

		if(!productService.isProductNumberUnique(product.getId(), product.getNumber())){
			FieldError error = 
					new FieldError("product", "number", 
							messageSource.getMessage("unique.product.number", 
									new String[]{product.getNumber()}, Locale.getDefault()));
		    result.addError(error);
			return "products/detail";
		}

		productService.editProduct(product);

		model.addAttribute("success", "Product " + product.getName() + " updated successfully");
		return "products/success";
	}

	@RequestMapping(value = { "/delete-product-{number}" }, method = RequestMethod.GET)
	public String deleteProduct(@PathVariable String number) {
		productService.deleteProduct(number);
		return "redirect:/listAllProducts";
	}

}
