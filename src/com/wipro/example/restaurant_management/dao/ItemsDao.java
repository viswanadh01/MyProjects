package com.wipro.example.restaurant_management.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wipro.example.restaurant_management.model.Items;

public class ItemsDao {
	
	Map<String,Items> itemsMap = new HashMap<String,Items>();
	
	public String addItem(String name, double price) {
		name = name.toUpperCase();
		Items item = new Items();
		item.setItemName(name);
		item.setItemPrice(price);
		itemsMap.put(name, item);
		return "Item was added successfully.";
	}
	
	public void updateItem(String name, double price) {
		name = name.toUpperCase();
		Items item = new Items();
		item = itemsMap.get(name);
		item.setItemPrice(price);
		itemsMap.remove(name, item);
	}
	
	public double totalPrice(String name, int quantity) {
		name = name.toUpperCase();
		Items item = new Items();
		item = itemsMap.get(name);
		return item.getQuantity()*item.getItemPrice();
	}
	
	public Items getItem(String name) {
		
		name = name.toUpperCase();
		return itemsMap.get(name);
	}
	public List<Items> getAllItems(){
		List<Items> items = new ArrayList<Items>();
		items.addAll(itemsMap.values());
		return items;
	}
	public void deleteItem(String name) {
		name = name.toUpperCase();
		itemsMap.remove(name);
	}

}
