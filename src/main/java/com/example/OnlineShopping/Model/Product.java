package com.example.OnlineShopping.Model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Products")
public class Product {
	@Id
	@GeneratedValue
	private int productid;
	private String productname;
	private String description;
	private double price;
	private String image;
	private String categoryname;
//	private byte[] image;
	
//	@ManyToOne
//	@JoinColumn(name = "categoryname", referencedColumnName = "categoryname")
//	private Category categoryname;

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

//	public byte[] getImage() {
//		return image;
//	}
//
//	public void setImage(byte[] image) {
//		this.image = image;
//	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

//	public Category getCategoryname() {
//		return categoryname;
//	}
//
//	public void setCategoryname(Category categoryname) {
//		this.categoryname = categoryname;
//	}

	
	
}
