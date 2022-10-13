package com.streetfood.service.impl;

import com.streetfood.pojo.Product;
import com.streetfood.repository.interfaces.ProductRepository;
import com.streetfood.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.getProduct(id);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteProduct(id);
    }
}
