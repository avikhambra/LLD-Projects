package org.example;

class Comment {
    private String commentId;
    private String text;
    private User commenter;

    public Comment(String text, User commenter) {
        this.text = text;
        this.commenter = commenter;
    }

    public String getText() {
        return text;
    }

    public User getCommenter() {
        return commenter;
    }
}
