package org.example;

class Notification {
    private String title;
    private String content;
    private User recipient;
    private User sender;

    public Notification(String title, String content, User sender) {
        this.title = title;
        this.content = content;
        this.sender = sender;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getSender() {
        return sender;
    }
}