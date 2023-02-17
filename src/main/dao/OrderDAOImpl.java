package main.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.Orders;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Orders> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Orders o", Orders.class).list();
	}

	@Override
	@Transactional
	public Orders getById(long ord_num) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Orders.class, ord_num);
	}
	
	@Override
	@Transactional
	public void saveOrUpdate(Orders orders) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(orders);
	}

	@Override
	@Transactional
	public void delete(long ord_num) {
		Session session = sessionFactory.getCurrentSession();
		Orders orders = getById(ord_num);
		session.delete(orders);
	}

}
