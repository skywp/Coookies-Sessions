package com.dhcc.jrb;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2813645398961344141L;

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
		//1.获得要添加的商品
		String name = request.getParameter("name");
		int intName = Integer.parseInt(name);
		//2.将数字翻译成中文商品名称(使用数组)
		String[] products = new String[]{"商品1","商品2","商品3",
				"商品4","商品5","商品6"};
		String productName = products[intName];
		//3.获得Session(由服务器负责处理) ->getSession()
		HttpSession session = request.getSession();
		//4.获得session中保存的购物车(Map)
		Map<String,Integer> map = (Map<String, Integer>) session.getAttribute("cart");			
		if (map!=null) {
			//获得到了-->不是第一次访问->继续向Map中添加
			Integer count = map.get(productName);
			if (count == null) {
				//不存在，则添加并设置数量为1
				count = 1;
			} else {
				//map中已经存在的这个商品，把数量加1
				count++;
			}
			map.put(productName, count);
		} else {
			//没有获得-->第一次访问，
			map = new HashMap<String,Integer>();
			//新建Map==>将商品添加并设置数量为1
			map.put(productName, 1);
		}	
		//5.将Map操作完再放回session
		session.setAttribute("cart", map);
		//6.返回到列表页面--重定向
		response.sendRedirect(request.getContextPath()+"/cart/list.jsp");
	}

}
