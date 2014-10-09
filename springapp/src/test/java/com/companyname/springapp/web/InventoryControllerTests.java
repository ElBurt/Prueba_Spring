package com.companyname.springapp.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.springapp.domain.Inventory;
import com.companyname.springapp.domain.Product;
import com.companyname.springapp.repository.InMemoryInventoryDao;
import com.companyname.springapp.repository.InMemoryProductDao;
import com.companyname.springapp.service.SimpleInventoryManager;
import com.companyname.springapp.service.SimpleProductManager;

public class InventoryControllerTests {

    @Test
    public void testHandleRequestView() throws Exception{		
        InventoryController controller = new InventoryController();
        InMemoryProductDao productDao = new InMemoryProductDao(new ArrayList<Product>());
        InMemoryInventoryDao inventoryDao = new InMemoryInventoryDao(new ArrayList<Inventory>());
        SimpleProductManager spm = new SimpleProductManager(productDao);
        SimpleInventoryManager sim = new SimpleInventoryManager(inventoryDao, productDao);
        controller.setProductManager(spm);
        controller.setInventoryManager(sim);
        //controller.setProductManager(new SimpleProductManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
	@SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }
}