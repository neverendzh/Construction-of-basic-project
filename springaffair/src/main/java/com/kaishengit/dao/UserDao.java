package com.kaishengit.dao;

import com.kaishengit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 * @author zh
 * Created by Administrator on 2017/10/31.
 *
 *在事务中，如果我们使用jdbcTemplate这个类跑出异常是那么，跑出的所有异常都是运行时异常，那么设置的
 * @Transactional就会自动回滚。
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public  void  save(User user){

        String sql = "insert into t_user(user_name,passwords,address,dept_id) values(?,?,?,?)";
        jdbcTemplate.update(sql,user.getUserName(),user.getPasswords(),user.getAddress(),user.getDeptId());
    }


    public User findById(Long id){
        String sql = "select * from t_user where id = ? ";
        //return jdbcTemplate.queryForObject(sql, new TuserMapper(),id);
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),id);
    }

    public List<User> findAll(){
        String sql = "select * from t_user order by id desc";

        return jdbcTemplate.query(sql, new UserMapper());
    }

    public Long count(){
        String sql = "select count(*) from t_user";
        return  jdbcTemplate.queryForObject(sql,Long.class);
    }

    private class UserMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setUserName(resultSet.getString("user_name"));
            user.setPasswords(resultSet.getString("passwords"));
            user.setAddress(resultSet.getString("address"));
            user.setDeptId(resultSet.getInt("dept_id"));
            user.setId(resultSet.getInt("id"));
            return user;
        }
    }
}

