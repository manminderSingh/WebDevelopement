package com.myneu.project.pojo;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="UserAccount")
public class Users{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userID", unique=true, nullable=false)
	private Integer userId;
	
	
	//Getter and Setter for ID
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name="UserName", unique=true, nullable=false)
	String userName;
	
	@Column(name="UserRole")
	String userRole;
	
	@Column(name="status")
	private String status;
	 
	
	
	@Column(name="UserPassword")
	String password;
	
	
	
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="userAccount", cascade=CascadeType.ALL)
	private Customer customer;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="userAccount", cascade=CascadeType.ALL)
	private Supplier supplier;
	
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private String userFlag;
	public String getUserFlag() {
		return userFlag;
	}
	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}
	
	
	
}