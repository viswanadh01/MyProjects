package com.wipro.example.restaurant_management.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wipro.example.restaurant_management.model.Customer;

public class CustomerDao {
	Map<Long, Customer> map = new HashMap<Long,Customer>(); 
	long id = 0l;
	Customer cust;
	
	// Save customer details in map.
	
	public String createCustomer(String firstName, String lastName, long contactNum) {
		Customer customer = new Customer();
		customer.setCustomerId(++id);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setContactNumber(contactNum);
		map.put(id, customer);
		return "Customer details were saved successfully!";
	}
	
	// Find required customer with given id in map
	
	public Customer find(Long id) {
		return map.get(id);
	}
	
	public Customer find(String firstName) {
		
		for(Customer c:map.values()) {
			if(c.getFirstName().equalsIgnoreCase(firstName)) {
				cust = c;
			}
		}
		return cust;
	}
	//returns all customers as a list.
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
		customers.addAll(map.values());		
		return customers;
	}
	
	
/*
	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		System.out.println(dao.createCustomer("viswanadh", "Ganti", 9445122337l));
		System.out.println(dao.getAllCustomers());
	}
*/
}
