package com.companyname.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.companyname.springapp.domain.Product;
import com.companyname.springapp.repository.ProductRepository;

@Component
public class SimpleProductManager implements ProductManager {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ProductRepository productRepository;

    public void setProductDao(ProductRepository productDao) {
        this.productRepository = productDao;
    }

    public List<Product> getProducts() {
    	System.out.println("HA ENTRADO.........");
    	List<Product> prod = productRepository.findByDescription("Lamp");
    	System.out.println("sldkfjalsjfñasldfj: " + prod.get(1).getPrice());
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