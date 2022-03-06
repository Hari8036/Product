package com.edusol.product.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edusol.product.model.Product;
import com.edusol.product.repository.ProductRepository;

import com.google.gson.JsonObject;

@Service
public class ProductService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductRepository productRepository;

	public Object getAllProduct() {
		return productRepository.findAll();
	}

	public Object AddProduct(Product product) {
		logger.info(product.toString());
		productRepository.save(product);
		logger.info("Product Added Successfully");
		return new ResponseEntity<>("Product Added Successfully", HttpStatus.CREATED);

	}

	public Object getProductById(int id) {
		return productRepository.findById(id);

	}

	public Object getProductByName(String name) {
		List<Product>product=productRepository.findByNameIgnoreCase(name);
		if(product.isEmpty())
		{
			return "Product Not Available";
		}
		return product;
	}

	public Object getProductByCategory(String category) {
		List<Product>product=productRepository.findByCategoryIgnoreCase(category);
		if(product.isEmpty())
		{
			return "Product Category Not available";
		}
		return product;
	}

	public Object getProducBySubcategory(String subcategory) {
		List<Product>product=productRepository.findBySubcategoryIgnoreCase(subcategory);
		if(product.isEmpty()) {
			return "Product SubCategory Not Available";
		}
		return product;
	}

	public Object getProductPrice(float price) {
		return productRepository.findByPrice(price);
	}

	public Object getProductByPriceandCategory(float price, String category) {
		return productRepository.findByPriceAndCategoryIgnoreCase(price, category);
	}

	public List<Product> getProductByPriceandSubCategory(float price, String subcategory) {
		return productRepository.findByPriceAndSubcategoryIgnoreCase(price, subcategory);

	}

	public Object getProductPriceByRange(float min, float max) {

		return productRepository.findByPriceBetween(min, max);
	}

	public Object getProductPriceRangeAndCategory(float min, float max, String category) {
		return productRepository.findByPriceBetweenAndCategoryIgnoreCase(min, max, category);
	}

	public List<Product> getProductPriceRangeAndsubcategory(String subcategory, float min, float max) {
		return productRepository.findByPriceBetweenAndSubcategoryIgnoreCase(min, max, subcategory);

	}

	public Object updateProduct(Product product) {
		JsonObject response = new JsonObject();

		System.out.println("Request product:" + product);
		int id = product.getId();
		try {

			Product product1 = productRepository.getOne(id);
			System.out.println("Request products :" + product1);

			System.out.println("old products:" + product1);
			product1.setPrice(product.getPrice());
			System.out.println("New products:" + product1);
			productRepository.save(product1);
		} catch (Exception e) {
			logger.error(e.getMessage());

			response.addProperty("statusCode", 404);
			response.addProperty("statusMessage", e.getMessage());

			return new ResponseEntity<>(response.toString(), HttpStatus.NOT_FOUND);

		}
		logger.info("Products updated Successfully");
		return new ResponseEntity<>("Products updated succesfully", HttpStatus.OK);

	}

	public Object deleteProduct(int id) {
		try {
			productRepository.deleteById(id);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		logger.info("Product Deleted Successfully");
		return new ResponseEntity<>("Product Deleted Successfully", HttpStatus.OK);

	}
}