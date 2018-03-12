package com.neverend.dao;

import com.neverend.entity.KaoLa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/2/25.
 */
@Repository
public class KaoLaDao {
    @Autowired
    public JdbcTemplate jdbcTemplat;

    public KaoLa findById(int id){
                    KaoLa kaoLa = new KaoLa();
        String sql = "select * from kaola where id = ?";
            jdbcTemplat.queryForObject(sql, new RowMapper<KaoLa>() {
                @Override
                public KaoLa mapRow(ResultSet resultSet, int i) throws SQLException {
                    kaoLa.setId(resultSet.getInt("id"));
                    kaoLa.setProductName(resultSet.getString("product_name"));
                    return kaoLa;
                }
            },id);


        return kaoLa;
    }
}