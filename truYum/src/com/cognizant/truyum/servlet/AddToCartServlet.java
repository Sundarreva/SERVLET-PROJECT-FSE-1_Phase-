package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.dao.SystemException;
import com.cognizant.truyum.model.MenuItem;

@WebServlet("/AddToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long userId = 1;
		long menuItemId = Long.parseLong(request.getParameter("menuItemId"));
		CartDao cartDao = new CartDaoSqlImpl();
		RequestDispatcher rd;
		List<MenuItem> menuItemList = null;

		try {
			cartDao.addCartItem(userId, menuItemId);
			MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
			menuItemList = menuItemDao.getMenuItemListCustomer();
			rd = request.getRequestDispatcher("menu-item-list-customer.jsp");
			request.setAttribute("addCartStatus", true);
			request.setAttribute("menuItemList", menuItemList);
		} catch (SystemException e) {
			System.out.println(e.getMessage());
			rd = request.getRequestDispatcher("menu-item-list-customer.jsp");
			request.setAttribute("errormsg", "Error Occured: Disconnected from server!!!");
		}

		rd.forward(request, response);
	}
}
