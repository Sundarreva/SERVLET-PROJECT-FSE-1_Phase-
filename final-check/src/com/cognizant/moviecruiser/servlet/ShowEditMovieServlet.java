package com.cognizant.moviecruiser.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoSqlImpl;
import com.cognizant.moviecruiser.dao.SystemException;
import com.cognizant.moviecruiser.model.Movie;

@WebServlet("/ShowEditMovie")
public class ShowEditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieDao movieDao = new MovieDaoSqlImpl();
		Long id =Long.parseLong(request.getParameter("MovieId"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit-movie.jsp");
		Movie movie;
		try {
			movie = movieDao.getMovie(id);
			request.setAttribute("movie",movie);
		} catch (SystemException systemException) {
			System.out.println(systemException.getMessage());
			request.setAttribute("errorMsg", "Error Occured: Disconnected from server!!!");
		}
		
		requestDispatcher.forward(request, response);
	}

}
