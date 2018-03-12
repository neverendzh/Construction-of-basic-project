package com.neverend.service.impl;

import com.neverend.baseTest.BaseTest;
import com.neverend.entity.Kaola;
import com.neverend.service.KaoLaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/2/26.
 */

public class KaoLaServiceImplTest extends BaseTest {
    @Autowired
    private KaoLaService kaoLaService;
    @Test
    public void findfById() throws Exception {
        Kaola kaola = kaoLaService.findfById(2177);
        System.out.println(kaola);
    }

}