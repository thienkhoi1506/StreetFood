package com.streetfood.service.impl;

import com.streetfood.pojo.Category;
import com.streetfood.service.interfaces.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> getCategories() {
        return null;
    }

    @Override
    public void saveCategories(Category category) {

    }

    @Override
    public Category getCategory(long id) {
        return null;
    }

    @Override
    public void deleteCategory(long id) {

    }
}
