package com.streetfood.repository.impl;

import com.streetfood.pojo.Category;
import com.streetfood.pojo.Product;
import com.streetfood.repository.interfaces.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;
    @Override
    public List<Category> getCategories() {
        Session s = this.localSessionFactoryBean.getObject().getCurrentSession();
        Query q = s.createQuery("from Category ");

        return q.getResultList();
    }

    @Override
    public void saveCategories(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
    }

    @Override
    public Category getCategory(long id) {
        Session session = sessionFactory.getCurrentSession();
        Category category = session.get(Category.class, id);
        return category;
    }

    @Override
    public void deleteCategory(long id) {
        Session session = sessionFactory.getCurrentSession();
        Category category = session.byId(Category.class).load(id);
        session.delete(category);
    }
}
