package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.dao.FavoriteEmptyException;

public class FavoriteDaoCollectionImpl implements FavoritesDao {

	private static Map<Long, Favorite> userFavorites = null;

	public FavoriteDaoCollectionImpl() {

		if (userFavorites == null) {
			userFavorites = new HashMap<Long, Favorite>();
		}
	}
	
	public static Map<Long, Favorite> getUserFavorites() {
		return userFavorites;
	}

	public static void setUserFavorites(Map<Long, Favorite> userFavorites) {
		FavoriteDaoCollectionImpl.userFavorites = userFavorites;
	}

	public void addFavoriteItem(long userId, long movieId) throws SystemException {

		MovieDao movieDao = new MovieDaoCollectionImpl();
		Movie movie = movieDao.getMovie(movieId);

		if (!userFavorites.containsKey(userId)) {
			userFavorites.put(userId, new Favorite(new ArrayList<Movie>(), 0));
		}
		userFavorites.get(userId).getMovieList().add(movie);
	}

	public List<Movie> getAllFavoriteItems(long userId) throws FavoriteEmptyException {

		List<Movie> list = null;
		if (userFavorites.containsKey(userId)) {
			Favorite favoriteobj = userFavorites.get(userId);
			list = favoriteobj.getMovieList();
			if (list.isEmpty()) {
				throw new FavoriteEmptyException("Cart Empty.");
			} else {
				long noOfItems = list.size();
				userFavorites.get(userId).setNoOfItems(noOfItems);;
			}
		}
		else {
			throw new FavoriteEmptyException("Favorite is Empty.");
		}
		return list;
	}

	public void removeFavoriteItem(long userId, long movieId) {

		if (userFavorites.containsKey(userId)) {
			Favorite favoriteDao = userFavorites.get(userId);
			List<Movie> MovieList = favoriteDao.getMovieList();

			for (int i = 0; i < MovieList.size(); i++) {
				if (movieId == MovieList.get(i).getId()) {
					MovieList.remove(i);
					break;
				}
			}
		}

	}

}
