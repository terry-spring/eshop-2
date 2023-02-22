package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javassist.expr.NewArray;
import main.model.Cart;
import main.model.Order;
import main.repository.CartRepository;

@Controller
public class CartController {

	@Autowired
	private CartRepository cartRepository;
	
	@GetMapping("/show-cart")
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
		return "redirect:/show-cart";
	}
	
	@GetMapping("/add-cart")
	public String addCart(Model model) {
		model.addAttribute("cart", new Cart());
		return "cart-form";
	}
	
	@PostMapping("/process-cart-form")
	public String showCartDetail(Cart cart) {
		return "cart-form";
	}
	
	@GetMapping("/delete-cart/{cartId}")
	public String deleteCart(@PathVariable long cartId) {
		Cart cart = cartRepository.getOne(cartId);
		if (cart != null) {
			cartRepository.deleteById(cartId);
		}
		return "redirect:/show-cart";
	}
}
