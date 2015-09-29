package com.myneu.project.pojo;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Payment")
public class Payment{
	
	@Id
	@GeneratedValue
	@Column(name = "paymentId", unique = true, nullable =false)
	private int paymentId; 
	
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name = "cardNumber")
	private long cardNumber;
	
	@Column(name="TimeStamp")
	private Timestamp timeStamp;
	
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Column(name="cvv")
	private int cvv;
	
	@Column(name="CustomerID")
	private int customerID;
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	
}