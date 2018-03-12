package com.neverend.service;

import com.github.pagehelper.PageInfo;
import com.neverend.entity.Kaola;
import com.neverend.entity.KaolaType;

import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */
public interface KaoLaService {
    Kaola findfById(Integer id);
    PageInfo<Kaola> findpage(Integer page);
    List<String> findProductPlaceList();
    List<KaolaType> findAllType();

}