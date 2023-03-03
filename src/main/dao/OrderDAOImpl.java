package main.dao;

import main.model.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Orders> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Orders", Orders.class).list();
	}

	@Override
	public Orders getById(long orderId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Orders.class, orderId);
	}
	
	@Override
	public void saveOrUpdate(Orders orders) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(orders);
	}

	@Override
	public void delete(long orderId) {
		Session session = sessionFactory.getCurrentSession();
		Orders orders = getById(orderId);
		session.delete(orders);
	}

}
