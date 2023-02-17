package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.OrderDAO;
import main.model.Orders;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public List<Orders> getAll() {
		return orderDAO.getAll();
	}

	@Override
	public Orders getById(long ord_num) {
		return orderDAO.getById(ord_num);
	}
	
	@Override
	public void saveOrUpdate(Orders order) {
		orderDAO.saveOrUpdate(order);
	}

	@Override
	public void delete(long ord_num) {
		orderDAO.delete(ord_num);
	}

}
