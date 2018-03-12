package com.neverend.service.impl;

import com.neverend.entity.Kaola;
import com.neverend.mapper.KaolaMapper;
import com.neverend.service.KaoLaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/2/26.
 */
@Service
public class KaoLaServiceImpl implements KaoLaService {
    @Autowired
    private KaolaMapper kaolaMapper;
    @Override
    public Kaola findfById(Integer id) {
        return kaolaMapper.selectByPrimaryKey(id);
    }
}