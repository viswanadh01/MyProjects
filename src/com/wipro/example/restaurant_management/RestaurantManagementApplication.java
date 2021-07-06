package com.wipro.example.restaurant_management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.wipro.example.restaurant_management.dao.CustomerDao;
import com.wipro.example.restaurant_management.dao.ItemsDao;
import com.wipro.example.restaurant_management.dao.OrderDao;
import com.wipro.example.restaurant_management.dao.TableDao;
import com.wipro.example.restaurant_management.model.Items;

public class RestaurantManagementApplication {

	static List<Items> itemsList = new ArrayList<Items>();
	public ItemsDao itemsDao = new ItemsDao(); 
	Items item = new Items();

	

	public void selectItems(ItemsDao items, String name, int quantity) {
		items.getItem(name).setQuantity(quantity);
		itemsList.add(items.getItem(name));
	}
	
	public static void main(String[] args) throws IOException {
		RestaurantManagementApplication restaurant = new RestaurantManagementApplication();
		CustomerDao custDao = new CustomerDao();
		TableDao tableDao = new TableDao();
		OrderDao orderDao = new OrderDao();
		ItemsDao itemDao = new ItemsDao();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Collecting customer details.
		System.out.println("Enter customer's firstName: ");
		String firstName = br.readLine();
		System.out.println("Enter customer's lastName: ");
		String lastName = br.readLine();
		System.out.println("Enter customer's contactNumber: ");
		Long contactNumber = Long.parseLong(br.readLine());
		
		custDao.createCustomer("Viswanadh", "Ganti", 1234567890l);
		custDao.createCustomer("Raj", "Kumar", 12345678457l);
		custDao.createCustomer(firstName, lastName, contactNumber);
		
		
		//Adding tables.
		System.out.println();
		System.out.println(tableDao.addTable(4, false, 0l));
		tableDao.addTable(8, false, 0l);
		tableDao.addTable(4, false, 0l);
		tableDao.addTable(10, false, 0l);
		tableDao.addTable(4, false, 0l);
		tableDao.addTable(8, false, 0l);
		long customerId = custDao.find("Raj").getCustomerId();
		
		
		//Add items
		itemDao.addItem("Veg Biryani", 250.00);
		itemDao.addItem("Butter Naan", 40.00);
		itemDao.addItem("Plain Naan", 35.00);
		itemDao.addItem("Chicken Biryani", 300.00);
		itemDao.addItem("Kaju Masala", 150.00);
		itemDao.addItem("Apollo Fish", 250.00);
		itemDao.addItem("Coke", 30.00);
		itemDao.addItem("Ice Cream", 25.00);
		
		
		//Reserve a table
		System.out.println();
		System.out.println(tableDao.reserveTable(3, 1l)+custDao.find(customerId).getFirstName());
		System.out.println();
		//Order food
		//Menu
		System.out.println("****************" );
		System.out.println("Available menu:" );
		System.out.println(itemDao.getAllItems());
	
		
		//Select Items
		restaurant.selectItems(itemDao,"Kaju Masala", 1);
		restaurant.selectItems(itemDao,"Butter Naan", 1);
		restaurant.selectItems(itemDao,"Coke", 1);
		restaurant.selectItems(itemDao,"Ice Cream", 1);
		
		//Place Order
		
		System.out.println(orderDao.placeOrder(itemsList,3));
		
		System.out.println();
		System.out.println("List of all customers: ");
		System.out.println("*****************");
		System.out.println(custDao.getAllCustomers());

	}
	
}
