package com.companyname.springapp.service;

import javax.validation.constraints.Min;

public class CreateProduct {
	
    private String description;
	@Min(1)
    private Double price;

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }

}
