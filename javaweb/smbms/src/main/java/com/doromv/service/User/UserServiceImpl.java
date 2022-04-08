package com.doromv.service.User;

import com.doromv.dao.BaseDao;
import com.doromv.dao.user.UserDao;
import com.doromv.dao.user.UserDaoImpl;
import com.doromv.pojo.User;
import jdk.internal.dynalink.beans.CallerSensitiveDetector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-01-21-11:56
 */
public class UserServiceImpl implements UserService{
    //业务层都会调用DAO层，所以我们要引入DAO层
    private UserDao userDao;
    public UserServiceImpl(){
        userDao=new UserDaoImpl();
    }
    public User login(String userCode, String password) {
        Connection connection=null;
        User user=null;
        try {
            connection= BaseDao.getconnection();
            //通过业务层调用对应的具体数据库操作
            user= userDao.getLoginUser(connection, userCode);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }

    public boolean updatePwd(int id, String password) {
        Connection connection=null;
       boolean falg=false;
        try {
            connection=BaseDao.getconnection();
            if(userDao.updatePwd(connection,id,password)>0){
                falg=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return falg;
    }

    public int getUserCount(String username, int userRole) {
        Connection connection=null;
        int count=0;
        try {
            connection = BaseDao.getconnection();
            count=userDao.getUserCount(connection,username,userRole);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return count;
    }

    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        Connection connection=null;
        List<User> userList=null;
        System.out.println("queryUserName->"+queryUserName);
        System.out.println("queryUserRole->"+queryUserRole);
        System.out.println("currentPageNo->"+currentPageNo);
        System.out.println("pageSize->"+pageSize);
        try {
            connection = BaseDao.getconnection();
            userList=userDao.getUserList(connection,queryUserName,queryUserRole,currentPageNo,pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return userList;
    }
}