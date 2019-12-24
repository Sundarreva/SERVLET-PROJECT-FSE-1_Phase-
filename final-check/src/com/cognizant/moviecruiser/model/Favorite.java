package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favorite {

	private long noOfItems;
	private List<Movie> movieList;
	
	public Favorite(List<Movie> movieList, long noOfItems){
		super();
		this.noOfItems = noOfItems;
		this.movieList = movieList;
	}

	public long getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(long noOfItems) {
		this.noOfItems = noOfItems;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	@Override
	public String toString() {
		return "Favorite [noOfItems=" + noOfItems + ", movieList=" + movieList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieList == null) ? 0 : movieList.hashCode());
		result = prime * result + (int) (noOfItems ^ (noOfItems >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorite other = (Favorite) obj;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		if (noOfItems != other.noOfItems)
			return false;
		return true;
	}	
	
}
