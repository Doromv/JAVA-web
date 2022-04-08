package com.doromv.service.User;

import com.doromv.pojo.User;

import java.sql.Connection;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-01-21-11:55
 */
public interface UserService {
    //用户登入
    public User login(String userCode, String password);
    //根据用户ID修改密码
    public boolean updatePwd(int id,String password);
    //查询记录数
    public int getUserCount(String username,int userRole);
    //根据条件查询用户列表
    public List<User> getUserList( String queryUserName, int queryUserRole, int currentPageNo, int pageSize);
    //
}
