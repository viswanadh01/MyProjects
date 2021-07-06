package com.wipro.example.restaurant_management.model;

public class Table {
	
	private int tableNumber;
	private int capacity;
	private boolean reserved;
	private long customerId;
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public boolean isReserved() {
		return reserved;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "Table [tableNumber=" + tableNumber + ", capacity=" + capacity + ", reserved=" + reserved
				+ ", customerId=" + customerId + "]";
	}
	
	
}
