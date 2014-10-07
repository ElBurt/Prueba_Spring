package com.companyname.springapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.companyname.springapp.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>, ProductRepositoryCustom {
	public List<Product> findByDescription(String Description);

}