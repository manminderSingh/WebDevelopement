package com.myneu.project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Email")
public class EmailPojo {
	
	
	@Id
	@GeneratedValue
	@Column(name = "Id", unique = true, nullable =false)
	private int Id;
	
	
	
	@Column(name="From")
	private String from;
	
	
	@Column(name="Message")
	private String message;


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
