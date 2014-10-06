package com.companyname.springapp.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class InventoryTests {

    private Inventory inventory;

    @Before
    public void setUp() throws Exception {
        inventory = new Inventory();
    }

    @Test
    public void testSetAndGetProductRef() {
        Product testProductRef = new Product();
        assertNull(inventory.getProductRef());
        inventory.setProductRef(testProductRef);
        assertEquals(testProductRef, inventory.getProductRef());
    }

    @Test
    public void testSetAndGetQuantity() {
        Integer testQuantity = 1;
        assertNull(inventory.getQuantity());
        inventory.setQuantity(testQuantity);
        assertEquals(testQuantity, inventory.getQuantity());
    }

}