package org.example;

import java.util.*;


class User {
    private String userId;
    private String username;
    private String email;
    private String password;
    private List<User> friends;
    private List<Post> posts;



    private List<Group> groups;
    private List<Page> pages;
    private List<Message> messages;
    private List<Notification> notifications;

    public User(String userId, String username, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.friends = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.pages = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public void addFriend(User friend) {
        friends.add(friend);
    }

    public void removeFriend(User friend) {
        friends.remove(friend);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void createPost(String text) {
        Post post = new Post(text, this);
        posts.add(post);
        System.out.println(username + " created a post: " + text);
    }

    public void joinGroup(Group group) {
        groups.add(group);
    }

    public void likePost(Post post) {
        post.like();
        System.out.println(username + " liked " + post.getAuthor().getUsername() + "'s post: " + post.getText());
    }

    public void commentOnPost(Post post, String text) {
        Comment comment = new Comment(text, this);
        post.addComment(comment);
        System.out.println(username + " commented on " + post.getAuthor().getUsername() + "'s post: " + text);
    }

    public void sendMessage(User recipient, String text) {
        Message message = new Message(text, this, recipient);
        messages.add(message);
        recipient.receiveMessage(message);
        System.out.println(username + " sent a message to " + recipient.getUsername() + ": " + text);
    }

    public void receiveMessage(Message message) {
        messages.add(message);
    }

    public void sendFriendRequest(User friend) {
        friend.receiveFriendRequest(this);
        System.out.println(username + " sent a friend request to " + friend.getUsername());
    }

    public void receiveFriendRequest(User sender) {
        Notification notification = new Notification("Friend Request", sender.getUsername() + " sent you a friend request.", sender);
        notifications.add(notification);
        System.out.println(username + " received a friend request from " + sender.getUsername());
    }

    public void acceptFriendRequest(User sender) {
        friends.add(sender);
        sender.addFriend(this);
        Notification notification = new Notification("Friend Request Accepted", "You are now friends with " + sender.getUsername() + ".", this);
        notifications.add(notification);
        System.out.println(username + " accepted the friend request from " + sender.getUsername());
    }

    public void rejectFriendRequest(User sender) {
        Notification notification = new Notification("Friend Request Rejected", "You rejected the friend request from " + sender.getUsername() + ".", this);
        notifications.add(notification);
        System.out.println(username + " rejected the friend request from " + sender.getUsername());
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public List<User> getFriends() {
        return friends;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public List<Page> getPages() {
        return pages;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }
}
