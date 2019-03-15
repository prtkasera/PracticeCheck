package com.cognizant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="product")
@NamedQueries(
		{
			@NamedQuery(name="findAllProducts",query="select o from Product o"),
			@NamedQuery(name="checkProduct",query="select o from Product o where o.product_id=?1 or o.product_category=?2)")
		}
		)
public class Product {
	
	@Id
	@Column(name="product_id")
	private int product_id;
	@Column(name="category")
	private String product_category;
	@Column(name="name")
	private String product_name;
	@Column(name="description")
	private String product_description;
	@Column(name="price")
	private float product_price;
	
	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}

	public Product(){}
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public float getProduct_price() {
		return product_price;
	}
	
	
	
	
}
