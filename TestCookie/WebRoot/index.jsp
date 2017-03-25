<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DHC-jrb-TestCookie</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    DHC-jrb-TestCookie Applications. <br>
    <p>
    	功能列表:<br/>
    	<a href="<%=basePath%>AServlet">测试当前功能</a>&nbsp;
    	<a href="list.jsp">测试浏览历史记录</a>&nbsp;
    	<a href="<%=basePath%>DServlet">测试Cookie过期时间</a>&nbsp;
    	<a href="<%=basePath%>EServlet">测试Cookie路径</a>&nbsp;
    	<a href="login.jsp">测试记住用户名</a>&nbsp;
    </p>
    <p>
    	功能说明:<br/>
    	（1）当浏览器发送一个请求到AServlet时，服务器会设置一个name为dhcc的cookie到浏览器中。<br/>
    	（2）当浏览器请求BServlet时，会将AServlet设置的cookie一块发送到服务器中，此时在BServlet中获取该Cookie。<br/>
    </p>
    
    <p>
    	<img src="gif/cookie.gif">
    </p>
  </body>
</html>
