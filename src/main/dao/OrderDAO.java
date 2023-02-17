package main.dao;

import java.util.List;

import main.model.Orders;

public interface OrderDAO {
	
	public List<Orders> getAll();
	
	public Orders getById(long ord_num);
	
	public void saveOrUpdate(Orders order);
	
	public void delete(long ord_num);

}
