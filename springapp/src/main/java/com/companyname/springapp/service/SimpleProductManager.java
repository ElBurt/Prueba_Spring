package com.companyname.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.companyname.springapp.domain.Product;
import com.companyname.springapp.repository.ProductRepository;

@Component
public class SimpleProductManager implements ProductManager {

    private static final long serialVersionUID = 1L;

    private ProductRepository productRepository;
    
    @Autowired
    public SimpleProductManager(ProductRepository productRepository) {
    	//TODO ARH este assert hay que ver como se valida, ya que es como los de junit pero hay varios imports a usar
		Assert.notNull(productRepository, "productRepository must not be null!");
		this.productRepository = productRepository;
    }

    public void setProductDao(ProductRepository productDao) {
        this.productRepository = productDao;
    }

    public List<Product> getProducts() {
    	System.out.println("HA ENTRADO.........");
        return productRepository.getProductList();
    }

    public void increasePrice(int percentage) {
        List<Product> products = productRepository.getProductList();
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrice(newPrice);
                productRepository.saveProduct(product);
            }
        }
    }

	public void createProduct(CreateProduct data) {
		Product product = new Product();
		product.setDescription(data.getDescription());
		product.setPrice(data.getPrice());
		productRepository.saveProduct(product);
		
	}
	
	 public Product getProductByProductId(Integer productId){
	        return productRepository.getProductByProductId(productId);
	    }
}