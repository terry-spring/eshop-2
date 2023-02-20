package main.service;

import java.util.List;

import main.model.Order;

public interface OrderService {
	
	public List<Order> getAll();
	
	public Order getById(long ord_num);
	
	public void saveOrUpdate(Order orders);
	
	public void delete(long ord_num);

}
