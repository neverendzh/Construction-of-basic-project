package com.neverend.entity;

/**
 * Created by Administrator on 2018/2/25.
 */
public class KaoLa {
   /* public KaoLa(){
        System.out.println("kao la init");
    }*/

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "KaoLa{" +
                "name='" + name + '\'' +
                '}';
    }

    public void save(){
        if(1==1){
            throw new RuntimeException("这是手动引发的异常");
        }
        System.out.println("kao la save.......");
    }
}