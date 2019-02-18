package com.kinomo.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kinomo.model.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.ConnectionString;

import javax.print.Doc;

import static com.mongodb.client.model.Filters.eq;


//implement later
public class DatabaseDAO implements DAO {
    private List<User> userList = null;
    private User userOne = null;
    private String user = "platform";
    private char[] password = new char[]{'S', 'B', 'U', 'h', 'X', '8', 'K', 'm', 'p', 'c', 'r', '7', 'T'};
    private String source = "stage-platform";
    private MongoCollection<Document> collection;

//    public DatabaseDAO() {
//        initialize("users");
//    }

    @Override
    public void initialize(String userObject)throws FileNotFoundException {
        //MongoCredential credential = MongoCredential.createCredential(user, source, password);
        ConnectionString connectionString = new ConnectionString("mongodb://platform:SBUhX8Kmpcr7T@10.10.0.27:27017,10.10.0.26:27017,10.10.0.28:27017");
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase(source);
        collection = database.getCollection(userObject);
        System.out.println(collection.countDocuments());
        Gson gson = new Gson();
       // BufferedReader string = new BufferedReader(new FileReader(collection.find().toString()));
        TypeToken type = new TypeToken<List<User>>() {};
        userList = gson.fromJson(collection.find().toString(), type.getType());
        System.out.println(userList);
        
    }

    @Override
    public User getById(String userId) {

//        Document document = collection.find(eq("_id", userId)).first();
//        String a = collection.find(eq("_id", userId)).first().toJson();
//        System.out.println(document.toJson());
      // return userList.get(userOne).equals(userId);
        for(User user: userList) {
            if(user.getId().equals(userId)) {
                return userOne;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {

//        for (Document document : collection.find().skip(0).limit(10)) {
////            System.out.println(document.toJson());
////        }
        return userList;
    }

    @Override
    public Map<String, List<User>> getUnique() {
        Map<String, List<User>> newMap = new HashMap<>();
        for (User user: userList) {

            List<User> myUsers = newMap.get(user.getClientId());

            if (myUsers.equals("5866fd1c29be752ef7808fc3")) {
               myUsers  = new ArrayList<>();
                newMap.put(user.getClientId(), myUsers);
            }
            myUsers.add(user);
        }
        return newMap;

    }
}
