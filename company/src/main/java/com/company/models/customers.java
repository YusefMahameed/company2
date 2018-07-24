package com.company.models;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;

    public customers() {

    }

    public customers(int id, String name, String address) {
        super();
        this.setId(id);
        this.setAddress(address);
        this.setName(name);
    }

    public customers(String name, String address) {
    	super();
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
}
