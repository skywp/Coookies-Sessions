<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>TestSession page</title>
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
  	<p>
  		功能列表：<br/>
  		<a href="shoppingcart.jsp">购物车功能图解</a>
  		<a href="check_code_details.jsp">验证码功能图解</a>
  	</p>
    <p>
    	Session原理：<br/>
    	浏览器第一次访问服务器，服务器会在内存中开辟一个空间，并把Session对应的ID发送给浏览器；当该浏览器再次访问服务器时，就会把sessionID交给服务器，服务器就可以判断会话状态了。
    </p>
    <p>
    	<img src="gif/session1.gif"/>
    </p>
  </body>
</html>
