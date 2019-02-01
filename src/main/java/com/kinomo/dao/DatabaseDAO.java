package com.kinomo.dao;

import com.kinomo.model.User;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;


//implement later
public class DatabaseDAO implements DAO {
    private User obj;
    private String user = "platform";
    private char[] password = new char[]{'S', 'B', 'U', 'h', 'X', '8', 'K', 'm', 'p', 'c', 'r', '7', 'T'};
    private String source = "stage-platform";
    private MongoCollection<Document> collection;

    public DatabaseDAO() {
        initialize("users");
    }

    @Override
    public void initialize(String userObject) {
        //MongoCredential credential = MongoCredential.createCredential(user, source, password);
        ConnectionString connectionString = new ConnectionString("mongodb://platform:SBUhX8Kmpcr7T@10.10.0.27:27017,10.10.0.26:27017,10.10.0.28:27017");
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase(source);
        MongoCollection<Document> collection = database.getCollection(userObject);
        System.out.println(collection.countDocuments());
    }

    @Override
    public User getById(int id) {
        BasicDBObject query = new BasicDBObject();
        query.append("id", id);
        //DBObject result =
        collection.countDocuments();
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
