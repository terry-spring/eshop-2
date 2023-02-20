package main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.TourDetailDAO;
import main.model.TourDetail;

@Service
@Transactional
public class TourDetailServiceImpl implements TourDetailService{
	
	@Autowired
	private TourDetailDAO tourDetailDAO;

	@Override
	public TourDetail getById(long id) {
		return tourDetailDAO.getById(id);
	}

	@Override
	public void saveOrUpdate(TourDetail tourDetail) {
		tourDetailDAO.saveOrUpdate(tourDetail);
		
	}

	@Override
	public void delete(long id) {
		tourDetailDAO.delete(id);
	}

}
