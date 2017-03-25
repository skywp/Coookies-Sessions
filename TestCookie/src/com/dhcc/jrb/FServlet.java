package com.dhcc.jrb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FServlet extends HttpServlet {

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

		doPost(request,response);
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
		//1.获取用户名
		String name = request.getParameter("name");
		String remember = request.getParameter("remember");
		//新建Cookie
		Cookie cookie = new Cookie("remember",name);
		//判断checkbox-remember是否被勾选
		if (remember!=null && remember.equals("yes")) {
			//"yes" 勾选了==>设置有效时间为一周
			cookie.setMaxAge(60*60*24*7);
		} else {
			//null 没勾选==> 设置cookie的有效时间为0
			cookie.setMaxAge(0);
		}
		//3.将cookie添加到response
		response.addCookie(cookie);
		//4.跳转到成功页面
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}

}
