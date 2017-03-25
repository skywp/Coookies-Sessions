<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测试cookie记住用户名</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
    //1.获得浏览器发送过来的cookie
    Cookie[] cookies = request.getCookies();
    //2.遍历找到保存用户名的remember
    Cookie remember = null;
    if (cookies!=null && cookies.length>0) {
    	for (Cookie c:cookies){
    		if (c.getName().equals("remember")) {
    			remember = c;
    		}
    	}
    }
    
   %>
  
  <body>
    	测试cookie记住用户名 <br>
    	<form action="/TestCookie/FServlet" method="post">
    		用户名:&nbsp;<input type="text" name="name" value="<%=remember==null?"":remember.getValue()%>"/><br/>
    		密&nbsp;&nbsp;码:&nbsp;&nbsp;<input type="password" name="password"/><br/>
    		记住用户名(一周):<input type="checkbox" name="remember" value="yes" <%=remember==null?"":"checked"%>><br/>
    		<input type="submit" value="登录" ><br/>
    	</form>
    	<img src="gif/cookie_login.gif"></img>
  </body>
</html>
