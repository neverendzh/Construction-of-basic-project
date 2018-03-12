package com.neverend.pojo;

/**
 * Created by Administrator on 2018/3/4.
 */
public class User {
    private Integer id;
    private String name;
    private String auth;

    public User() {
    }

    public User(Integer id, String name, String auth) {
        this.id = id;
        this.name = name;
        this.auth = auth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}