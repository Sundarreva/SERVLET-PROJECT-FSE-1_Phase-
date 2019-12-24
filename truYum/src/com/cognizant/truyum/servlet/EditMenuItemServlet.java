package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.dao.SystemException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@WebServlet("/EditMenuItem")
public class EditMenuItemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("title");
		float price = Float.parseFloat(request.getParameter("price"));
		boolean active = Boolean.parseBoolean(request.getParameter("inStock"));
		String date = request.getParameter("dateOfLaunch");
		Date dateOfLaunch = DateUtil.convertToDate(date);
		String category = request.getParameter("category");
		String Delivery = request.getParameter("freeDelivery");
		boolean freeDelivery = false;

		if (Delivery != null) {
			freeDelivery = true;
		}

		MenuItem menuItem = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		RequestDispatcher rd = null;

		try {
			menuItemDao.modifyMenuItem(menuItem);
			rd = request.getRequestDispatcher("edit-menu-item-status.jsp");
		} catch (SystemException e) {
			System.out.println(e.getMessage());
			rd = request.getRequestDispatcher("edit-menu-item-status.jsp");
			request.setAttribute("errormsg", "Error Occured: Disconnected from server!!!");
		}

		rd.forward(request, response);
	}
}
