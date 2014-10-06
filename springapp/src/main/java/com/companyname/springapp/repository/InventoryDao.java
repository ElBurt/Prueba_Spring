package com.companyname.springapp.repository;

import java.util.List;

import com.companyname.springapp.domain.Inventory;

public interface InventoryDao {

    public List<Inventory> getInventoryList();

    public void saveInventory(Inventory inventory);

}