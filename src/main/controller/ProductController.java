package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import main.model.Cart;
import main.model.Product;
import main.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

	@GetMapping("/showProduct")
	public String getProducts(Model model) {
        List<Product> products = productService.getAll();
		model.addAttribute("products", products);
		return "product";
	}

    @GetMapping("/edit-products/{productId}")
    public String editProduct(@PathVariable long productId, Model model) {
        Product brand = productService.getById(productId);
        if (brand != null) {
            model.addAttribute("product", brand);
            return "product-form";
        }
        return "redirect:/show-product";
    }

    @GetMapping("/add-product")
    public String addBrand(Model model) {
        model.addAttribute("product", new Cart());
        return "product-form";
    }

    @PostMapping("/process-product-form")
    public String showBrandDetail(Product product) {
        return "product-form";
    }

    @GetMapping("/delete-product/{productId}")
    public String deleteProduct(@PathVariable long productId) {
        Product cart = productService.getById(productId);
        if (cart != null) {
            productService.delete(productId);
        }
        return "redirect:/show-product";
    }
}
