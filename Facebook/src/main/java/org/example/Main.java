package org.example;

public class Main {
    public static void main(String[] args) {
        FacebookLite facebook = new FacebookLite();

        // Register users
        facebook.registerUser("user1", "user1@example.com", "password1");
        facebook.registerUser("user2", "user2@example.com", "password2");

        // Login
        User user1 = facebook.login("user1@example.com", "password1");
        User user2 = facebook.login("user2@example.com", "password2");

        // Make user1 friends with user2
        facebook.sendFriendRequest(user1, user2);
        facebook.acceptFriendRequest(user2, user1);

        // User1 creates a post
        user1.createPost("Hello, world!");

        // User2 comments on user1's post
        user2.commentOnPost(user1.getPosts().get(0), "Nice post!");

        // User2 likes user1's post
        user2.likePost(user1.getPosts().get(0));

        // User1 sends a message to user2
        user1.sendMessage(user2, "Hi, how are you?");
    }

}
