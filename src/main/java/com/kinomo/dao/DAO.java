package com.kinomo.dao;

import com.kinomo.model.User;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface DAO {

    //initialize user list (read all json files and add into list)
    void initialize(String userObject) throws FileNotFoundException;

    //get specific User by id
    User getById(int id);

    //get all users
    List<User> getAll();

    //get users from unique cities (key - city, value - user list)
    Map<String, List<User>> getUnique();

    //...

}
