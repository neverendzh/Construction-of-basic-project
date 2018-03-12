package com.neverend.pojo;

/**
 * Created by Administrator on 2018/3/4.
 */
public class Movie {
    private int id;
    private String name;
    private String outh;

    public Movie() {
    }

    public Movie(int id, String name, String outh) {
        this.id = id;
        this.name = name;
        this.outh = outh;
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

    public String getOuth() {
        return outh;
    }

    public void setOuth(String outh) {
        this.outh = outh;
    }
}