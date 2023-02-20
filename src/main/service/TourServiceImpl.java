package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.TourDAO;
import main.model.Tour;
import main.model.TourDetail;

@Service
@Transactional
public class TourServiceImpl implements TourService{
	
	@Autowired
	private TourDAO tourDAO;

	@Override
	public List<Tour> getAll() {
		return tourDAO.getAll();
	}

	@Override
	public Tour getById(long id) {
		return tourDAO.getById(id);
	}

	@Override
	public void saveOrUpdate(Tour tour) {
		tourDAO.saveOrUpdate(tour);
	}

	@Override
	public void delete(long id) {
		tourDAO.delete(id);
	}

	@Override
	public void addTourDetailIfNotExists(Tour tour) {
		if(tour.getTourDetail() == null) {
			tour.setTourDetail(new TourDetail());
			saveOrUpdate(tour);
		}
	}

}