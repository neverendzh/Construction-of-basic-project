package com.kaishengit.service.service.impl;

import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.User;
import com.kaishengit.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zh
 * Created by Administrator on 2017/10/31.
 * 用于测试回滚，手动跑出异常，如果执行一次save之后跑出异常，那么数据库就会回滚到第一次save执行之前的状态
 * 1.注意：@Transactional注解，在默认情况下，出现RuntimeException，及其子类时会自动回滚事务，如果不是运行时
 *  异常那么这个回滚事务的注解就会失效。
 *  解决办法：@Transactional()有一个属性rollbackFor 设置为Exception.class.那么出现非运行异常时也会回滚事务
 * 2.注意
 *  通过isolation属性改变事务的隔离级别
 *         1.EDFAULT 使用数据库默认的隔离级别
 *         2.READ_UNCOMMITTED 允许读取尚未提交的数据，可能导致脏读，幻读和不可重复读
 *         3.READ_COMMITED 允许已经提交的并发事务读取，可以防止脏读。单依然会出现幻读和不可重复读
 *         4.REPEATABLE_READ 对相同字段的多次读取结果是相同的，除非数据被当前事务改变。可以防止脏读和不可重复读，但依然会出现幻读
 *         5.SERIALLZABLE 完全符合ACID的隔离级别，确保不会发生脏读，幻读，和不可重读读
 *3.可以通过propagation这个属性来修改事务的传播属性
 *          默认使用的是REQUIRED
 * 事务的传播属性值--->就是一个带事务的方法在另一个带事务的方法中运行时，这个两个事务的处理方式
 *
 * 4.readOnly属性设置为true时为只读事务
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional(rollbackFor = Exception.class,
            isolation = Isolation.SERIALIZABLE,
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public void save(User user) throws Exception {

        userDao.save(user);
        if(1==1){

                throw new Exception();
            }
        userDao.save(user);
    }

}