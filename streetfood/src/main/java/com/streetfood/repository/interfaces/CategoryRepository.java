package com.streetfood.repository.interfaces;

import com.streetfood.pojo.Category;

import java.util.List;

public interface CategoryRepository {
    public List<Category> getCategories();
    public void saveCategories (Category category);
    public Category getCategory (long id);
    public void deleteCategory (long id);
}
