package com.wipro.example.restaurant_management.model;

public class Items {
	private String itemName;
	private int quantity;
	private double itemPrice;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	@Override
	public String toString() {
		return "Items [itemName=" + itemName + ", quantity=" + quantity + ", itemPrice=" + itemPrice + "]";
	}
	

}
