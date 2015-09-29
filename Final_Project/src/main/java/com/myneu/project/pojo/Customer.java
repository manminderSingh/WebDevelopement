package com.myneu.project.pojo;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name = "Customer")
public class Customer {
	@GenericGenerator(name="generator",strategy="foreign",parameters=@Parameter(name="property", value="userAccount"))
	@Id
	@GeneratedValue(generator="generator")
	@Column(name = "customerID", unique = true, nullable =false)
	private Integer customerID;
	
	
	@OneToMany
	@JoinTable(joinColumns=@JoinColumn(name="customerID"), inverseJoinColumns=@JoinColumn(name="OrderId"))
	private Collection<Order> orders = new ArrayList<Order>();
	
	public Collection<Order> getOrders() {
		return orders;
	}
	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
 
	@Column(name="firstname")
	String firstName;
	
	@Column(name="lastname")
	String lastName;
	
	
	@Column(name="emailID")
	String emailID;
	
	@Column(name="phonenumber")
	private String phoneNumber;
	
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="customer", cascade=CascadeType.ALL)
	private AddressCustomer address;
	
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Users userAccount;
	@Column(name="gender")
	String gender;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public Users getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(Users userAccount) {
		this.userAccount = userAccount;
	}
	public AddressCustomer getAddress() {
		return address;
	}
	public void setAddress(AddressCustomer address) {
		this.address = address;
	}
}

