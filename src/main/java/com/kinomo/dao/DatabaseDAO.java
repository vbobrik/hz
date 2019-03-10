package com.kinomo.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kinomo.model.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;

import javax.print.Doc;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import static com.mongodb.client.model.Filters.eq;


//implement later
public class DatabaseDAO implements DAO {
    private User userOne;
    private String user = "platform";
    private char[] password = new char[]{'S', 'B', 'U', 'h', 'X', '8', 'K', 'm', 'p', 'c', 'r', '7', 'T'};
    private String source = "test";
    CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));

    private MongoCollection<User> collection;


//    public DatabaseDAO() {
//        initialize("users");
//    }

    @Override
    public void initialize(String userObject)throws FileNotFoundException {
        //MongoCredential credential = MongoCredential.createCredential(user, source, password);
        //ConnectionString connectionString = new ConnectionString("mongodb://platform:SBUhX8Kmpcr7T@10.10.0.27:27017,10.10.0.26:27017,10.10.0.28:27017");
        ConnectionString connectionString = new ConnectionString("mongodb://127.0.0.1:27017");
        //MongoClient mongoClient = MongoClients.create(connectionString);
        MongoClient mongoClient = new MongoClient(new ServerAddress("127.0.0.1:27017"), MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());

        MongoDatabase database = mongoClient.getDatabase(source).withCodecRegistry(pojoCodecRegistry);
        collection = database.getCollection(userObject, User.class);
        System.out.println(collection.count());
        //Gson gson = new Gson();
       // BufferedReader string = new BufferedReader(new FileReader(collection.find().toString()));
        //TypeToken type = new TypeToken<List<User>>() {};
        //userList = gson.fromJson(collection.find().toString(), type.getType());
        //System.out.println(userList);
        
    }

    @Override
    public User getById(String userId) {

        return collection.find(eq("_id", userId)).first();

    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        for (User one : collection.find().skip(0).limit(10)) {
            userList.add(one);
        }

       return userList;
    }

    @Override
    public Map<String, List<User>> getUnique() {
        Map<String, List<User>> newMap = new HashMap<>();
        Set<String> newSet = new HashSet<>();
        for (User userThis: collection.find().skip(0).limit(10)) {
            newSet.add(userThis.getMale());
        }
        for(String male: newSet) {
            List<User> userList = new ArrayList<>();
            for(User user: collection.find().skip(0).limit(10)) {
                if(male.equals(user.getMale())) {
                    userList.add(user);
                }
            }
            newMap.put(male, userList);
        }
        return newMap;

    }
}
