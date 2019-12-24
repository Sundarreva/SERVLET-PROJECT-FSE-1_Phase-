package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoSqlImplTest {

	public static void main(String[] args) throws SystemException {
		
		testAddFavoriteItem();
		testGetAllItems();
		testRemoveFavoriteItem();
		testGetAllItems();
	}
	
	public static void testAddFavoriteItem() throws SystemException {
		FavoriteDaoSqlImpl favSql = new FavoriteDaoSqlImpl();
		favSql.addFavoriteItem(1, 1);
		System.out.println("Item added to favorite successfully");		
	}
	
	public static void testGetAllItems() throws SystemException {
		
		FavoriteDaoSqlImpl favSql = new FavoriteDaoSqlImpl();
		try {
			List<Movie> favList = favSql.getAllFavoriteItems(1);
			for (Movie movie : favList) {
				System.out.printf("%3d %-20s %-12s %-12s %-15s %-5s %-5s\n", movie.getId(), movie.getTitle(), Long.toString(movie.getBoxOffice()),
						movie.getDateOfLaunch(), movie.getGenre(), movie.isActive(), movie.isHasTeaser());
			}
		} catch (FavoriteEmptyException exception) {
			exception.printStackTrace();
		}
	}
	
	public static void testRemoveFavoriteItem() throws SystemException {
		FavoriteDaoSqlImpl favSql = new FavoriteDaoSqlImpl();
		favSql.removeFavoriteItem(1, 1);	
	}

}
