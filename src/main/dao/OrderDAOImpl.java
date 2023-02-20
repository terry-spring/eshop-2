package main.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Order> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from sales_order o", Order.class).list();
	}

	@Override
	@Transactional
	public Order getById(long ord_num) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Order.class, ord_num);
	}
	
	@Override
	@Transactional
	public void saveOrUpdate(Order orders) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(orders);
	}

	@Override
	@Transactional
	public void delete(long ord_num) {
		Session session = sessionFactory.getCurrentSession();
		Order orders = getById(ord_num);
		session.delete(orders);
	}

}
