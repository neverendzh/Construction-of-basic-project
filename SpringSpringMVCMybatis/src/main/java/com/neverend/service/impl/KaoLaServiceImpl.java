package com.neverend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neverend.entity.Kaola;
import com.neverend.entity.KaolaExample;
import com.neverend.entity.KaolaType;
import com.neverend.mapper.KaolaMapper;
import com.neverend.service.KaoLaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class KaoLaServiceImpl implements KaoLaService {
    @Autowired
    private KaolaMapper kaolaMapper;
    @Override
    public Kaola findfById(Integer id) {
        return kaolaMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Kaola> findpage(Integer page) {
        PageHelper.startPage(page,10);

        KaolaExample kaolaExample = new KaolaExample();

        List<Kaola> kaolas = kaolaMapper.selectByExample(kaolaExample);
        return new PageInfo<Kaola>(kaolas);
    }

    @Override
    public List<String> findProductPlaceList() {
        return null;
    }

    @Override
    public List<KaolaType> findAllType() {
        return null;
    }


}