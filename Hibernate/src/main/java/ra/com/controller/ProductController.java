package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.com.model.Product;
import ra.com.service.ProductService;

@Controller
@RequestMapping("/productsController")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public String findAllProducts(Model model) {
        model.addAttribute("listProducts", productService.findAll());
        return "products";
    }

    @GetMapping("/initCreate")
    public String initCreateProducts(Model model) {
        model.addAttribute("product", new Product());
        return "newProduct";
    }

    @PostMapping("/create")
    public String createProduct(Product product) {
        boolean result = productService.save(product);
        if (result) {
            return "redirect:/productsController/findAll";
        }
        return "error";
    }

}
