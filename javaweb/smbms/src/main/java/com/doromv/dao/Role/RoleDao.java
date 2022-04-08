package com.doromv.dao.Role;

import com.doromv.pojo.Role;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-01-28-10:26
 */
public interface RoleDao {
    //获取角色列表
    public List<Role> getRoleList(Connection connection) throws SQLException;
}
