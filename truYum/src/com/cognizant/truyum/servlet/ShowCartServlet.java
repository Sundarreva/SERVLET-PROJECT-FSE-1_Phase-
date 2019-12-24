package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.dao.SystemException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@WebServlet("/ShowCart")
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = null;
		try {

			long userId = 1;
			CartDao cartDao = new CartDaoSqlImpl();
			List<MenuItem> cartItems;
			cartItems = cartDao.getAllCartItems(userId);
			double total = 0;

			for (MenuItem item : cartItems) {
				total += item.getPrice();
			}
			
			rd = request.getRequestDispatcher("cart.jsp");
			request.setAttribute("cartItems", cartItems);
			request.setAttribute("total", total);

		} catch (CartEmptyException e) {
			rd = request.getRequestDispatcher("cart-empty.jsp");

		} catch (SystemException e) {
			System.out.println(e.getMessage());
			rd = request.getRequestDispatcher("cart-empty.jsp");
			request.setAttribute("errormsg", "Error Occured:Disconnected from server ");
		}

		rd.forward(request, response);
	}

}
