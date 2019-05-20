package com.neuedu.dao;

import com.neuedu.pojo.User;
import com.neuedu.utils.DBUtils;

import java.sql.*;

public class UserDaoImpl implements UserDao{

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String URL = "jdbc:mysql:///20190517";

    private static final String USERNAME = "root";

    private static final String PASSWORD= "256489";

    @Override
    public void register(String user, String psw) {


        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String sql = "INSERT INTO user(username,psw) VALUES (?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user);
            pstmt.setString(2,psw);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != pstmt){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (null != conn) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public User login(User user) {
        Connection connection = DBUtils.getConnection();
        String sql = "select username,psw from user where username = ? and psw = ?";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeRs(resultSet);
            DBUtils.closePstmt(preparedStatement);
            DBUtils.closeConnection(connection);
        }
        return null;
    }
}
