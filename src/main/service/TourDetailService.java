package main.service;

import main.model.TourDetail;

public interface TourDetailService {

	public TourDetail getById(long id);
	
	public void saveOrUpdate(TourDetail tourDetail);
	
	public void delete(long id);
}
