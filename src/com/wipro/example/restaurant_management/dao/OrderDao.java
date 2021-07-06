package com.wipro.example.restaurant_management.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wipro.example.restaurant_management.model.Items;
import com.wipro.example.restaurant_management.model.Order;


public class OrderDao {
	Map<Long, Order> ordersMap = new HashMap<Long,Order>(); 
	ItemsDao itemsDao = new ItemsDao(); 
	Long id = 0l;
	Order order = new Order();
	double price=0;
	
	public String placeOrder(List<Items> itemsList, int tableNumber) {
		order.setOrderID(++id);
		order.setItems(itemsList);
		order.setTableNumber(tableNumber);
		for(Items i:itemsList) {
			price = i.getItemPrice()*i.getQuantity();
		}
		order.setPrice(price);
		order.setDate(LocalDateTime.now());
		return "Order placed with order id: "+order.getOrderID();
	
	}
	
	public Order getOrder(Long id) {
		return ordersMap.get(id);
	}
	
	public String updateOrder(long id, String itemName, String newItem) {
		itemName = itemName.toUpperCase();
		newItem = newItem.toUpperCase();
		order = this.getOrder(id);
		List<Items> itemsList = order.getItems();
		int index = itemsList.indexOf(itemsDao.getItem(itemName));
		itemsList.add(itemsDao.getItem(newItem));
		itemsList.remove(index);
		return "Order was updated.";
		
	}
	public List<Order> getAllOrders(){
		List<Order> orders = new ArrayList<Order>();
		orders.addAll(ordersMap.values());
		return orders;
	}
	public void cancelOrder(Long id) {
		ordersMap.remove(id);
	}
	
	
}
