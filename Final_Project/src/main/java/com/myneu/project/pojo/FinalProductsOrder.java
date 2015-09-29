package com.myneu.project.pojo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Final_Product")
public class FinalProductsOrder {
	
	@Id
	@GeneratedValue
	@Column(name = "Id", unique = true, nullable =false)
	private int Id; 
	
	
	@Column(name="productId")
	private int productId;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name = "price")
	private double price;
	
	@ManyToOne
	private OrderTemp order;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
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
	public OrderTemp getOrder() {
		return order;
	}
	public void setOrder(OrderTemp order) {
		this.order = order;
	}
	
	
	
	
	
	
}