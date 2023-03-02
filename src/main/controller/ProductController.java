package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import main.model.Brand;
import main.model.Product;
import main.service.BrandService;
import main.service.ProductService;

/**產品功能
 * @author aries
 *
 */
/**
 * @author aries
 *
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    
	/**顯示所有產品
	 * @param model
	 * @return
	 */
	@GetMapping("/showProduct")
	public String getProduct(@AuthenticationPrincipal Authentication authentication,Model model) {
		List<Product> products = productService.getAll();
		model.addAttribute("products", products);
		model.addAttribute("login_user", authentication.getName());
		return "product";
	}
	
	/**新增產品
	 * @param model
	 * @return 產品訊息表單
	 */
	@GetMapping("/add-product")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product());
		return "product-form";
	}
	
	/**產品訊息表單
	 * @param product
	 * @param model
	 * @return
	 */
	@PostMapping("/process-product-form")
	public String processProductData(@ModelAttribute Product product,Model model) {
		productService.saveOrUpdate(product);
		return "redirect:/showProduct";
	}

    /**修改產品
     * @param productId
     * @param model
     * @return
     */
    @GetMapping("/edit-product/{productId}")
    public String editProduct(@PathVariable long productId, Model model) {
        Product product = productService.getById(productId);
        if (product != null) {
            model.addAttribute("product", product);
            return "product-form";
        }
        return "redirect:/showProduct";
    }

    /**刪除產品
     * @param productId
     * @return
     */
    @GetMapping("/delete-product/{productId}")
    public String deleteProduct(@PathVariable long productId) {
        Product cart = productService.getById(productId);
        if (cart != null) {
            productService.delete(productId);
        }
        return "redirect:/showProduct";
    }
    
}
