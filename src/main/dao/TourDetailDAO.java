package main.dao;

import main.model.TourDetail;

public interface TourDetailDAO {
	
	public TourDetail getById(long id);
	
	public void saveOrUpdate(TourDetail tourDetail);
	
	public void delete(long id);
	
}
