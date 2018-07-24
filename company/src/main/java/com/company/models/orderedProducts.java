package com.company.models;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "ordered_products")
public class orderedProducts {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;
    
    @ManyToOne
	@JoinColumn(name = "currency_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private currencies currency;
    
	public orderedProducts() {
		super();
	}
	public orderedProducts(String name, double price, currencies currency) {
		super();
		this.name = name;
		this.price = price;
		this.currency = currency;
	}
	
	public int getId() {
		return id;
	}
	public orderedProducts(int id, String name, double price, currencies currency) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.currency = currency;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public currencies getCurrency() {
		return currency;
	}
	public void setCurrency(currencies currency) {
		this.currency = currency;
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
}
