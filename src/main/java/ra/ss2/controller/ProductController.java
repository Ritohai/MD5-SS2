package ra.ss2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.ss2.model.entity.Category;
import ra.ss2.model.entity.Product;
import ra.ss2.model.service.CategoryService;
import ra.ss2.model.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.getAll();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "product/index";
    }

    @GetMapping("/product/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "product/add";
    }

    @PostMapping("/product/add")
    public String processAdd(@ModelAttribute("product") Product product) {
        productService.create(product);
        return "redirect:/product";
    }

    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", productService.find(id));
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "product/edit";
    }

    @PostMapping("/product/edit")
    public String processEdit(@ModelAttribute("product") Product product) {
        productService.update(product);
        return "redirect:/";
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        productService.delete(productService.find(id));
        return "redirect:/";
    }


}
