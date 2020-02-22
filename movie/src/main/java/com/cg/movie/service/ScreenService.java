package com.cg.movie.service;

import java.util.List;

import com.cg.movie.bean.Show;
import com.cg.movie.exception.MovieException;

public interface ScreenService
{

	public Show searchShow(String showName) throws MovieException; 
	public List<Show> showShows() throws MovieException;
	
}
