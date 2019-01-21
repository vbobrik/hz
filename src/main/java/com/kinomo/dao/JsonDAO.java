package com.kinomo.dao;

import com.kinomo.model.User;

import java.util.*;


public class JsonDAO implements DAO {

    private List<User> users = new ArrayList<>(1000);

    public JsonDAO() {
        if (users == null) {
            //initialize(obj) = new User(1, "Nik", 65, "man", 678679);
        }
    }

    @Override
    public void initialize(User obj) {
       this.users.add(obj);
    }

    @Override
    public User getById(int id) {
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
       //return users.get(users.getAll);
        return null;
    }

    @Override
    public Map<String, List<User>> getUnique() {
         //users = new HashMap<>();
       // return users.getClass();
        return null;
    }
}
