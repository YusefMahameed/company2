package com.company.models;

import javax.persistence.*;


@Entity
@Table(name = "currencies")
public class currencies {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private double NIS_value;
    
    
	public currencies() {
	}
	
	public currencies(String type, double NIS_value) {
		super();
		this.type = type;
		this.NIS_value = NIS_value;
	}
	public currencies(int id, String type, double nIS_value) {
		super();
		this.id = id;
		this.type = type;
		this.NIS_value = nIS_value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getNIS_value() {
		return NIS_value;
	}
	public void setNIS_value(double nIS_value) {
		NIS_value = nIS_value;
	}
    
    
	
}
