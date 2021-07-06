package com.wipro.example.restaurant_management.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wipro.example.restaurant_management.model.Table;

public class TableDao {
	
	Map<Integer, Table> tablesMap = new HashMap<Integer,Table>(); 
	int num = 0;
	
	public String addTable(int capacity, boolean isReserved,  long custId) {
		Table table = new Table();
		table.setTableNumber(++num);
		table.setCapacity(capacity);
		table.setReserved(isReserved);
		table.setCustomerId(custId);
		tablesMap.put(num, table);
		return "Table has been successfully added.";
	}
	public Table findTable(int id) {
		return tablesMap.get(id);
	}
	public String reserveTable(int tableNumber, Long customerId) {
		//CustomerDao cust = new CustomerDao();
		Table table = tablesMap.get(tableNumber);
		if(!table.isReserved()) {
			table.setCustomerId(customerId);
			table.setReserved(true);
			return "Table has been reserved on ";
		}
		else {
			return "Table is reserved!";
		}
	}
	public String updateTable(int id, boolean isReserved) {
		Table table = tablesMap.get(id);
		table.setReserved(isReserved);
		tablesMap.replace(id, table);
		return "Table status has been changed.";
	}
	public List<Table> getAllTables(){
		List<Table> tables = new ArrayList<Table>();
		tables.addAll(tablesMap.values());
		return tables;
	}
	public String delete(int id) {
		tablesMap.remove(id);
		return "Table was deleted successfully.";
	}
	
/*
	public static void main(String[] args) {
		//CustomerDao custDao = new CustomerDao();
	//	Customer cust = custDao.find("viswanadh");
		TableDao dao = new TableDao();
		System.out.println(dao.addTable(4, false, 154545322l));
		System.out.println(dao.getAllTables());
	}
*/

}
