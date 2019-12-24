package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public interface FavoritesDao {
	public void addFavoriteItem(long userId, long movieId) throws SystemException;

	public List<Movie> getAllFavoriteItems(long userId) throws SystemException, FavoriteEmptyException;

	public void removeFavoriteItem(long userId, long movieId) throws SystemException;
}
