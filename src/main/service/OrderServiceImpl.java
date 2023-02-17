package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.OrderDAO;
import main.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO tourDAO;
	
	@Override
	public List<Order> getAll() {
		return tourDAO.getAll();
	}

	@Override
	public Order getById(int id) {
		return tourDAO.getById(id);
	}
	
	@Override
	public void saveOrUpdate(Order tour) {
		tourDAO.saveOrUpdate(tour);
	}

	@Override
	public void delete(int id) {
		tourDAO.delete(id);
	}

}
