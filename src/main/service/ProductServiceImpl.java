package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.ProductDAO;
import main.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<Product> getAll() {
		return productDAO.getAll();
	}

}
