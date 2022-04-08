package com.doromv.dao.user;

import com.doromv.dao.BaseDao;
import com.doromv.pojo.Role;
import com.doromv.pojo.User;
import com.mysql.jdbc.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-01-21-11:15
 */
public class UserDaoImpl implements UserDao{
    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        User user=null;
        if(connection!=null) {
        String sql="select * from smbms_user where userCode=?";
        Object[] params={userCode};

                rs = BaseDao.execute(connection, preparedStatement, rs, sql, params);
                if(rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUserCode(rs.getString("userCode"));
                    user.setUserName(rs.getString("userName"));
                    user.setUserpassword(rs.getString("userPassword"));
                    user.setGender(rs.getInt("gender"));
                    user.setBirthday(rs.getDate("birthday"));
                    user.setPhone(rs.getString("phone"));
                    user.setAddress(rs.getString("address"));
                    user.setUserrole(rs.getInt("userRole"));
                    user.setCreatedby(rs.getInt("createdBy"));
                    user.setCreationdate(rs.getTimestamp("creationDate"));
                    user.setModifyby(rs.getInt("modifyBy"));
                    user.setModifydate(rs.getTimestamp("modifyDate"));
                }
                BaseDao.closeResource(null,preparedStatement,rs);

        }
        return user;
    }

    public int updatePwd(Connection connection, int id, String password) throws SQLException {
        //修改当前用户密码
        PreparedStatement ps=null;
        int execute=0;
        if(connection!=null) {
            String sql = "update smbms_user set userPassword=? where id=?";
            Object[] params = {password, id};
            execute=BaseDao.execute(connection, ps, sql, params);
            BaseDao.closeResource(null, ps, null);
        }
        return execute;
    }

    public int getUserCount(Connection connection, String username,int userRole) throws SQLException {
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        int count=0;
        if(connection!=null){
            StringBuffer sql=new StringBuffer();
            ArrayList<Object> list = new ArrayList<Object>();
            sql.append("select count(1) as count from smbms_user u,smbms_role r where u.userRole=r.id");
            if(!StringUtils.isNullOrEmpty(username)){
                sql.append("and u.userName like ?");
                list.add("%"+username+"%");
            }
            if(userRole>0){
                sql.append(" and u.userRole= ?");
                list.add(userRole);
            }
            Object[] params = list.toArray();
            System.out.println("UserDaoImpl->getUserCount:"+sql.toString());
            rs = BaseDao.execute(connection, preparedStatement, rs, sql.toString(), params);
            if(rs.next()){
                 count = rs.getInt("count");
            }
            BaseDao.closeResource(null,preparedStatement,rs);
        }
        return count;
    }

    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws SQLException {

        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        List<User> userList=new ArrayList<User>();
        int count=0;
        if(connection!=null){
            StringBuffer sql=new StringBuffer();
            List<Object> list = new ArrayList<Object>();
            sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole=r.id");
            if(!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and u.userName like ?");
                list.add("%"+userName+"%");
            }
            if(userRole>0){
                sql.append("and u.userRole = ?");
                list.add(userRole);
            }
            //再数据库中，分页使用 limit startIndex,pageSize;总数
            sql.append(" order by creationDate DESC limit ?,?");
            currentPageNo=(currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);
            Object[] params = list.toArray();
            System.out.println("UserDaoImpl->getUserList:"+sql.toString());
            rs = BaseDao.execute(connection, preparedStatement, rs, sql.toString(), params);

            while (rs.next()){
                User _user=new User();
                _user.setId(rs.getInt("id"));
                _user.setUserCode(rs.getString("userCode"));
                _user.setUserName(rs.getString("userName"));
                _user.setGender(rs.getInt("gender"));
                _user.setBirthday(rs.getDate("birthday"));
                _user.setPhone(rs.getString("phone"));
                _user.setUserrole(rs.getInt("userRole"));
                _user.setUserRoleName(rs.getString("userRoleName"));
                userList.add(_user);
            }
            BaseDao.closeResource(null,preparedStatement,rs);
        }
        return userList;
    }

}
