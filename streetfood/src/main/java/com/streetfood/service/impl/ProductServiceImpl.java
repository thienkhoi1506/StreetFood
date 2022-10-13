package com.streetfood.service.impl;

import com.streetfood.pojo.Product;
import com.streetfood.repository.interfaces.ProductRepository;
import com.streetfood.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public long count() {
        return productRepository.count();
    }

    @Override
    public <S extends Product> S save(S entity) {
        return productRepository.save(entity);
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return productRepository.findById(aLong);
    }

    @Override
    public void deleteById(Long aLong) {
        productRepository.deleteById(aLong);
    }

    @Override
    public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
        return productRepository.findAll(example, pageable);
    }
}
