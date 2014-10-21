package com.companyname.springapp.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.companyname.springapp.domain.Product;


public class JPAProductDaoTests {

    private ApplicationContext context;
    @Autowired
    private ProductRepository productDao;

    @Before
    public void setUp() throws Exception {
    	System.out.println("Entrando");
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        productDao = (ProductRepository) context.getBean("productRepository");
        String[] tmp = context.getBeanDefinitionNames();
        int sizea = tmp.length;
        System.out.println("Tamaño: " + sizea);
        for (int i = 0; i < sizea; i++) {
			System.out.println(tmp[i]);
		}
    }

    @Test
    public void testGetProductList() {
        List<Product> products = productDao.getProductList();
        assertEquals(products.size(), 15, 0);	   
    }

    @Test
    public void testSaveProduct() {
        List<Product> products = productDao.getProductList();

        Product p = products.get(0);
        Double price = p.getPrice();
        p.setPrice(200.12);
        productDao.saveProduct(p);

        List<Product> updatedProducts = productDao.getProductList();
        Product p2 = updatedProducts.get(0);
        assertEquals(p2.getPrice(), 200.12, 0);

        p2.setPrice(price);
        productDao.saveProduct(p2);
    }
}