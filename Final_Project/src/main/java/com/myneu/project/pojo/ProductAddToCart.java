package com.myneu.project.pojo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ProductAddToCart")
public class ProductAddToCart {
	
	@Id
	@GeneratedValue
	@Column(name = "Id", unique = true, nullable =false)
	private int Id; 
	
	
	@Column(name = "productId")
	private int productId;
	
	/*@ManyToMany
	private Collection<Supplier> supplier = new ArrayList<Supplier>();*/
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public ProductAddToCart() {
		// TODO Auto-generated constructor stub
		
	}
	
	@Column(name = "CustomerId")
	private int customerId;
	
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/*public Collection<Supplier> getSupplier() {
		return supplier;
		
	}
	public void setSupplier(Collection<Supplier> supplier) {
		this.supplier = supplier;
	}
*/
	@Column(name="productName")
	private String productName;
	
	@Column (name="totalCost")
	private double totalCost;
	
	@Column(name = "price")
	private double price;
	
	@Column(name="totalQuantity")
	private int totalQuantity;
	
	@Column(name="selectedQuantity")
	private int selectedQuantity;
	
	public int getProductId() {
		return productId;
	}
	
	
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
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
	
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public int getSelectedQuantity() {
		return selectedQuantity;
	}
	public void setSelectedQuantity(int selectedQuantity) {
		this.selectedQuantity = selectedQuantity;
	}
	
	
}