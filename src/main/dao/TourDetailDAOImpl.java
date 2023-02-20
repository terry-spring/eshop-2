package main.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.TourDetail;

@Repository
public class TourDetailDAOImpl implements TourDetailDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public TourDetail getById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(TourDetail.class, id);
	}

	@Override
	public void saveOrUpdate(TourDetail tourDetail) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(tourDetail);
		
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		TourDetail tourDetail = getById(id);
		session.delete(tourDetail);
	}

}
