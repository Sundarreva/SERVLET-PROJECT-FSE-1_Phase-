package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/ShowEditMenuItem")
public class ShowEditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		long id = Long.parseLong(request.getParameter("menuItemId"));
		MenuItem menu;
		RequestDispatcher rd = request.getRequestDispatcher("edit-menu-item.jsp");
		try {
			menu = menuItemDao.getMenuItem(id);
			request.setAttribute("menu", menu);
		} catch (SystemException e) {
			System.out.println(e.getMessage());
			request.setAttribute("errormsg", "Error Occured:Disconnected from server ");
		}
		
		rd.forward(request, response);
	}
}
