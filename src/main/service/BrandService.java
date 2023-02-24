package main.service;

import java.util.List;

import main.model.Brand;

public interface BrandService {
	
	public List<Brand> getAll();
	
	public Brand getById(long brandId);
	
	public void saveOrUpdate(Brand brand);
	
	public void delete(long brandId);
}
