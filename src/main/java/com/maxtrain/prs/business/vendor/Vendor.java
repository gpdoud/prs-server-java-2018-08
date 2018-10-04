package com.maxtrain.prs.business.vendor;

import javax.persistence.*;

@Entity
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phonenumber;
	private String email;
	@Column(name = "isPreapproved")
	private boolean preapproved;
	
	
	public Vendor(int id, String code, String name, String address, String city, String state, String zip,
			String phonenumber, String email, boolean preapproved) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phonenumber = phonenumber;
		this.email = email;
		this.preapproved = preapproved;
	}
	public Vendor() {
		super();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isPreapproved() {
		return preapproved;
	}
	public void setPreapproved(boolean preapproved) {
		this.preapproved = preapproved;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return String.format("id[%d], name[%s], addr[%s, %s, %s %s], phone[%s], email[%s], preapprove[%b]", 
				id, code, name, address, city, state, zip, phonenumber, email, preapproved);
	}
}
