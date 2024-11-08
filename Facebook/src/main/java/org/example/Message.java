package org.example;

class Message {
    private String messageId;
    private String text;
    private User sender;
    private User recipient;

    public Message(String text, User sender, User recipient) {
        this.text = text;
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }
}

