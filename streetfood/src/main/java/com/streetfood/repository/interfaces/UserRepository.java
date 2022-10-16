package com.streetfood.repository.interfaces;

import com.streetfood.pojo.Product;
import com.streetfood.pojo.User;

import java.util.List;

public interface UserRepository {
    public List<User> getUsers();
    public void saveUser(User user);
    public User getUser(long id);
    public void deleteUser(long id);
}
