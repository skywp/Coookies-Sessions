package com.dhcc.jrb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1 获得当前访问的品牌
		String current = request.getParameter("name");
		//2 获得之前访问过的品牌(获得cookie)
		Cookie history = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null && cookies.length>0){
			for(Cookie c: cookies){
				if(c.getName().equals("history")){
					history = c;
				}
			}
		}
		//3 将当前访问 加上 之前访问的,创建一个新的cookie.
		// "history" = "dell,apple,hasee"
		String value = "";
		if(history!=null){
			
			value = history.getValue();
			if(!history.getValue().contains(current)){ //判断当前访问的是否 之前已经访问过
				value +=","+current;
			}
		}else{//没有获得到之前的cookie,说明是第一次访问.
			value = current;
		}
		Cookie newHistory = new Cookie("history",value);
		
		//4 将cookie添加到响应中
		response.addCookie(newHistory);
		//5 将商品记录 放置到request域中
		request.setAttribute("history",value);
		//6 转发到jsp显示
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
