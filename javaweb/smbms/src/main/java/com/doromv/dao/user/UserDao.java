package com.doromv.dao.user;

import com.doromv.pojo.Role;
import com.doromv.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-01-21-11:10
 */
public interface UserDao {
    //得到要登入的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException;
    //修改当前用户密码
    public int updatePwd(Connection connection,int id,String password) throws SQLException;
    //根据用户名或者角色名称查询用户总数
    public int getUserCount(Connection connection,String username,int userRole) throws SQLException;
    //获取用户列表
    public List<User> getUserList(Connection connection,String userName,int userRole,int currentPageNo,int pageSize) throws SQLException;
}
