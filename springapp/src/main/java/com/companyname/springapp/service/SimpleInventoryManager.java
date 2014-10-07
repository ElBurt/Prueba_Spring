package com.companyname.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.companyname.springapp.domain.Inventory;
import com.companyname.springapp.domain.Product;
import com.companyname.springapp.repository.InventoryDao;
import com.companyname.springapp.repository.ProductDao;

@Component
public class SimpleInventoryManager implements InventoryManager {

    private static final long serialVersionUID = 1L;

    @Autowired
    private InventoryDao inventoryDao;

    public void setInventoryDao(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    public List<Inventory> getInventories() {
        return inventoryDao.getInventoryList();
    }
    
    @Autowired
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProducts() {
        return productDao.getProductList();
    }
    
	public void createInventory(CreateInventory data) {
		Inventory inventory = new Inventory();
		inventory.setProductRef(productDao.getProductByProductId(data.getProductRef()));
		inventory.setQuantity(data.getQuantity());
		inventoryDao.saveInventory(inventory);
		
	}

}