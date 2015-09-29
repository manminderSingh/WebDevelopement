package com.myneu.project.pojo;
import java.util.Collection;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Product")
public class Product {
	
	
	@Id
	@GeneratedValue
	@Column(name = "productId", unique = true, nullable =false)
	private int productId; 
	
	
	@ManyToOne
	private Supplier supplier;
	
	
	public Product(){
		
	}
	
	public Product(String productName){
		this.productName = productName;
	}
	
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	@Column(name="productName")
	private String productName;
	
	@Column(name = "price")
	private double price;
	
	@Column(name="quantity")
	private int quantity; 
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}