package com.edusol.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.product.model.Product;
import com.edusol.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductService productService;

	@GetMapping("/get-products")
	public Object getAllProduct() {
		@SuppressWarnings("unchecked")
		List<Product> product = (List<Product>) productService.getAllProduct();
		logger.info(product.toString());
		return product;

	}

	@PostMapping("/add-product")
	public Object AddProduct(@RequestBody Product product) {
		logger.info(product.toString());
		return productService.AddProduct(product);
	}

	@GetMapping("/get-product-by-id")
	public Object getProductById(@RequestParam int id) {
		Object product = productService.getProductById(id);
		logger.info(product.toString());
		return product;
	}

	@GetMapping("/get-product-name")
	public Object getProductByName(@RequestParam String name) {
		//@SuppressWarnings("unchecked")
		//List<Product> product = (List<Product>) 
		return productService.getProductByName(name);
		//logger.info(product.toString());
		//return product;

	}

	@GetMapping("/get-product-by-category")
	public Object getProductByCategory(@RequestParam String category) {
		//@SuppressWarnings("unchecked")
		//List<Product> product = (List<Product>) 
		return productService.getProductByCategory(category);
		//logger.info(product.toString());
		//return product;

	}

	@GetMapping("/get-product-by-subcategory")
	public Object getProductBySubcategory(@RequestParam String subcategory) {
		//@SuppressWarnings("unchecked")
		//List<Product> product = (List<Product>) 
		return productService.getProducBySubcategory(subcategory);
		//logger.info(product.toString());
		//return product;

	}

	@GetMapping("/get-product-price")
	public Object getProductPrice(@RequestParam float price) {
		@SuppressWarnings("unchecked")
		List<Product> product = (List<Product>) productService.getProductPrice(price);
		logger.info(product.toString());
		return product;

	}

	@GetMapping("/get-product-price-and-category")
	public Object getProductByPriceandCategory(@RequestParam float price, @RequestParam String category) {
		@SuppressWarnings("unchecked")
		List<Product> product = (List<Product>) productService.getProductByPriceandCategory(price, category);
		logger.info(product.toString());
		return product;
	}

	@GetMapping("/get-product-price-and-subcategory")
	public Object getProductByPriceandSubcategory(@RequestParam float price, @RequestParam String subcategory) {
		@SuppressWarnings("unchecked")
		List<Product> product = (List<Product>) productService.getProductByPriceandSubCategory(price, subcategory);
		logger.info(product.toString());
		return product;
	}

	@GetMapping("/get-product-price-by-range")
	public Object getProductPriceByRange(@RequestParam float min, float max) {
		@SuppressWarnings("unchecked")
		List<Product> product = (List<Product>) productService.getProductPriceByRange(min, max);
		logger.info(product.toString());
		return product;
	}

	@GetMapping("/get-product-pricerange-AndCategory")
	public Object getProductPriceRangeAndCategory(@RequestParam float min, float max, String category) {
		@SuppressWarnings("unchecked")
		List<Product> product = (List<Product>) productService.getProductPriceRangeAndCategory(min, max, category);
		logger.info(product.toString());
		return product;
	}

	@GetMapping("/get-product-pricerange-andsubcategory")
	public Object getProductPriceRangeAndsubcategory(@RequestParam float min, float max,
			@RequestParam String subcategory) {
		@SuppressWarnings("unchecked")
		List<Product> product = (List<Product>) productService.getProductPriceRangeAndsubcategory(subcategory, min,
				max);
		logger.info(product.toString());
		return product;

	}

	@PutMapping("/update-product")
	public Object updateProduct(@RequestBody Product product) {
		logger.info("Product details:" + product.toString());
		return productService.updateProduct(product);
	}
	@DeleteMapping("/delete-product")
	public Object deleteProduct(@RequestParam int id)
	{
		logger.info("Product Id:"+id);
		return productService.deleteProduct(id);
	}

}
