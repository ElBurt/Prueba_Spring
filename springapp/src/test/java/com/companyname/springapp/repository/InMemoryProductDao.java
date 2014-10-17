package com.companyname.springapp.repository;

import java.util.List;

import com.companyname.springapp.domain.Product;

public class InMemoryProductDao implements ProductRepository {

    private List<Product> productList;

    public InMemoryProductDao(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void saveProduct(Product prod) {
    }

	public Product getProductByProductId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Integer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Product arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable<? extends Product> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Product> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Product> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Product> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findByDescription(String Description) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findByPrice(Double price) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getNumberProductsRepeated(String description) {
		// TODO Auto-generated method stub
		return null;
	}

}