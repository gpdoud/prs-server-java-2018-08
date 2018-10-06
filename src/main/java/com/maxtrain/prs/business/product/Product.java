package com.maxtrain.prs.business.product;

import javax.persistence.*;

import com.maxtrain.prs.business.vendor.Vendor;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="vendorID")
	private Vendor vendor;
	private String partnumber;
	private String name;
	private double price;
	private String unit;
	private String photopath;
	
	public Product() {
		super();
	}

	public Product(int id, Vendor vendor, String partnumber, String name, double price, String unit, String photopath) {
		super();
		this.id = id;
		this.vendor = vendor;
		this.partnumber = partnumber;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.photopath = photopath;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getPartnumber() {
		return partnumber;
	}

	public void setPartnumber(String partnumber) {
		this.partnumber = partnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPhotopath() {
		return photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}

	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return String.format("id[%d], vendor.name[%s], partnumber[%s], name[%s], price[%f], unit[%s]", 
				id, vendor.getName(), partnumber, name, price, unit);
	}
}
