package com.doromv.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.doromv.pojo.Role;
import com.doromv.pojo.User;
import com.doromv.service.Role.RoleService;
import com.doromv.service.Role.RoleServiceImpl;
import com.doromv.service.User.UserServiceImpl;
import com.doromv.util.Constant;
import com.doromv.util.PageSupport;
import com.mysql.jdbc.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2022-01-23-19:41
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=req.getParameter("method");
        if(method.equals("savepwd")&&method!=null){
            this.updatePwd(req,resp);
        }else if(method.equals("pwdmodify")&&method!=null){
            this.pwdModify(req,resp);
        }else if(method.equals("query")&&method!=null) {
            this.query(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    //修改密码
    public void updatePwd(HttpServletRequest req, HttpServletResponse resp){
        //从session里面拿ID
        Object attribute = req.getSession().getAttribute(Constant.USER_SESSION);
        String newpassword = req.getParameter("newpassword");
        boolean falg=false;
        if(attribute!=null&&!StringUtils.isNullOrEmpty(newpassword)){
            UserServiceImpl userService = new UserServiceImpl();
            falg = userService.updatePwd(((User) attribute).getId(), newpassword);
            if(falg){
                req.setAttribute("message","修改密码成功，请退出，使用新密码登入");
                //密码修改成功移除当前session
                req.getSession().removeAttribute(Constant.USER_SESSION);
            }else{
                req.setAttribute("message","修改密码失败");
            }
        }else{
            req.setAttribute("message","新密码有问题");
        }
        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //验证旧密码
    public void pwdModify(HttpServletRequest req, HttpServletResponse resp){
        Object attribute = req.getSession().getAttribute(Constant.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");
        Map<String,String> resultMap=new HashMap<String, String>();
        if(attribute==null){
            //session失效或者过期了
            resultMap.put("result","sessionerror");
        }else if(StringUtils.isNullOrEmpty(oldpassword)){
            resultMap.put("result","error");
        }else {
            String userPassword = ((User) attribute).getUserpassword();
            if(oldpassword.equals(userPassword)){
                resultMap.put("result","true");
            }else{
                resultMap.put("result","false");
            }
        }
        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //
    public void query(HttpServletRequest req, HttpServletResponse resp){
        //查询用户列表
        String queryUserName = req.getParameter("queryname");
        String temp = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole=0;
        int currentPageNo=1;
        List<User> userList=null;
        if(queryUserName==null){
            queryUserName="";
        }
        if(temp!=null&&!temp.equals("")){
            queryUserRole=Integer.parseInt(temp);//给查询赋值0，1，2，3
        }
        if(pageIndex!=null){
            currentPageNo=Integer.parseInt(pageIndex);
        }
        UserServiceImpl userService=new UserServiceImpl();
        int totalCount = userService.getUserCount(queryUserName, queryUserRole); //获取用户总数
        PageSupport pageSupport = new PageSupport();//总页数支持
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(Constant.PAGE_SIZE);
        pageSupport.setTotalCount(totalCount);

        int totalPageCount = pageSupport.getTotalPageCount();
        //控制首页和尾页
        if(currentPageNo<1){
            currentPageNo=1;
        }else if(currentPageNo>totalPageCount){
            currentPageNo=totalPageCount;
        }
         //用户列表展示
        userList= userService.getUserList(queryUserName, queryUserRole, currentPageNo, Constant.PAGE_SIZE);
        req.setAttribute("userList",userList);
        //获取角色列表
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleLis();
        req.setAttribute("roleList",roleList);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("currentPageNo",currentPageNo);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("queryUserName",queryUserName);
        req.setAttribute("queryUserRole",queryUserRole);
        //返回前端
        try {
            req.getRequestDispatcher("userlist.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
