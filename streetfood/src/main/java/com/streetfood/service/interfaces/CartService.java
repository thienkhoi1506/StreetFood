package com.streetfood.service.interfaces;

import com.streetfood.pojo.Cart;
import com.streetfood.pojo.Product;

import java.util.Collection;
import java.util.List;

public interface CartService {
    void add(Cart cart);

    void remove(int productId);

    Collection<Cart> getCart();

    void clear();

    void update(int productId, int quantity);

    double getAmount();

    int getCount();
}
