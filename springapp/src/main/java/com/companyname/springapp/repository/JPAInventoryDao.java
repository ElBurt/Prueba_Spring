package com.companyname.springapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.companyname.springapp.domain.Inventory;

@Repository(value = "inventoryDao")
public class JPAInventoryDao implements InventoryDao {

    private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Inventory> getInventoryList() {
    	return em.createQuery("select i from Inventory i order by i.idInventory").getResultList();
	}

    @Transactional(readOnly = false)
	public void saveInventory(Inventory inventory) {
		em.merge(inventory);
		
	}

}