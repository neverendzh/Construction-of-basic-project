package com.kaishengit.util;

/**
 * Created by Administrator on 2018/3/26.
 */
public class Score {
    private double english;
    private double chanice;
    private double math;
    private double hository;
    private double shengwu;
    private double huaxue;
    private double wuli;
    private double dili;

    public Score(double english, double chanice, double math, double hository, double shengwu, double huaxue, double wuli, double dili) {
        this.english = english;
        this.chanice = chanice;
        this.math = math;
        this.hository = hository;
        this.shengwu = shengwu;
        this.huaxue = huaxue;
        this.wuli = wuli;
        this.dili = dili;
    }

    public Score() {
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getChanice() {
        return chanice;
    }

    public void setChanice(double chanice) {
        this.chanice = chanice;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getHository() {
        return hository;
    }

    public void setHository(double hository) {
        this.hository = hository;
    }

    public double getShengwu() {
        return shengwu;
    }

    public void setShengwu(double shengwu) {
        this.shengwu = shengwu;
    }

    public double getHuaxue() {
        return huaxue;
    }

    public void setHuaxue(double huaxue) {
        this.huaxue = huaxue;
    }

    public double getWuli() {
        return wuli;
    }

    public void setWuli(double wuli) {
        this.wuli = wuli;
    }

    public double getDili() {
        return dili;
    }

    public void setDili(double dili) {
        this.dili = dili;
    }

    @Override
    public String toString() {
        return "Score{" +
                "english=" + english +
                ", chanice=" + chanice +
                ", math=" + math +
                ", hository=" + hository +
                ", shengwu=" + shengwu +
                ", huaxue=" + huaxue +
                ", wuli=" + wuli +
                ", dili=" + dili +
                '}';
    }
}