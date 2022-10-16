package com.streetfood.repository.impl;

import com.streetfood.pojo.Product;
import com.streetfood.pojo.User;
import com.streetfood.repository.interfaces.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> productCriteriaQuery = builder.createQuery(User.class);
        Root<User> root = productCriteriaQuery.from(User.class);
        productCriteriaQuery.select(root);
        Query query = session.createQuery(productCriteriaQuery);
        return query.getResultList();
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getUser(long id) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }
}
