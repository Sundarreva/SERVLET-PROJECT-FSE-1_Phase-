package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoSqlImplTest {

	public static void main(String args[]) throws SystemException {
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovie();
		testGetMovie();
	}
	
	public static void testGetMovieListAdmin() throws SystemException {
		
		System.out.println("----------------ADMIN-------------------");
		MovieDaoSqlImpl movieSql = new MovieDaoSqlImpl();
		List<Movie> movieItem = movieSql.getMovieListAdmin();
		for (Movie movie : movieItem) {
			System.out.printf("%3d %-20s %-12s %-12s %-15s %-5s %-5s\n", movie.getId(), movie.getTitle(), Long.toString(movie.getBoxOffice()),
					movie.getDateOfLaunch(), movie.getGenre(), movie.isActive(), movie.isHasTeaser());
		}
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------");
		
		
	}
	
	public static void testGetMovieListCustomer() throws SystemException {
		
		System.out.println("----------------CUSTOMER-------------------");
		MovieDaoSqlImpl movieSql = new MovieDaoSqlImpl();
		List<Movie> movieItem = movieSql.getMovieListCustomer();
		for (Movie movie : movieItem) {
			System.out.printf("%3d %-20s %-12s %-12s %-15s %-5s %-5s\n", movie.getId(), movie.getTitle(), Long.toString(movie.getBoxOffice()),
					movie.getDateOfLaunch(), movie.getGenre(), movie.isActive(), movie.isHasTeaser());
		}
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------");

	}
	
	public static void testModifyMovie() throws SystemException{
		
		System.out.println("------------------------MODIFY----------------------");
		MovieDaoSqlImpl movieSql = new MovieDaoSqlImpl();
		Movie item = new Movie(1, "Tangle", 3214579878774l, true, DateUtil.convertToDate("20/12/2017"), "Comedy",
				true);
		movieSql.modifyMovie(item);
		List<Movie> movieItem = movieSql.getMovieListAdmin();
		for (Movie movie : movieItem) {
			System.out.printf("%3d %-20s %-12s %-12s %-15s %-5s %-5s\n", movie.getId(), movie.getTitle(), Long.toString(movie.getBoxOffice()),
					movie.getDateOfLaunch(), movie.getGenre(), movie.isActive(), movie.isHasTeaser());
		}
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------");
		
	}
	
	public static void testGetMovie() throws SystemException{
		
		System.out.println("----------------------GETMOVIEITEM--------------------------");
		MovieDaoSqlImpl movieSql = new MovieDaoSqlImpl();
		Movie movieItem = movieSql.getMovie(2);
		System.out.println(movieItem);
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------");
		
	}
}
