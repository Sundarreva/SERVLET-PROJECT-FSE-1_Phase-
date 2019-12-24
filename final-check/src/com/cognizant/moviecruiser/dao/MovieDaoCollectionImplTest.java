package com.cognizant.moviecruiser.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoCollectionImplTest {

	public static void main(String args[]) throws SystemException {

		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovie();
		testGetMovie();
		testGetMovieListAdmin();
		testGetMovieListCustomer();

	}

	public static void testGetMovieListAdmin() throws SystemException {
		
		DecimalFormat df = new DecimalFormat("###,###,###");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListAdmin();
		System.out.println("=======================================================");
		System.out.println("\n\n     Admin List");
		System.out.println("     ==========");
		
		for (int i = 0; i < movieList.size(); i++) {
			System.out.println();
			System.out.println("Id : " + movieList.get(i).getId());
			System.out.println("Title : " + movieList.get(i).getTitle());
			System.out.println("BoxOffice : $" + df.format((movieList.get(i).getBoxOffice())));
			System.out.println("Active : " + movieList.get(i).isActive());
			System.out.println("Date of Launch : " + sdf.format(movieList.get(i).getDateOfLaunch()));
			System.out.println("Genre : " + movieList.get(i).getGenre());
			System.out.println("Has Teaser : " + movieList.get(i).isHasTeaser());
			System.out.println("=====================================================");
		}

	}

	public static void testGetMovieListCustomer() throws SystemException {
		
		DecimalFormat df = new DecimalFormat("###,###,###");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListCustomer();
		System.out.println("=======================================================");
		System.out.println("\n\n     Customer List");
		System.out.println("     =============");
		
		for (int i = 0; i < movieList.size(); i++) {
			System.out.println();
			System.out.println("Id : " + movieList.get(i).getId());
			System.out.println("Title : " + movieList.get(i).getTitle());
			System.out.println("BoxOffice : $" +df.format(movieList.get(i).getBoxOffice()));
			System.out.println("Active : " + movieList.get(i).isActive());
			System.out.println("Date of Launch : " + sdf.format(movieList.get(i).getDateOfLaunch()));
			System.out.println("Genre : " + movieList.get(i).getGenre());
			System.out.println("Has Teaser : " + movieList.get(i).isHasTeaser());
			System.out.println("=====================================================");
		}
	}

	public static void testModifyMovie() throws SystemException {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		movieDao.modifyMovie(
				new Movie(1, "Kunfu Panda", 2345888888l, true, DateUtil.convertToDate("23/12/2017"), "Animation", true));
	}

	public static void testGetMovie() throws SystemException {
		
		DecimalFormat df = new DecimalFormat("###,###,###");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListAdmin();
		
		for (int i = 0; i < movieList.size(); i++) {
			System.out.println();
			System.out.println("Id : " + movieList.get(i).getId());
			System.out.println("Title : " + movieList.get(i).getTitle());
			System.out.println("BoxOffice : $" + df.format(movieList.get(i).getBoxOffice()));
			System.out.println("Active : " + movieList.get(i).isActive());
			System.out.println("Date of Launch : " + sdf.format(movieList.get(i).getDateOfLaunch()));
			System.out.println("Genre : " + movieList.get(i).getGenre());
			System.out.println("Has Teaser : " + movieList.get(i).isHasTeaser());
			System.out.println("=====================================================");
		}
	}
}
