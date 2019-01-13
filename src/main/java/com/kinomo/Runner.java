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

public class Runner {

    public static void main(String[] args) throws FileNotFoundException {
        DAO dao = DAOFactory.get(DAOKeys.JSON);

        //...
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(
                new FileReader("E:/hw/hz/src/main/java/com/kinomo/users.json"));

        //convert the json string back to object
        User json = gson.fromJson(br, User.class);
        //or
        //User json = gson.fromJson(new FileReader("D:\\file.json"), User.class);
        //List<User> users = json.getPhone();

        Map<String, User> obj = new HashMap<>();
        obj.containsKey(br);
        Type type = new TypeToken<Map<String, Integer>>(){}.getType();
        //Map<String, Integer> read = gson.fromJson(br, User.class);

        dao.initialize();
        System.out.println(json);


        //System.out.println(obj);


    }
}
