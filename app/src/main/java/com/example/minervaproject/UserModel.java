package com.example.minervaproject;

public class UserModel {
    private String Email;
    private String Name;
    private String id;

    public UserModel() {
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "Email='" + Email + '\'' +
                ", Name='" + Name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
