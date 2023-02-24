package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import main.model.Cart;

public interface CartService {

	public List<Cart> getAll();
	
	public Cart getById(long cartId);
	
	public void saveOrUpdate(Cart cart);
	
	public void delete(long cartId);
}
