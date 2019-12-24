package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public interface MovieDao {
	public List<Movie> getMovieListAdmin() throws SystemException;

	public List<Movie> getMovieListCustomer() throws SystemException;

	public void modifyMovie(Movie movie) throws SystemException;

	public Movie getMovie(long movieId) throws SystemException;
	
}
