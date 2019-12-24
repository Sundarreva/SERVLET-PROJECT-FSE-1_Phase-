package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;


public class FavoriteDaoSqlImpl implements FavoritesDao {
	
	public List<Movie> getAllFavoriteItems(long userId) throws FavoriteEmptyException, SystemException {
		
		List<Movie> item = new ArrayList<Movie>();
		Favorite fav = new Favorite(item,0);
		Movie movie = null;
		
		String query ="SELECT\r\n" + 
				" `movie`.`mo_id`,\r\n" + 
				" `movie`.`mo_title`,\r\n" + 
				" `movie`.`mo_box_office`,\r\n" + 
				" `movie`.`mo_active`,\r\n" + 
				" `movie`.`mo_date_of_launch`,\r\n" + 
				" `movie`.`mo_Genre`,\r\n" + 
				" `movie`.`mo_has_teaser`\r\n" + 
				" FROM `movie_cruiser`.`favorite` JOIN `movie_cruiser`.`movie`" +
				" WHERE fa_pr_id = movie.mo_id" + " AND favorite.fa_us_id =" + userId+";";
		
		try (Connection connection = ConnectionHandler.getConnection()){
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				movie = new Movie(resultSet.getLong(1), resultSet.getString(2), resultSet.getLong(3), resultSet.getBoolean(4), resultSet.getDate(5),
						resultSet.getString(6), resultSet.getBoolean(7));
				item.add(movie);
			}

			if (item.isEmpty()) {
				throw new FavoriteEmptyException("Favorite is Empty");
			}
			fav.setMovieList(item);
		} catch (SQLException sqlException) {
			throw new SystemException(sqlException.getErrorCode(), sqlException.getLocalizedMessage());
		}
		
		return item;
	}
	
	public void addFavoriteItem(long userId,long movieId) throws SystemException {
		
		
		String select = "SELECT " +  
				" `favorite`.`fa_pr_id` " + 
				" FROM `movie_cruiser`.`favorite` " +  
				" WHERE fa_pr_id = "+movieId+ " AND fa_us_id = "+userId+";";
		
		String query = "INSERT INTO `movie_cruiser`.`favorite`" + 
				" (`fa_us_id`," + 
				" `fa_pr_id`)" + 
				" VALUES" + 
				" (" + userId + ","
				+ movieId + ");";
		
		try(Connection connection = ConnectionHandler.getConnection()){
			
			PreparedStatement statement;
			statement = connection.prepareStatement(select);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next() == false) {
				statement = connection.prepareStatement(query);
				int row = statement.executeUpdate();
			}

		} catch (SQLException sqlException) {
			throw new SystemException(sqlException.getErrorCode(), sqlException.getLocalizedMessage());
		}
	}
	
	public void removeFavoriteItem(long userId,long movieId) throws SystemException {
		
		String query = "DELETE FROM `movie_cruiser`.`favorite`" + 
				"WHERE `fa_us_id`=" + userId + " AND `fa_pr_id`=" + movieId
				+ " limit 1;";
		
		try(Connection connection = ConnectionHandler.getConnection()){

			PreparedStatement statement = connection.prepareStatement(query);
			int row = statement.executeUpdate();
			
		} catch (SQLException sqlException) {
			throw new SystemException(sqlException.getErrorCode(), sqlException.getLocalizedMessage());
		}
	}
}