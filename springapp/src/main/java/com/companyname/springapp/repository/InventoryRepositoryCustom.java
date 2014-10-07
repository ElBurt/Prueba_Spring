package com.companyname.springapp.repository;

/*TODO ARH ESTA ERA INVENTORYDAO*/

import java.util.List;

import com.companyname.springapp.domain.Inventory;

public interface InventoryRepositoryCustom {

    public List<Inventory> getInventoryList();

    public void saveInventory(Inventory inventory);

}