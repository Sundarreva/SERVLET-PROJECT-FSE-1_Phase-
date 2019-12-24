package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.MovieDaoSqlImpl;
import com.cognizant.moviecruiser.dao.SystemException;
import com.cognizant.moviecruiser.model.Movie;

@WebServlet("/ShowMovieListAdmin")
public class ShowMovieListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDao movieDao = new MovieDaoSqlImpl();
		List<Movie> movieList;
		RequestDispatcher requestDispatcher = null;
		try {
			movieList = movieDao.getMovieListAdmin();
			requestDispatcher = request.getRequestDispatcher("movie-list-admin.jsp");
			request.setAttribute("movieList", movieList);
		} catch (SystemException systemException) {
			System.out.println(systemException.getMessage());
			requestDispatcher = request.getRequestDispatcher("movie-list-admin.jsp");
			request.setAttribute("errorMsg", "Error Occured: Disconnected from server!!!");
		}
		
		requestDispatcher.forward(request, response);
	}
}
