package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.OrderDAO;
import main.model.Orders;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public List<Orders> getAll() {
		return orderDAO.getAll();
	}

	@Override
	public Orders getById(long orderId) {
		return orderDAO.getById(orderId);
	}
	
	@Override
	public void saveOrUpdate(Orders orders) {
		orderDAO.saveOrUpdate(orders);
	}

	@Override
	public void delete(long orderId) {
		orderDAO.delete(orderId);
	}

}
