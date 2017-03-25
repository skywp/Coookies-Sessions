package com.dhcc.jrb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DServlet extends HttpServlet {

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
		//1.获得表单提交的验证码
		String codeForm = request.getParameter("code");
		//2.获得session中的正确验证码
		String codeSession = (String) request.getSession().getAttribute("code");
		//3.对比是否一致-->注意此时可能会因为超时导致Seesion中的code为空
		if (codeForm!=null && codeSession !=null && codeForm.equals(codeSession)) {
			//正确-->>成功页面
			response.sendRedirect(request.getContextPath()+"/checkcode/result.jsp");
			
		} else {
			//不正确-->>回到表单页面，提示错误
			request.setAttribute("error", "验证码错误");
			request.getRequestDispatcher("/checkcode/login.jsp").forward(request, response);
		}
			
			
	}

}
