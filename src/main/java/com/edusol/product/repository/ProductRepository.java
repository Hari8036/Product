package com.edusol.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusol.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByCategoryIgnoreCase(String category);

	List<Product> findBySubcategoryIgnoreCase(String subcategory);

	List<Product> findByNameIgnoreCase(String name);

	List<Product> findByPrice(float price);

	List<Product> findByPriceAndCategoryIgnoreCase(float price, String category);

	List<Product> findByPriceAndSubcategoryIgnoreCase(float price, String subcategory);

	List<Product> findByPriceBetween(float min, float max);

	List<Product> findByPriceBetweenAndCategoryIgnoreCase(float min, float max, String category);

	List<Product> findByPriceBetweenAndSubcategoryIgnoreCase(float min, float max, String subcategory);

}
