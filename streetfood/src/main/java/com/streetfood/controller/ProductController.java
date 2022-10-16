package com.streetfood.controller;

import com.streetfood.pojo.Product;
import com.streetfood.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/restaurant/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/list")
    public String listProducts(Model model){
        model.addAttribute("products", productService.getProducts());
        return "list";
    }

    @GetMapping("/{id}")
    public String getProduct(Model model, @PathVariable("id") long id){
        model.addAttribute("product", productService.getProduct(id));
        return "detail";
    }

    @GetMapping("/showForm")
    public String showFormAdd(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "createOrEdit";
    }

    @PostMapping("/saveProduct")
    public String saveProduct (Model model, @ModelAttribute("product") Product product, BindingResult result){
        if (result.hasErrors()){
            model.addAttribute("message", "Some fields are not valid");
        }
        productService.saveProduct(product);
        return "redirect:/restaurant/products/list";
    }

    @GetMapping("/updateForm/{id}")
    public String showFormUpdate(@PathVariable("id") long id, Model model){
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "createOrEdit";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id){
        productService.deleteProduct(id);
        return "redirect:/restaurant/products/list";
    }


}
