package org.example;

import java.util.ArrayList;
import java.util.List;


class Page {
    private String pageId;
    private String name;
    private User admin;
    private List<User> followers;
    private List<Post> posts;

    public Page(String name, User admin) {
        this.name = name;
        this.admin = admin;
        this.followers = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void addFollower(User follower) {
        followers.add(follower);
    }

    public void removeFollower(User follower) {
        followers.remove(follower);
    }

    public void createPost(String text) {
        Post post = new Post(text, admin);
        posts.add(post);
        System.out.println(admin.getUsername() + " created a post on " + name + "'s page: " + text);
    }

    public List<User> getFollowers() {
        return followers;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public String getName() {
        return name;
    }
}