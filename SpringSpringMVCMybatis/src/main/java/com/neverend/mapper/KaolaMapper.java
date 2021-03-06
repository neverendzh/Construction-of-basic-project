package com.neverend.mapper;

import com.neverend.entity.Kaola;
import com.neverend.entity.KaolaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KaolaMapper {
    long countByExample(KaolaExample example);

    int deleteByExample(KaolaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Kaola record);

    int insertSelective(Kaola record);

    List<Kaola> selectByExample(KaolaExample example);

    Kaola selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Kaola record, @Param("example") KaolaExample example);

    int updateByExample(@Param("record") Kaola record, @Param("example") KaolaExample example);

    int updateByPrimaryKeySelective(Kaola record);

    int updateByPrimaryKey(Kaola record);
    List<String> findAllPlace();
}