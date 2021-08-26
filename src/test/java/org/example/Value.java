package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Value {
    public  long id;
    public List<String> categories;
    @JsonProperty
    public String joke;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}