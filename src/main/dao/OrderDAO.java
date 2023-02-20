package main.dao;

import java.util.List;

import main.model.Order;

public interface OrderDAO {
	
	public List<Order> getAll();
	
	public Order getById(long ord_num);
	
	public void saveOrUpdate(Order orders);
	
	public void delete(long ord_num);

}
