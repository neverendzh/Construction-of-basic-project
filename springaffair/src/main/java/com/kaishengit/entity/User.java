package com.kaishengit.entity;

/**
 * @author zh
 * Created by Administrator on 2017/10/31.
 */
public class User {
    private int id;
    private String userName;
    private String passwords;
    private String address;
    private int deptId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passwords='" + passwords + '\'' +
                ", address='" + address + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}
