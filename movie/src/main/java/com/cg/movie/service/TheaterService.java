package com.cg.movie.service;

import com.cg.movie.bean.Movie;
import com.cg.movie.exception.MovieException;

public interface TheaterService
{
	public Movie searchMovie(String movieName) throws MovieException;


	
	
}
