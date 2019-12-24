package com.cognizant.moviecruiser.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoCollectionImpl implements MovieDao {

	private static List<Movie> movieList;

	public MovieDaoCollectionImpl() {
		if (movieList == null) {
			movieList = new ArrayList<Movie>();
			movieList.add(new Movie(1, "Avatar", 2787965087l, true, DateUtil.convertToDate("15/03/2017"),
					"Science Fiction", true));
			movieList.add(new Movie(2, "The Avengers", 1518812988l, true, DateUtil.convertToDate("23/12/2017"),
					"Superhero", false));
			movieList.add(
					new Movie(3, "Titanic", 2187463944l, true, DateUtil.convertToDate("21/08/2018"), "Romance", false));
			movieList.add(new Movie(4, "Jurassic World", 1671713208l, false, DateUtil.convertToDate("02/07/2017"),
					"Science Fiction", true));
			movieList.add(new Movie(5, "Avengers: End Game", 2750760348l, true, DateUtil.convertToDate("02/11/2022"),
					"Superhero", true));
		}
	}
		
	public static List<Movie> getMovieList() {
		return movieList;
	}

	public static void setMovieList(List<Movie> movieList) {
		MovieDaoCollectionImpl.movieList = movieList;
	}

	public List<Movie> getMovieListAdmin() {

		return movieList;
	}

	public List<Movie> getMovieListCustomer() {

		DateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY");
		ArrayList<Movie> movie = new ArrayList<Movie>();
		Date date = new Date();

		for (int i = 0; i < movieList.size(); i++) {
			if ((DateUtil.convertToDate(formatDate.format(date)).compareTo(movieList.get(i).getDateOfLaunch()) >= 0)
					&& movieList.get(i).isActive() == true) {
				movie.add(movieList.get(i));
			}
		}

		return movie;
	}

	public void modifyMovie(Movie movie) {

		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movie.getId()) {
				movieList.set(i, movie);
				break;
			}
		}

	}

	public Movie getMovie(long movieId) {
		boolean movieIdMatch = false;
		int i;

		for (i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieId) {
				movieIdMatch = true;
				break;
			}
		}
		if (movieIdMatch == true)
			return movieList.get(i);
		return null;
	}

}
