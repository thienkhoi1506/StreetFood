package com.streetfood.service.impl;

import com.streetfood.pojo.Cart;
import com.streetfood.service.interfaces.CartService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class CartServiceImpl implements CartService {

    private Map<Integer, Cart> map = new HashMap<Integer, Cart>();

    @Override
    public void add(Cart cart){
        Cart existedItem = map.get(cart.getProductId());

        if (existedItem != null){
            existedItem.setQuantity(cart.getQuantity() + existedItem.getQuantity());
        }
        map.put((int) cart.getProductId(), cart);
    }

    @Override
    public void remove(int productId){
        map.remove(productId);
    }

    @Override
    public Collection<Cart> getCart(){
        return map.values();
    }

    @Override
    public void clear(){
        map.clear();
    }

    @Override
    public void update(int productId, int quantity){
        Cart cart = map.get(productId);

        cart.setQuantity(quantity);

        if(cart.getQuantity() <= 0){
            map.remove(productId);
        }
    }

    @Override
    public double getAmount(){
        return map.values().stream().mapToDouble(item -> item.getQuantity() * item.getPrice()).sum();
    }

    @Override
    public int getCount(){
        if (map.isEmpty())
            return 0;
        return map.values().size();
    }
}
