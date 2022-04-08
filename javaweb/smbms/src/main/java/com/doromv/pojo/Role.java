package com.doromv.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * (SmbmsRole)实体类
 *
 * @author makejava
 * @since 2022-01-20 17:41:06
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 454878647851918295L;
    /**
     * 主键ID
     */
    private int id;
    /**
     * 角色编码
     */
    private String rolecode;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 创建者
     */
    private Long createdby;
    /**
     * 创建时间
     */
    private Date creationdate;
    /**
     * 修改者
     */
    private Long modifyby;
    /**
     * 修改时间
     */
    private Date modifydate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Long getModifyby() {
        return modifyby;
    }

    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

}

