package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class MovieDaoSqlImpl implements MovieDao{

	public List<Movie> getMovieListAdmin() throws SystemException {
		
		List<Movie> movieItem = new ArrayList<Movie>();
		String query = "SELECT " + 
				" `movie`.`mo_id`," + 
				" `movie`.`mo_title`," + 
				" `movie`.`mo_box_office`," + 
				" `movie`.`mo_active`," + 
				" `movie`.`mo_date_of_launch`," + 
				" `movie`.`mo_Genre`," + 
				" `movie`.`mo_has_teaser`" + 
				" FROM `movie_cruiser`.`movie`;";

		try(Connection connection = ConnectionHandler.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Movie movie = new Movie(resultSet.getLong(1), resultSet.getString(2), resultSet.getLong(3), resultSet.getBoolean(4),
						resultSet.getDate(5), resultSet.getString(6), resultSet.getBoolean(7));
				movieItem.add(movie);
			}
		} catch (SQLException sqlException) {
			throw new SystemException(sqlException.getErrorCode(), sqlException.getLocalizedMessage());
		}

		return movieItem;
	}

	public List<Movie> getMovieListCustomer() throws SystemException {
		
		List<Movie> movieItem = new ArrayList<Movie>();
		
		String query = "SELECT " + 
				" `movie`.`mo_id`," + 
				" `movie`.`mo_title`," + 
				" `movie`.`mo_box_office`," + 
				" `movie`.`mo_active`," + 
				" `movie`.`mo_date_of_launch`," + 
				" `movie`.`mo_Genre`," + 
				" `movie`.`mo_has_teaser`" + 
				" FROM `movie_cruiser`.`movie`" + 
				" where mo_active ='Yes' AND mo_date_of_launch <= CURDATE();";

		try(Connection connection = ConnectionHandler.getConnection()) {
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Movie movie = new Movie(resultSet.getLong(1), resultSet.getString(2), resultSet.getLong(3), resultSet.getBoolean(4),
						resultSet.getDate(5), resultSet.getString(6), resultSet.getBoolean(7));
				movieItem.add(movie);
			}
		} catch (SQLException sqlException) {
			throw new SystemException(sqlException.getErrorCode(), sqlException.getLocalizedMessage());
		}

		return movieItem;
	}

	public Movie getMovie(long movieId) throws SystemException {
		
		Movie movie = null;
		
		String query = "SELECT " + 
				" `movie`.`mo_id`," + 
				" `movie`.`mo_title`," + 
				" `movie`.`mo_box_office`," + 
				" `movie`.`mo_active`," + 
				" `movie`.`mo_date_of_launch`," + 
				" `movie`.`mo_Genre`," + 
				" `movie`.`mo_has_teaser`" + 
				" FROM `movie_cruiser`.`movie`" + 
				" where mo_id =" + movieId + ";";
		
		PreparedStatement statement;

		try(Connection connection = ConnectionHandler.getConnection()) {
			
			statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				movie = new Movie(resultSet.getLong(1), resultSet.getString(2), resultSet.getLong(3), resultSet.getBoolean(4), resultSet.getDate(5),
						resultSet.getString(6), resultSet.getBoolean(7));
			}

		} catch (SQLException sqlException) {
			throw new SystemException(sqlException.getErrorCode(), sqlException.getLocalizedMessage());
		}

		return movie;
	}

	public void modifyMovie(Movie movie) throws SystemException {
		
		String query = "UPDATE `movie_cruiser`.`movie`" + 
				" SET " + 
				" `mo_id` =" +movie.getId()+" , "+
				" `mo_title` ='" +movie.getTitle()+ "' , " + 
				" `mo_box_office` =" +movie.getBoxOffice()+" , "+ 
				" `mo_active` =" +(movie.isActive() == true ? "'" + "Yes" + "'" : "'" + "No'") +" , "+ 
				" `mo_date_of_launch` = '" + new java.sql.Date(movie.getDateOfLaunch().getTime())+ "', " + 
				" `mo_Genre` ='" +movie.getGenre()+"'"+ " , " +
				" `mo_has_teaser` = " +(movie.isHasTeaser() == true ? "'" + "Yes" + "'" : "'" + "No'")+ 
				" WHERE `mo_id`=" +movie.getId()+";";
				
		try(Connection connection = ConnectionHandler.getConnection()) {
			
			PreparedStatement statement = connection.prepareStatement(query);
			int row = statement.executeUpdate();
			
		} catch (SQLException sqlException) {
			throw new SystemException(sqlException.getErrorCode(), sqlException.getLocalizedMessage());
		}

	}

}
