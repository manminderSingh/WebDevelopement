package com.myneu.project.pojo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name = "AddressSupplier")
public class AddressSupplier {
	@GenericGenerator(name="generator",strategy="foreign",parameters=@Parameter(name="property", value="supplier"))
	@Id
	@GeneratedValue(generator="generator")
	@Column(name = "addressID", unique = true, nullable =false)
	private Integer addressID;
	
	
	
	
	public Integer getAddressID() {
		return addressID;
	}
	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}
	@Column(name="zipcode",nullable=true)
	private Integer zipCode;
	
	
	@Column(name="street")
	private String street;
	@Column(name="city")
	private String city;
	@Column(name="country")
	private String country;
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Supplier supplier;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}