package main.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import main.model.Product;

@Repository
public interface ProductDAO {
	
	public List<Product> getAll();

}
