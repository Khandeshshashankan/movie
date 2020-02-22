package com.cg.movie.dao;

import java.util.List;

import com.cg.movie.bean.Movie;
import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public class TheaterDaoImpl implements TheaterDao {

	@Override
	public Movie searchMovie(String movieName) throws MovieException {
		Theater theater = new Theater();
		List<Movie> list=theater.getMoviesList();
		return null;
	}

	

}
