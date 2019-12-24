package com.cognizant.moviecruiser.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoCollectionImplTest {

	public static void main(String[] args) throws SystemException {
		
		testAddFavoriteItem();
		testGetAllFavoriteItems();
		testRemoveFavoriteItem();
		testGetAllFavoriteItems();
	}

	public static void testAddFavoriteItem() throws SystemException {
		
		FavoritesDao favoriteDao = new FavoriteDaoCollectionImpl();
		favoriteDao.addFavoriteItem(1, 1);
		favoriteDao.addFavoriteItem(1, 2);
		favoriteDao.addFavoriteItem(1, 3);
		favoriteDao.addFavoriteItem(1, 4);
	}

	public static void testGetAllFavoriteItems() throws SystemException {
		
		DecimalFormat df = new DecimalFormat("###,###,###");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		FavoritesDao favoriteDao = new FavoriteDaoCollectionImpl();
		List<Movie> movieList = null;
		try {
			movieList = favoriteDao.getAllFavoriteItems(1);
			for (int i = 0; i < movieList.size(); i++) {

				System.out.println("Id : " + movieList.get(i).getId());
				System.out.println("Title : " + movieList.get(i).getTitle());
				System.out.println("Box Office : " + df.format(movieList.get(i).getBoxOffice()));
				System.out.println("Active : " + movieList.get(i).isActive());
				System.out.println("Date Of Launch : " + sdf.format(movieList.get(i).getDateOfLaunch()));
				System.out.println("Genre : " + movieList.get(i).getGenre());
				System.out.println("Has Teaser : " + movieList.get(i).isHasTeaser());
				System.out.println();
			}
		} catch (FavoriteEmptyException favoriteEmptyException) {
			System.out.println(favoriteEmptyException.getMessage());
		}

	}

	public static void testRemoveFavoriteItem() throws SystemException {
		
		FavoritesDao favoriteDao = new FavoriteDaoCollectionImpl();
		favoriteDao.removeFavoriteItem(1, 2);
	}

}
