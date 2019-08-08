package com.example.jo.databasecrud;

public class task {
    private String name;
    private int id;
    private int duration;

    public task(String name, int id, int duration) {
        this.name = name;
        this.id = id;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
