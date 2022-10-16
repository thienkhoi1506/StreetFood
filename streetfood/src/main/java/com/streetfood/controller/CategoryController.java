package com.streetfood.controller;

import com.streetfood.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("categories")
    public String commonAttr(Model model){
        model.addAttribute("categories", this.categoryService.getCategories());
        return "createOrEdit";
    }
}
