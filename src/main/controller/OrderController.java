package main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import main.model.Orders;
import main.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping("/add-order")
	public String showForm(Model model) {
		model.addAttribute("orders", new Orders());
		return "order-form";
	}
	
	@PostMapping("/order-process-form")
	public String showOrderData(@Valid @ModelAttribute Orders orders, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "order-form";
		}
		orderService.saveOrUpdate(orders);
		return "redirect:show-order";
	}
	
	@GetMapping("/show-order")
	public String getOrder(Model model) {
		List<Orders> orderss = orderService.getAll();
		model.addAttribute("orderss", orderss);
		return "orders";
	}

	@GetMapping("/edit-order/{orderId}")
	public String editOrder(@PathVariable long orderId, Model model) {
		Orders orders = orderService.getById(orderId);
		if(orders != null) {
			model.addAttribute("orders", orders);
			return "order-form";
		}
		return "redirect:/show-order";
	}
	
	@GetMapping("/delete-order/{orderId}")
	public String deleteOrder(@PathVariable long orderId) {
		Orders orders = orderService.getById(orderId);
		if(orders != null) {
			orderService.delete(orderId);
		}
		return "redirect:/show-order";
	}

}
