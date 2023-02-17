package main.dao;

import java.util.List;

import main.model.Order;

public interface OrderDAO {
	
	public List<Order> getAll();
	
	public Order getById(int id);
	
	public void saveOrUpdate(Order tour);
	
	public void delete(int id);

}
