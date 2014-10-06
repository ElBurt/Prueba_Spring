package com.companyname.springapp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.springapp.service.CreateProduct;
import com.companyname.springapp.service.ProductManager;

@Controller
@RequestMapping(value="/createproduct.htm")
public class CreateProductFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ProductManager productManager;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid CreateProduct createProduct, BindingResult result)
    {
        if (result.hasErrors()) {
            return "createproduct";
        }
		
        logger.info("Creating product " + createProduct.getDescription());
        productManager.createProduct(createProduct);

        return "redirect:/hello.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected CreateProduct formBackingObject(HttpServletRequest request) throws ServletException {
    	CreateProduct createProduct = new CreateProduct();
        createProduct.setDescription("Product");
        createProduct.setPrice(0.0);
        return createProduct;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

}