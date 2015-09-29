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
@Table(name="Supplier")
public class Supplier {
	@GenericGenerator(name="generator",strategy="foreign",parameters=@Parameter(name="property", value="userAccount"))
	@Id
	@GeneratedValue(generator="generator")
	@Column(name = "supplierID", unique = true, nullable =false)
	private Integer supplierID;
	
	@OneToMany
	@JoinTable(joinColumns=@JoinColumn(name="supplierID"), inverseJoinColumns=@JoinColumn(name="productId"))
	private Collection<Product> product = new ArrayList<Product>();
	
	
	@Column(name="firstname")
	String firstName;
	
	@Column(name="lastname")
	String lastName;
	
	
	@Column(name="emailID")
	String emailID;
	
	@Column(name="phoneNumber")
	String phoneNumber;
	@Column(name="status")
	String status;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@OneToOne(fetch=FetchType.LAZY, mappedBy="supplier", cascade=CascadeType.ALL)
	private AddressSupplier address;
	
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Users userAccount;
	@Column(name="gender")
	String gender;
	
	@Column(name="CompanyName")
	String companyName;
	
	
	
	public Supplier(){
		
	}
	
	public Supplier(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	public Collection<Product> getProduct() {
		return product;
	}
	public void setProduct(Collection<Product> produt) {
		this.product = produt;
	}
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
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(Integer supplierID) {
		this.supplierID = supplierID;
	}
	public Users getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(Users userAccount) {
		this.userAccount = userAccount;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public AddressSupplier getAddress() {
		return address;
	}
	public void setAddress(AddressSupplier address) {
		this.address = address;
	}
	
}