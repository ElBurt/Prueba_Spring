package com.companyname.springapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.companyname.springapp.domain.Inventory;
import com.companyname.springapp.domain.Product;

public interface InventoryRepository extends CrudRepository<Inventory, Integer>, InventoryRepositoryCustom {
	public List<Inventory> findByIdInventory(Integer idInventory);
	public List<Inventory> findByProductRef(Product productRef);
	public List<Inventory> findByQuantity(Integer quantity);

}