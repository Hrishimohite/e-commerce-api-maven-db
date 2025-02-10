package org.dnyayog.controller;

import java.sql.SQLException;

import org.dnyayog.dto.ProductRequest;
import org.dnyayog.dto.ProductResponse;
import org.dnyayog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping(path = "/product", produces = {"application/json", "application/xml"}, consumes = {"application/json", "application/xml"})
	public ProductResponse addProduct(@RequestBody ProductRequest product) {
		return productService.addProduct(product);
	}
	
	@GetMapping(path = "/getByName/{productName}", produces = {"application/json", "application/xml"})
	public ProductResponse getProduct(@PathVariable String productName) throws SQLException{
		ProductRequest request = new ProductRequest();
		request.setProductName(productName);
		return productService.getProduct(request);
	}
	
	@GetMapping(path = "/getProducts", produces = {"application/json", "application/xml"})
	public ProductResponse displayProduct() throws SQLException{
		return productService.displayProduct();
	}

}
