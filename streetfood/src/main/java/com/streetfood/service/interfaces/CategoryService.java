package com.streetfood.service.interfaces;

import com.streetfood.pojo.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getCategories();
    public void saveCategories (Category category);
    public Category getCategory (long id);
    public void deleteCategory (long id);
}
