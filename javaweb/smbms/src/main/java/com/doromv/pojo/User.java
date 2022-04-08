package com.doromv.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * (SmbmsUser)实体类
 *
 * @author makejava
 * @since 2022-01-20 17:41:06
 */
public class User implements Serializable {
    private static final long serialVersionUID = -64010957856528908L;
    /**
     * 主键ID
     */
    private int id;
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userpassword;
    /**
     * 性别（1:女、 2:男）
     */
    private Integer gender;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 手机
     */
    private String phone;
    /**
     * 地址
     */
    private String address;
    /**
     * 用户角色（取自角色表-角色id）
     */
    private int userrole;
    /**
     * 创建者（userId）
     */
    private int createdby;
    /**
     * 创建时间
     */
    private Date creationdate;
    /**
     * 更新者（userId）
     */
    private int modifyby;
    /**
     * 更新时间
     */
    private Date modifydate;

    private Integer age;//年龄
    private String userRoleName;//用户角色名称
    public String getUserRoleName(){return userRoleName;}
    public void setUserRoleName(String userRoleName){this.userRoleName=userRoleName;}
    public Integer getAge(){
        Date date=new Date();
        Integer age=date.getYear()-birthday.getYear();
        return age;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String usercode) {
        this.userCode = usercode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserrole() {
        return userrole;
    }

    public void setUserrole(int userrole) {
        this.userrole = userrole;
    }

    public int getCreatedby() {
        return createdby;
    }

    public void setCreatedby(int createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public int getModifyby() {
        return modifyby;
    }

    public void setModifyby(int modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

}

