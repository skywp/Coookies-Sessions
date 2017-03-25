<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测试购物车'list.jsp'page</title>
    
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
    <table border="1">
    	<tr>
    		<td><h3>商品1</h3><img src="<%=path %>/photo/good1.jpg" width="200" height="200"/><br/><a href="<%=basePath%>BServlet?name=0">加入购物车</a></td>
    		<td><h3>商品2</h3><img src="<%=path %>/photo/good2.jpg" width="200" height="200"/><br/><a href="<%=basePath%>BServlet?name=1">加入购物车</a></td>
    		<td><h3>商品3</h3><img src="<%=path %>/photo/good3.jpg" width="200" height="200"/><br/><a href="<%=basePath%>BServlet?name=2">加入购物车</a></td>
    	</tr>
    	<tr>
    		
    		<td><h3>商品4</h3><img src="<%=path %>/photo/good4.jpg" width="200" height="200"/><br/><a href="<%=basePath%>BServlet?name=3">加入购物车</a></td>
    		<td><h3>商品5</h3><img src="<%=path %>/photo/good5.jpg" width="200" height="200"/><br/><a href="<%=basePath%>BServlet?name=4">加入购物车</a></td>
    		<td><h3>商品6</h3><img src="<%=path %>/photo/good6.jpg" width="200" height="200"/><br/><a href="<%=basePath%>BServlet?name=5">加入购物车</a></td>
    	</tr>
    
    </table>
    	<a href="<%=path %>/cart/cart.jsp" >查看购物车</a>
  </body>
</html>
