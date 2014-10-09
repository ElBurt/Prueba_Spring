package com.companyname.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.companyname.springapp.domain.Inventory;
import com.companyname.springapp.repository.InventoryRepository;
import com.companyname.springapp.repository.ProductRepository;

@Component
public class SimpleInventoryManager implements InventoryManager {

    private static final long serialVersionUID = 1L;

    private InventoryRepository inventoryRepository;
    private ProductRepository productRepository;
    
    @Autowired
    public SimpleInventoryManager(InventoryRepository inventoryRepository, ProductRepository productRepository) {
    	//TODO ARH este assert hay que ver como se valida, ya que es como los de junit pero hay varios imports a usar
    	//Aparte parece un engorro para validar con junit con este constructor en vez de inyectar autowired en la declaracion
    	//de las variables.
		Assert.notNull(inventoryRepository, "inventoryRepository must not be null!");
		Assert.notNull(productRepository, "productRepository must not be null!");
		this.inventoryRepository = inventoryRepository;
		this.productRepository = productRepository;
    }
    
    public void setInventoryDao(InventoryRepository inventoryDao) {
        this.inventoryRepository = inventoryDao;
    }

    public List<Inventory> getInventories() {
    	System.out.println("HA ENTRADO INVENTORY..-..-.-.");
    	System.out.println("TOTAL INVENTARIOS: " + inventoryRepository.count());
    	System.out.println("Existe el 3: " + inventoryRepository.exists(3));
    	System.out.println("findByIdInventory 10: " + inventoryRepository.findByIdInventory(10));
    	System.out.println("findByProductRef 2: " + inventoryRepository.findByProductRef(productRepository.getProductByProductId(2)));
    	System.out.println("Existe el 5 con desc: " + inventoryRepository.findByQuantity(4));
    	
        return inventoryRepository.getInventoryList();
    }
    
    public void setProductDao(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
	public void createInventory(CreateInventory data) {
		Inventory inventory = new Inventory();
		inventory.setProductRef(productRepository.getProductByProductId(data.getProductRef()));
		inventory.setQuantity(data.getQuantity());
		inventoryRepository.saveInventory(inventory);
		
	}

}