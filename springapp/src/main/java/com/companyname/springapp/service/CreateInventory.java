package com.companyname.springapp.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CreateInventory {
	
	@NotNull
	@Min(value = 1, message = "{createinventory.validation.productref}")
    private Integer productRef;
    
	@NotNull
    @Min(1)
    private Integer quantity;
    
	public Integer getProductRef() {
		return productRef;
	}
	public void setProductRef(Integer productRef) {
		this.productRef = productRef;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
    
}
