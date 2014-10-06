package com.companyname.springapp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.springapp.service.CreateInventory;
import com.companyname.springapp.service.InventoryManager;
import com.companyname.springapp.service.ProductManager;

@Controller
@RequestMapping(value="/createinventory.htm")
public class CreateInventoryFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ProductManager productManager;
    
    @Autowired
    private InventoryManager inventoryManager;
    
   /* @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String now = (new Date()).toString();
        logger.info("Returning createInventory view with " + now);

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("products", this.productManager.getProducts());
        myModel.put("inventories", this.inventoryManager.getInventories());
        CreateInventory createInventory = new CreateInventory();
        request.setAttribute("createInventory", createInventory);
        
        myModel.put("createInventory", createInventory);

        return new ModelAndView("createinventory", "model", myModel);
    }*/

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid CreateInventory createInventory, BindingResult result, Model model)
    {
        if (result.hasErrors()) {
        	model.addAttribute("products", this.productManager.getProducts());
            model.addAttribute("inventories", this.inventoryManager.getInventories());
            return "createinventory";
        }
        
		
        System.out.println("-*-*-*-*-* Creating inventory of product" + createInventory.getProductRef());
        System.out.println("Quantity: " + createInventory.getQuantity());
        inventoryManager.createInventory(createInventory);
        return "redirect:/hello.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected CreateInventory formBackingObject(HttpServletRequest request, Model model) throws ServletException {
    	CreateInventory createInventory = new CreateInventory();
        /*createInventory.setProductRef(new Product());
        createInventory.setQuantity(0);*/
    	model.addAttribute("products", this.productManager.getProducts());
        model.addAttribute("inventories", this.inventoryManager.getInventories());
        model.addAttribute("ahora1", "ahora2");
    	
        return createInventory;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
    public ProductManager getProductManager() {
        return productManager;
    }
    
    public void setInventoryManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }
	public InventoryManager getInventoryManager() {
		return inventoryManager;
	}

}