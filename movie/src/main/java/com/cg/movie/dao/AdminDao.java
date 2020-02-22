package com.cg.movie.dao;

import com.cg.movie.bean.Movie;
import com.cg.movie.bean.Screen;
import com.cg.movie.bean.Show;
import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public interface AdminDao 
{
	
	public Theater addTheater(Theater theater) throws MovieException; 
	public boolean deleteTheater(int theaterId) throws MovieException; 
	public Movie addMovie(Movie movie) throws MovieException; 
	public boolean deleteMovie(int movieId) throws MovieException; 
	public Screen addScreen(Screen screen) throws MovieException; 
	public boolean deleteScreen(int screenId) throws MovieException;
	public Show addShow(int theaterId,Show show) throws MovieException;
	public boolean deleteShow(int theaterId,int showId) throws MovieException;	
}

