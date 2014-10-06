package com.companyname.springapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="inventory") 
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idInventory")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idInventory;

    @ManyToOne
    @JoinColumn(name = "productRef", referencedColumnName = "id", nullable = false)
    private Product productRef;
    
    @Column(name = "quantity")
    private Integer quantity;
    
    public Integer getIdInventory() {
		return idInventory;
	}
	public void setIdInventory(Integer idInventory) {
		this.idInventory = idInventory;
	}

	public Product getProductRef() {
		return productRef;
	}
	public void setProductRef(Product productRef) {
		this.productRef = productRef;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		return buffer.append("ProductRef= ").append(getProductRef().getDescription()).append(", Quantity()=").append(getQuantity()).toString();
	}
}