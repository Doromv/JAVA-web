package com.doromv.dao.Role;

import com.doromv.dao.BaseDao;
import com.doromv.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-01-28-10:27
 */
public class RoleDaoImpl implements RoleDao{
    public List<Role> getRoleList(Connection connection) throws SQLException {
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        ArrayList<Role> roleList = new ArrayList<Role>();
        if(connection!=null){
            String sql="select * from smbms_role";
            Object[] params={ };
            resultSet=BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            while (resultSet.next()){
                Role _role=new Role();
                _role.setId(resultSet.getInt("id"));
                _role.setRolecode(resultSet.getString("roleCode"));
                _role.setRoleName(resultSet.getString("roleName"));
                roleList.add(_role);
            }
            BaseDao.closeResource(null,preparedStatement,resultSet);
        }
        return roleList;
    }
}
