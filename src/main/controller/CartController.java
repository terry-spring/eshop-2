package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import main.model.Cart;
import main.model.Order;
import main.repository.CartRepository;

@Controller
public class CartController {

	@Autowired
	private CartRepository cartRepository;
	
	@GetMapping("/showCart")
	public String showCart(Model model) {
		List<Cart> carts = cartRepository.findAll();
		model.addAttribute("carts", carts);
		return "cart";
	}
	
	@GetMapping("/edit-cart/{cartId}")
	public String editOrder(@PathVariable long orderId, Model model) {
		Cart cart = cartRepository.getOne(orderId);
		if(cart != null) {
			model.addAttribute("cart", cart);
			return "cart-form";
		}
		return "redirect:/showCart";
	}
}
