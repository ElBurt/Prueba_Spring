package com.companyname.springapp.repository;

import java.util.List;

import com.companyname.springapp.domain.Product;

public interface ProductRepositoryCustom {

    public List<Product> getProductList();

    public void saveProduct(Product prod);
    
    public Product getProductByProductId(Integer productId);

}