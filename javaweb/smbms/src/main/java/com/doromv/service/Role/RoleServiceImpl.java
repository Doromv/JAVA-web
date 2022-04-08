package com.doromv.service.Role;

import com.doromv.dao.BaseDao;
import com.doromv.dao.Role.RoleDao;
import com.doromv.dao.Role.RoleDaoImpl;
import com.doromv.pojo.Role;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-01-28-10:29
 */
public class RoleServiceImpl implements RoleService{
    private RoleDao roleDao;

    public RoleServiceImpl() {
        roleDao=new RoleDaoImpl();
    }
    public List<Role> getRoleLis() {
        Connection connection = BaseDao.getconnection();
        List<Role> roleList=null;
        if (connection != null) {
            try {
                roleList= roleDao.getRoleList(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                BaseDao.closeResource(connection,null,null);
            }
        }
        return roleList;
    }
}
