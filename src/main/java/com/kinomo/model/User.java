package com.kinomo.model;

public class User {
    private String id;
    private String name;
    private int age;
    private String male;
    private int phone;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    private String clientId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public int getPhone() {
       return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + ", clientId='" + clientId+ '\'' +
                ", age=" + age +
                ", male='" + male + '\'' +
                ", phone=" + phone +
                '}';
    }

    public User(String id, String name, int age, String male, int phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.male = male;
        this.phone = phone;
    }


}
