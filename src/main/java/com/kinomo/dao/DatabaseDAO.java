package com.kinomo.dao;

import com.kinomo.model.User;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

//implement later
public class DatabaseDAO implements DAO {
    private  User obj;

    @Override
    public void initialize(String userObject) throws FileNotFoundException {

    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Map<String, List<User>> getUnique() {
        return null;
    }
}
