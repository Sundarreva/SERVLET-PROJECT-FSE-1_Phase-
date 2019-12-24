package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoriteDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.FavoriteDaoSqlImpl;
import com.cognizant.moviecruiser.dao.FavoriteEmptyException;
import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.dao.SystemException;
import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;

@WebServlet("/ShowFavorite")
public class ShowFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher;

		try {
			
			long userId = 1;
			FavoritesDao favoriteDao = new FavoriteDaoSqlImpl();
			List<Movie> favoriteItems = favoriteDao.getAllFavoriteItems(userId);
			long  noOfItems = favoriteItems.size();
			
			requestDispatcher = request.getRequestDispatcher("favorite.jsp");
			request.setAttribute("favoriteItems", favoriteItems);
			request.setAttribute("noOfItems", noOfItems);
			
		} catch (FavoriteEmptyException favoriteEmptyException) {
			requestDispatcher = request.getRequestDispatcher("favorite-empty.jsp");		
		} catch (SystemException systemException) {
			requestDispatcher = request.getRequestDispatcher("favorite.jsp");
			request.setAttribute("errorMsg", "Error Occured: Disconnected from server!!!");
		} 		
			requestDispatcher.forward(request, response);

	}
}
