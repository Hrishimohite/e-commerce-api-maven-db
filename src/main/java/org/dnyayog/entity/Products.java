package org.dnyayog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product_data")
public class Products {
	@Id
	long id;
	@Column
	String productName;
	
	@Column
	int price;
	
	@Column
	int quintity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuintity() {
		return quintity;
	}

	public void setQuintity(int quintity) {
		this.quintity = quintity;
	}
	
	
}
