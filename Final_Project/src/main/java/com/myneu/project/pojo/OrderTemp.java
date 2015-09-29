package com.myneu.project.pojo;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="OrderTemp")
public class OrderTemp {
	
	@Id
	@GeneratedValue
	@Column(name = "Id", unique = true, nullable =false)
	private int Id; 
	
	
	
	@OneToMany
	@JoinTable(joinColumns=@JoinColumn(name="OrderId"), inverseJoinColumns=@JoinColumn(name="productId"))
	private Collection<FinalProductsOrder> product = new ArrayList<FinalProductsOrder>();
	
	@Column(name="OrderId")
	private int OrderId;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public Collection<FinalProductsOrder> getProduct() {
		return product;
	}
	public void setProduct(Collection<FinalProductsOrder> product) {
		this.product = product;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	
	
}