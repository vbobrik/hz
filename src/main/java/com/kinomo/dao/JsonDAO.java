package com.kinomo.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.kinomo.model.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;


public class JsonDAO implements DAO {

    private List<User> users;

    public JsonDAO() throws FileNotFoundException {
        if (users == null) {
            String user = "src/main/java/com/kinomo/users.json";
            initialize(user);
        }
    }

    @Override
    public void initialize(String userObject) throws FileNotFoundException {

        //convert the json string back to object
        Gson gson = new Gson();
        JsonReader string = new JsonReader(new FileReader(userObject));
        TypeToken type = new TypeToken<List<User>>() {};
        users = gson.fromJson(string,  type.getType());
        System.out.println(users);
        //User jsonObject = gson.fromJson(string, User.class);
        //System.out.println(jsonObject);
    }

    @Override
    public User getById(int indexOfUser) {
       User object = users.get(indexOfUser);
        return object;
    }

    @Override
    public List<User> getAll() {

        for(User user: users) {
            System.out.println(user.getName());
        }

        return users;
    }

    @Override
    public Map<String, List<User>> getUnique() {
        Map<String, List<User>> anyKey  = new HashSet<>(users);
((HashSet) anyKey).addAll(users);

       // return users.getClass();
        return anyKey;
    }
}
