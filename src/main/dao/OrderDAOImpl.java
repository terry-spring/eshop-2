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
		return session.createQuery("from sales_order t", Order.class).list();
	}

	@Override
	@Transactional
	public Order getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Order.class, id);
	}
	
	@Override
	@Transactional
	public void saveOrUpdate(Order tour) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(tour);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Order tour = getById(id);
		session.delete(tour);
	}

}
