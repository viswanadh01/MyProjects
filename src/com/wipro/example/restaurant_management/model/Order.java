package com.wipro.example.restaurant_management.model;

import java.time.LocalDateTime;
import java.util.List;



public class Order {
	 private long orderID;
	 private List<Items> items;
	 private double price;
	 private int tableNumber;
	 private LocalDateTime date;
	 
	 
	public Order(long orderID, double price, int tableNumber, LocalDateTime date) {
		super();
		this.orderID = orderID;
		this.price = price;
		this.setTableNumber(tableNumber);
		this.date = date;
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime localDateTime) {
		this.date = localDateTime;
	}

	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", items=" + items + ", price=" + price + ", tableNumber=" + tableNumber
				+ ", date=" + date + "]";
	}
	
	 
}
