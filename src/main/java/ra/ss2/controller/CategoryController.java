package ra.ss2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.ss2.model.entity.Category;
import ra.ss2.model.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public String home (Model model){
        List<Category> list = categoryService.findAll();
        model.addAttribute("list",list);
        return "category/index";
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory( @PathVariable("id") int id  ){
        categoryService.delete(id);
        return "redirect:/category";
    }
    @GetMapping("/add/category")
    public String addCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/add";
    }
    @PostMapping("/create/category")
    public String createCategory(@ModelAttribute("category") Category category) {
        categoryService.saveOrUpdate(category);
        return "redirect:/category";
    }

    @GetMapping("/edit/category/{id}")
    public String editCategory(Model model,@PathVariable("id") int id ) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/edit";
    }


    @PostMapping("/update/category")
    public String updateCategory(@ModelAttribute("category") Category category) {
        System.out.println(category);
        categoryService.saveOrUpdate(category);
        return "redirect:/category";
    }


}
