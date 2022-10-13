package com.streetfood.service.interfaces;

import com.streetfood.pojo.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProducts();
    public void saveProduct (Product product);
    public Product getProduct (long id);
    public void deleteProduct (long id);
}
