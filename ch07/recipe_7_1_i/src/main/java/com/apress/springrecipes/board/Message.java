package com.apress.springrecipes.board;

import org.hibernate.validator.constraints.NotEmpty;

public class Message {

    private Long id;
    private String author;

    @NotEmpty
    private String title;
    @NotEmpty
    private String body;

    public String getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {

        return String.format("Message [id=%d, subject=%s, author=%s]%n",this.id, this.title, this.author);
    }
}
