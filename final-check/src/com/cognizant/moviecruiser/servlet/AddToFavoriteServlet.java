package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoriteDaoSqlImpl;
import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoSqlImpl;
import com.cognizant.moviecruiser.dao.SystemException;
import com.cognizant.moviecruiser.model.Movie;

@WebServlet("/AddToFavorite")
public class AddToFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long userId = 1;
		long movieId = Long.parseLong(request.getParameter("movieId"));
		FavoritesDao favoriteDao = new FavoriteDaoSqlImpl();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("movie-list-customer.jsp");
		
		try {
			favoriteDao.addFavoriteItem(userId, movieId);
			MovieDao movieDao = new MovieDaoSqlImpl();
			List<Movie> movieList = movieDao.getMovieListCustomer();
			request.setAttribute("addFavoriteStatus",true);
			request.setAttribute("movieList",movieList);
		} catch (SystemException systemException) {
			System.out.println(systemException.getMessage());
			request.setAttribute("errorMsg", "Error Occured: Disconnected from server!!!");
		}
		
		requestDispatcher.forward(request, response);
	}
}
