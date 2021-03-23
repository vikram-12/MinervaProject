package com.example.minervaproject;

public class PostModel {
    private String Name;
    private String  Post;

    public PostModel() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "Name='" + Name + '\'' +
                ", Post='" + Post + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }
}

