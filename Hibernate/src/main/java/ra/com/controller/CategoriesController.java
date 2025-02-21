package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.com.model.Categories;
import ra.com.service.CategoriesService;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
@RequestMapping("/categoriesController")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/findAll")
    public String findAllCategories(Model model) {
        model.addAttribute("listCategories", categoriesService.findAll());
        return "categories";
    }

    @GetMapping("/initCreate")
    public String initCreateCatalog(Model model) {
        model.addAttribute("catalog", new Categories());
        return "newCategories";
    }

    @PostMapping("create")
    public String createCatalog(Categories catalog) {
        boolean result = categoriesService.save(catalog);
        if (result) {
            return "redirect:findAll";
        }
        return "newCategories";
    }

    @GetMapping("/initUpdate")
    public String initUpdateCatalog(Model model, int catalogId) {
        Categories catalogUpdate = categoriesService.findById(catalogId);
        model.addAttribute("catalog", catalogUpdate);
        return "updateCategories";
    }

    @PostMapping("/update")
    public String updateCatalog(Categories catalogUpdate) {
        boolean result = categoriesService.update(catalogUpdate);
        if (result) {
            return "redirect:findAll";
        }
        return "errorUpdate";
    }

    @GetMapping("/delete")
    public String delete(int catalogId) {
        boolean result = categoriesService.delete(catalogId);
        if (result) {
            return "redirect:findAll";
        }
        return "errorDelete";
    }
}
