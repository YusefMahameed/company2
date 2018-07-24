package com.company.models;

import javax.persistence.*;


@Entity
@Table(name= "orders")
public class orders {
	
	

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	  
	  @ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "customer_id")
	  customers customer;
	  
	  @ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "product_id")
	  orderedProducts product;
	  
	  
	  String date;
	  
	  
		public orders() {
			super();
		}


		public orders(customers customer, orderedProducts product, String date) {
			super();
			this.customer = customer;
			this.product = product;
			this.date = date;
		}


		public orderedProducts getProduct() {
			return product;
		}


		public void setProduct(orderedProducts product) {
			this.product = product;
		}

		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}

		public customers getCustomer() {
			return customer;
		}


		public void setCustomer(customers customer) {
			this.customer = customer;
		}

		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}
	  
}

