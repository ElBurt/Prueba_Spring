package com.companyname.springapp.repository;

import java.util.List;

import com.companyname.springapp.domain.Product;

public class InMemoryProductDao implements ProductRepositoryCustom {

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

}