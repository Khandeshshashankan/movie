package com.cg.movie.dao;

import java.util.List;

import com.cg.movie.bean.Show;
import com.cg.movie.exception.MovieException;

public interface ScreenDao {
	
	public Show searchShow(String showName) throws MovieException; 
	public List<Show> showShows() throws MovieException;

}
