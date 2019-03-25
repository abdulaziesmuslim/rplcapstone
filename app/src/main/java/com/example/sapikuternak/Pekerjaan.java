package com.example.sapikuternak;

import java.io.Serializable;

public class Pekerjaan {

    public String key, id, text;

    public Pekerjaan (){}

    public Pekerjaan (String key, String id, String text){
        this.key = key;
        this.id = id;
        this.text = text;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
