package com.kinomo.dao;

import com.kinomo.model.User;

import java.util.*;

import com.kinomo.model.User;

public class JsonDAO implements DAO {

    private static List<User> users;
    private User obj;

    public JsonDAO() {
        if (users == null) {
            initialize();
        }
    }

    @Override
    public void initialize() {
        //users.add(obj);
    }

    @Override
    public User getById(int id) {
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
       //return users.get();
        return null;
    }

    @Override
    public Map<String, List<User>> getUnique() {
         //users = new HashMap<>();
       // return users.getClass();
        return null;
    }
}
