package main.service;

import java.util.List;

import main.model.Orders;

public interface OrderService {
	
	public List<Orders> getAll();
	
	public Orders getById(long ord_num);
	
	public void saveOrUpdate(Orders orders);
	
	public void delete(long ord_num);

}
