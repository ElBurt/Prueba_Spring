package com.companyname.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.companyname.springapp.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>, ProductRepositoryCustom {
	public List<Product> findByDescription(String Description);
	public List<Product> findById(Integer id);
	public List<Product> findByPrice(Double price);
	
	@Query("select count(p) from Product p where p.description = ?1")  
    public Long getNumberProductsRepeated(String description);  

}