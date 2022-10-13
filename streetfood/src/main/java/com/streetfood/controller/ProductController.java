package com.streetfood.controller;

import com.streetfood.dto.ProductDto;
import com.streetfood.pojo.Product;
import com.streetfood.service.interfaces.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("restaurant/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new ProductDto());
        return "restaurant/products/createOrEdit";
    }

    @GetMapping("edit/{id}")
    public String edit(ModelMap modelMap,  @PathVariable("id") long id){
        return "restaurant/products/addOrEdit";
    }

    @GetMapping("createOrEdit")
    public ModelAndView createOrEdit(ModelMap model, ProductDto productDto){
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.save(product);
        model.addAttribute("message", "Product is saved!");
        return new ModelAndView("redirect:/restaurant/products", model);
    }
    @GetMapping("")
    public String list(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "restaurant/products/list";
    }
    @GetMapping
    public String list(Model model,
                       @RequestParam Optional<String> message,
                       @PageableDefault(size = 10, sort = "id",direction = Sort.Direction.ASC)Pageable pageable){
        Page<Product> products = (Page<Product>) productService.findAll(pageable);
        if (message.isPresent()){
            model.addAttribute("message", message.get());
        }

        List<Sort.Order> orders = products.getSort().stream().collect(Collectors.toList());
        if (orders.size() > 0){
            Sort.Order order = orders.get(0);
            model.addAttribute("sort", order.getProperty() + "," +
                    (order.getDirection() == Sort.Direction.ASC? "asc" : "desc"));
        } else {
            model.addAttribute("sort", "id,asc");
        }
        model.addAttribute("pages", products);
        return "restaurant/products/list";
    }

    @GetMapping("search")
    public String search(){
        return "restaurant/products/search";
    }

    @GetMapping("delete/{id}")
    public ModelAndView delete(ModelMap model, @PathVariable("id") long id){
        productService.deleteById(id);
        model.addAttribute("message", "Deleted Successfully");
        return new ModelAndView( "redirect:/restaurant/products/list", model);
    }
}
