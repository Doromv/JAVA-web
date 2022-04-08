<%@ page import="org.apache.coyote.http11.Http11InputBuffer" %><%--
  Created by IntelliJ IDEA.
  User: DoromvQAQ
  Date: 2022/1/17
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--
总结：
<%=变量%>
<%片段%>
<%!全局变量或者方法……%>
--%>
<%--jsp表达式
作用：用来将程序的输出，输出到客户端
 <%=变量或者表达式%>
--%>
  <%= new java.util.Date()%>
  <hr>
<%--jsp脚本片段--%>
 <%
         int sum=0;
         for(int i=0;i<=100;i++){
         sum+=i;
         }
         out.print("<h1>sum="+sum+"<h1>");
 %>
<%
int x=10;
out.print(x);
%>
  <p>这是一个jsp文档</p>
<%
  int y=20;
  out.print(x+y);
%>
<%--在代码中嵌入HTML元素--%>
<%
  for (int i = 0; i < 5; i++) {
%>
<h1>hello,world</h1>
<%
  }
%>
<hr>
<%--jsp声明
<%!  %>
--%>

<%!
static {
  System.out.println("loading servlet!");
}
private int globalvar=0;
public  void  doromv(){
  System.out.println("doromv方法运行成功");
}
%>
  </body>
</html>
