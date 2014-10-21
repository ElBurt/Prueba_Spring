package com.companyname.springapp.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.companyname.springapp.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class})
@Transactional
@ContextConfiguration(locations = {"classpath:test-context.xml"})
public class JPAProductDaoTestsSpring {

    @Autowired
	private ProductRepository productRepository;
	
	@Test
	public void testGetProductByProductId() {
		Product product = productRepository.getProductByProductId(1);
		Assert.assertNotNull(product);
		System.out.println("First Name: " + product.getDescription());
	}
	
	@Test
	public void testGetNumberProductsRepeated() {
		Long number = productRepository.getNumberProductsRepeated("Lamp");
		Assert.assertNotNull(number);
		System.out.println("Numero Lamp: " + number);
	}
	
	
    @Test
    public void testGetProductList() {
        List<Product> products = productRepository.getProductList();
        assertEquals(products.size(), 3, 0);	   
    }

    @Test
    public void testSaveProduct() {
        List<Product> products = productRepository.getProductList();

        Product p = products.get(0);
        Double price = p.getPrice();
        p.setPrice(200.12);
        productRepository.saveProduct(p);

        List<Product> updatedProducts = productRepository.getProductList();
        Product p2 = updatedProducts.get(0);
        assertEquals(p2.getPrice(), 200.12, 0);

        p2.setPrice(price);
        productRepository.saveProduct(p2);
    }
	


}