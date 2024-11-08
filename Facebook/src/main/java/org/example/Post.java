package org.example;

import java.util.ArrayList;
import java.util.List;


class Post {
    private String postId;
    private String text;
    private User author;
    private List<Comment> comments;
    private int likes;

    public Post(String text, User author) {
        this.text = text;
        this.author = author;
        this.comments = new ArrayList<>();
        this.likes = 0;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void like() {
        likes++;
    }

    public String getText() {
        return text;
    }

    public User getAuthor() {
        return author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public int getLikes() {
        return likes;
    }
}
