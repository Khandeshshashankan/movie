package com.cg.movie.dao;

import com.cg.movie.bean.Movie;
import com.cg.movie.exception.MovieException;

public interface TheaterDao
{
	public Movie searchMovie(String movieName) throws MovieException;


}
