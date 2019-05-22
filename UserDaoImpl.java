package com.neuedu.dao;

import com.neuedu.pojo.User;
import com.neuedu.dataSource.DruidDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{

    private QueryRunner qr = null;

    private DruidDataSource dds = DruidDataSource.getDataSource();

    public UserDaoImpl(){

        qr = new QueryRunner();

    }

    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM user";
        List<User> users = null;
        try {
            users = qr.query(dds.getConnection(),sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(dds.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }
}
