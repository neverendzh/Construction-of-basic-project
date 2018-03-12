package com.neverend.proxy;

/**
 * Created by Administrator on 2018/2/25.
 */
public class Proxy implements Salse {

    private Salse salse;

    public Proxy(Salse salse){
       this.salse = salse;
    }

    @Override
    public void salePc() {
        salse.salePc();
    }

}