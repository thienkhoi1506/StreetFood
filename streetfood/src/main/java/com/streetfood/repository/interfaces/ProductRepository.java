package com.streetfood.repository.interfaces;

import com.streetfood.pojo.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> getProducts();
    public void saveProduct(Product product);
    public Product getProduct(long id);
    public void deleteProduct(long id);
}
