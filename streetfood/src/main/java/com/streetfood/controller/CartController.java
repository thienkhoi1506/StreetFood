package com.streetfood.controller;

import com.streetfood.pojo.Cart;
import com.streetfood.pojo.Product;
import com.streetfood.service.interfaces.CartService;
import com.streetfood.service.interfaces.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("cartDetail")
    public String list(Model model){
        Collection<Cart> carts = cartService.getCart();

        model.addAttribute("cart", carts);
        model.addAttribute("total", cartService.getAmount());
        model.addAttribute("NoOfItems", cartService.getCount());

        return "cartDetail";
    }

    @GetMapping("add/{productId}")
    public String add(@PathVariable("productId") int productId){
        Product product = productService.getProduct(productId);

        if (product != null){
            Cart cart = new Cart();
            BeanUtils.copyProperties(product, cart);
            cart.setQuantity(1);
            cartService.add(cart);
        }
        return "cart/cartDetail";
    }

    @GetMapping("remove/{productId}")
    public String remove(@PathVariable("productId") Integer productId){
        cartService.remove(productId);
        return "cart/cartDetail";
    }

    @PostMapping("update")
    public String update(@RequestParam("productId") Integer productId,@RequestParam("quantity") Integer quantity){
        cartService.update(productId, quantity);
        return "cart/cartDetail";
    }

    @GetMapping("clear")
    public String clear(){
        return "cart/cartDetail";
    }
}
