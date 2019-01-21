package com.kinomo;

import com.google.gson.reflect.TypeToken;
import com.kinomo.dao.DAO;
import com.kinomo.dao.DAOFactory;
import com.kinomo.dao.DAOFactory.DAOKeys;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.kinomo.dao.JsonDAO;
import com.kinomo.model.User;
import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) throws FileNotFoundException {
        DAO dao = DAOFactory.get(DAOKeys.JSON);

        //...
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(
                new FileReader("src/main/java/com/kinomo/users.json"));

        //convert the json string back to object
        //User json = gson.fromJson(br, User.class);
        //dao.initialize(json);

        //or
        //User json = gson.fromJson(new FileReader("D:\\file.json"), User.class);
        //List<User> users = new ArrayList<User>();
        //users.add(json);

        Type listType = new TypeToken<List<User>>(){}.getType();
        List<User> posts = gson.fromJson(br, listType);

        for(User oneUser : posts) {
            dao.initialize(oneUser);
        }
        dao.getById(123);
        System.out.println(posts.get(1).getPhone());


        //System.out.println(obj);


    }
}
