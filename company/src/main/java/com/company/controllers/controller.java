package com.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.company.models.*;
import com.company.services.CurrencyServiceImp;
import com.company.services.CustomerServiceImp;
import com.company.services.OrderServiceImp;
import com.company.services.OrderedProductsServiceImp;
import com.company.services.ProductServiceImp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

@RestController
@RequestMapping("/company")
public class controller {
	

    @Autowired
    private CustomerServiceImp customerService;

    @Autowired
    private ProductServiceImp productService;
    
    @Autowired
    private OrderedProductsServiceImp orderedproductService;
    
    @Autowired
    private CurrencyServiceImp currencyService;
    
    @Autowired
    private OrderServiceImp orderService;
    
    @GetMapping("/customers/all")
    public List<customers> allCustomers(){
        return customerService.findAll();
    }
    @GetMapping("/customers")
    public List<customers> findCustomerByName(@RequestParam("name") String name) {
		return customerService.findByName(name);
    }
    @PostMapping("/customers/create")
    public customers createCustomer(@RequestBody Map<String, String> body){
    	String name = body.get("name");
    	String address = body.get("address");
		return customerService.creatCustomer(new customers(name , address));
    }
    @GetMapping("/customer")
    public customers findCustomerById(@RequestParam("id")int id) {
		return customerService.findById(id);
    }
    @GetMapping("customers/total")
    public Map<String, Double> findTotal(@RequestParam("id")int id) {
		List<orders> orders = orderService.findByCustomer(customerService.findById(id));
		Map<String, Double> total = new HashMap<String , Double>();
		for (orders o  : orders ) {
			orderedProducts p  = o.getProduct();
			currencies c  = p.getCurrency();
			total.put(c.getType(), p.getPrice());
		}
		return total;
		
    }
    @GetMapping("customer/total")
    public String total(@RequestParam("id") int id) {
    	List<orders> orders = orderService.findByCustomer(customerService.findById(id));
    	double total =0; 
    	double price = 0;
    	double value = 0;
    	orderedProducts prod = new orderedProducts();
    	currencies cur = new currencies();
    	for (orders o : orders) {
			prod = o.getProduct();
			cur = prod.getCurrency();
			value = cur.getNIS_value();
			price = value*prod.getPrice();
			total+=price;
		}
		return "total = " + total + " NIS";
    	
    }
    
    
    @GetMapping("/products/all")
    public List<products> allProducts(){
    	return productService.findAll();
    }
    @GetMapping("/products")
    public List<products> findProduct(@RequestParam("name") String name) {
		return productService.findByName(name);
    }
    @PostMapping("/products/create")
    public products createProduct(@RequestBody Map<String, String> body){
    	String name = body.get("name");
    	double price = Double.parseDouble(body.get("price"));
    	int currencyId = Integer.parseInt(body.get("currency-id"));
    	currencies currency = currencyService.findById(currencyId);
		return productService.creatProduct(new products(name , price , currency));
    }
    @GetMapping("products/sort")
    public List<Entry<String, Integer>> sortProducts(){
    	Map<String, Integer> products = new HashMap<String , Integer>();
    	List<orderedProducts> prods = orderedproductService.findAll();
    	List<orders> orders;
    	for (orderedProducts p : prods) {
    		orders = orderService.findByProduct(p);                
			products.put(p.getName(), orders.size());
		}
    	Map<String, Integer> sorted = new TreeMap<String, Integer>(products);
    	
    	
    	Set<Entry<String, Integer>> set = sorted.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
		return list;
    	
    }
    @GetMapping("product/allCustomers")
    public List<customers> getAll(@RequestParam ("id") int id){
    	List<orders> orders = orderService.findByProduct(orderedproductService.findById(id));
    	List<customers> customers = new ArrayList<customers>();
    	for (orders o : orders) {
			customers.add(o.getCustomer());
		}
		return customers;
    }
    
    @PutMapping("products/update")
    public products update(@RequestBody Map<String, String> body) {
    	int id = Integer.parseInt(body.get("id"));
    	String name = body.get("name");
    	double price = Double.parseDouble(body.get("price"));
    	int currencyId = Integer.parseInt(body.get("currency_id"));
    	currencies currency = currencyService.findById(currencyId);
    	products p = new products(id ,name , price , currency);
    	//products p1 = new products(name , price , currency);
    	if(productService.findById(id)==null)return productService.creatProduct(p);
    	else return productService.updateProduct(p);
    }
    @DeleteMapping("products/delete")
    public void delete(@RequestBody Map<String, String> body) {
    	int id = Integer.parseInt(body.get("id"));
    	productService.deleteProduct(id);
    }
    
    
    @GetMapping("/currencies/all")
    public List<currencies> allCurrencies(){
    	return currencyService.findAll();
    }
    @GetMapping("/currencies")
    public List<currencies> findCurrency(@RequestParam("type") String type) {
		return currencyService.findByType(type);
    }
    @PostMapping("/currencies/create")
    public currencies createCurrency(@RequestBody Map<String, String> body){
    	String type = body.get("type");
    	double NIS_value = Double.parseDouble(body.get("NIS_value"));
		return currencyService.creatCurrency(new currencies(type , NIS_value));
    }
    
    
    @GetMapping("/orders/all")
    public List<orders> allOrders(){
    	return orderService.findAll();
    }
    @GetMapping("/orders/customer")
    public List<orders> findOrderByCustomer(@RequestParam("id") int cus){
    	List<orders> orders = orderService.findByCustomer(customerService.findById(cus));
    	return orders;
    }
    @GetMapping("orders/product")
    public List<orders> findOrderByProduct(@RequestParam("id") int prod){
    	
    	List<orders> orders =  orderService.findByProduct(orderedproductService.findById(prod));
		return orders;
    }
    
    @PostMapping("/orders/create")
    public orders createOrder(@RequestBody Map<String, String> body){
    	String date = body.get("date");
    	int cus_id = Integer.parseInt(body.get("customer_id"));
    	int prod_id = Integer.parseInt(body.get("product_id"));
    	customers customer = customerService.findById(cus_id);
    	products product = productService.findById(prod_id);
    	orderedProducts ordered = new orderedProducts(product.getName() , product.getPrice() , product.getCurrency());
    	orderedproductService.creatOrderedProduct(ordered);
		return orderService.creatOrder(new orders(customer , ordered , date));
    }
    @GetMapping("/orders")
    public List<orders> finByAddress(@RequestParam("address") String address){
    	List<orders> orders = orderService.findAll();
    	List<orders> found = new ArrayList<orders>();
    	for (orders o : orders) {
			customers c = o.getCustomer();
			if(c.getAddress().equals(address))found.add(o);
		}
		return found;
    }
}