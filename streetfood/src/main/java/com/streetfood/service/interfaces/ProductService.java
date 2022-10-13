package com.streetfood.service.interfaces;

import com.streetfood.pojo.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    long count();

    <S extends Product> S save(S entity);

    Optional<Product> findById(Long aLong);

    void deleteById(Long aLong);

    <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);
}
