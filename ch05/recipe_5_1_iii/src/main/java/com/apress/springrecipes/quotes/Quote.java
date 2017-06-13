package com.apress.springrecipes.quotes;

public class Quote {

    private long id;
    private String joke;
    private String[] categories;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return String.format("Quote (id=%s, joke=%s)", this.id, this.joke);
    }
}
