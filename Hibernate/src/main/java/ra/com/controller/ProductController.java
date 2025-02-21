package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ra.com.model.Categories;
import ra.com.model.Product;
import ra.com.service.CategoriesService;
import ra.com.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/productsController")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/findAll")
    public String findAllProducts(Model model) {
        model.addAttribute("listProducts", productService.findAll());
        return "products";
    }

    @GetMapping("/initCreate")
    public String initCreateProducts(Model model) {
        model.addAttribute("product", new Product());
        List<Categories> listCategories = categoriesService.findAll();
        model.addAttribute("listCategories", listCategories);
        return "newProduct";
    }

    @PostMapping("/create")
    public String createProduct(Product product) {
        boolean result = productService.save(product);
        if (result) {
            return "redirect:findAll";
        }
        return "newProduct";
    }

}
