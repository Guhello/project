package com.qfedu.dao;

import com.qfedu.entity.User;

import java.util.List;

public interface UserDao {

    public User findByName(String name);

    public List<String> findRoleByName(String name);

    public List<String> findPermsByName(String name);
}
