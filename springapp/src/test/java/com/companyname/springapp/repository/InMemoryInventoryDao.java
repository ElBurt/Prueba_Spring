package com.companyname.springapp.repository;

import java.util.List;

import com.companyname.springapp.domain.Inventory;
import com.companyname.springapp.domain.Product;

public class InMemoryInventoryDao implements InventoryRepository {
	
    private List<Inventory> inventoryList;
    
    
    
    public InMemoryInventoryDao(List<Inventory> inventoryList) {
		this.inventoryList = inventoryList;
	}

	public List<Inventory> getInventoryList() {
		return this.inventoryList;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Integer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Inventory arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable<? extends Inventory> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<Inventory> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Inventory> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Inventory findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Inventory> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Inventory> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		
	}

	public List<Inventory> findByIdInventory(Integer idInventory) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Inventory> findByProductRef(Product productRef) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Inventory> findByQuantity(Integer quantity) {
		// TODO Auto-generated method stub
		return null;
	}

}
