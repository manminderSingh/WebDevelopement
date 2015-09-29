package com.myneu.project.pojo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="OrderTable")
public class Order {
	
	
	@Id
	@GeneratedValue
	@Column(name = "OrderId", unique = true, nullable =false)
	private int Id; 
	
	

	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	@Column(name="customerID")
	private int customerID;
	/*@OneToMany
	@JoinTable(joinColumns=@JoinColumn(name="OrderId"), inverseJoinColumns=@JoinColumn(name="productId"))
	private Collection<FinalProductsOrder> product = new ArrayList<FinalProductsOrder>();
	*/




	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	
	
	
	
	
	
}