package main.service;

import java.util.List;

import main.model.Orders;

public interface OrderService {
	
	public List<Orders> getAll();
	
	public Orders getById(long orderId);
	
	public void saveOrUpdate(Orders orders);
	
	public void delete(long orderId);

}
