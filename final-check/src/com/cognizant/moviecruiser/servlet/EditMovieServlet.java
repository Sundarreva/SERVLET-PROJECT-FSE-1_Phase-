package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.Date;

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
import com.cognizant.moviecruiser.util.DateUtil;



@WebServlet("/EditMovie")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("MovieId"));
		String title = request.getParameter("title");
		long boxOffice = Long.parseLong(request.getParameter("boxOffice").replaceAll(",", ""));
		boolean active = Boolean.parseBoolean(request.getParameter("inStock"));
		String date = request.getParameter("dateOfLaunch");
		Date dateOfLaunch = DateUtil.convertToDate(date);
		String genre = request.getParameter("genre");
		String teaser = request.getParameter("hasTeaser");
		boolean hasTeaser = false;
		
		if(teaser != null) {
			hasTeaser = true;
		}
		
		Movie movie = new Movie(id,title,boxOffice,active,dateOfLaunch,genre,hasTeaser);
		MovieDao movieDao = new MovieDaoSqlImpl();
		RequestDispatcher requestDispatcher = null;
		
		try {
			movieDao.modifyMovie(movie);
			requestDispatcher = request.getRequestDispatcher("edit-movie-status.jsp");
		} catch (SystemException systemException) {
			System.out.println(systemException.getMessage());
			requestDispatcher = request.getRequestDispatcher("edit-movie-status.jsp");
			request.setAttribute("errorMsg", "Error Occured: Disconnected from server!!!");
		}
	
		requestDispatcher.forward(request, response);
	}
}
