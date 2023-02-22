package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import main.model.Product;
import main.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository; ;
	
	@GetMapping("/showProduct")
	public String getProducts(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		return "product";
	}
}
