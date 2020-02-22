package com.cg.movie.service;

import com.cg.movie.bean.Movie;
import com.cg.movie.bean.Screen;
import com.cg.movie.bean.Show;
import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public interface AdminService
{
	public Theater addTheater(Theater theater) throws MovieException; 
	public boolean deleteTheater(int theaterId) throws MovieException; 
	
	
	public Show addShow(int theaterId,Show show) throws MovieException;
	public boolean deleteShow(int theaterId,int showId) throws MovieException;
	public boolean validateShowId(int id) throws MovieException;
	public boolean validateName(String name) throws MovieException;
	public boolean validateContact(String number) throws MovieException;
	
	public boolean validateId(int id) throws MovieException;
	
	
	
}
