package com.companyname.springapp.service;

import java.io.Serializable;
import java.util.List;

import com.companyname.springapp.domain.Inventory;

public interface InventoryManager extends Serializable {
    
    public List<Inventory> getInventories();
    public void createInventory(CreateInventory data);

}