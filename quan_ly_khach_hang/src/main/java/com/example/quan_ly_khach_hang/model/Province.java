package com.example.quan_ly_khach_hang.model;

public class Province {
    private int id;
    private String name;

    public Province(String name) {
        this.name = name;
    }

    public Province(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Province() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
