package com.neverend.service.impl;

import com.neverend.entity.KaoLa;
import com.neverend.service.KaoLaService;

/**
 * Created by Administrator on 2018/2/25.
 */
public class KaoLaServiceImpl implements KaoLaService {
    private KaoLa kaoLa;

    public KaoLaServiceImpl() {
    }

    public KaoLaServiceImpl(KaoLa kaoLa) {
        this.kaoLa = kaoLa;
    }

    public void setKaoLa(KaoLa kaoLa){
        this.kaoLa = kaoLa;
    }
    @Override
    public void save() {
       kaoLa.setName("tom");
        System.out.println(kaoLa.getName());
    }
}