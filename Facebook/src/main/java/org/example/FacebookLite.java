package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FacebookLite {

        private List<User> users;

        public FacebookLite() {
            this.users = new ArrayList<>();
        }

        public void registerUser(String username, String email, String password) {
            // Generate userId
            String userId = UUID.randomUUID().toString();
            User user = new User(userId, username, email, password);
            users.add(user);
            System.out.println("User registered successfully: " + username);
        }

        public User login(String email, String password) {
            for (User user : users) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    System.out.println(user.getUsername() + " logged in successfully");
                    return user;
                }
            }
            System.out.println("Login failed. Invalid email or password.");
            return null;
        }

        public void sendFriendRequest(User sender, User recipient) {
            recipient.receiveFriendRequest(sender);
            System.out.println(sender.getUsername() + " sent a friend request to " + recipient.getUsername());
        }

        public void acceptFriendRequest(User recipient, User sender) {
            recipient.acceptFriendRequest(sender);
            System.out.println(recipient.getUsername() + " accepted the friend request from " + sender.getUsername());
        }

        public void rejectFriendRequest(User recipient, User sender) {
            recipient.rejectFriendRequest(sender);
            System.out.println(recipient.getUsername() + " rejected the friend request from " + sender.getUsername());
        }

}
