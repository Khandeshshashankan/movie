package com.cg.movie.dao;

import com.cg.movie.bean.Show;
import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public interface AdminDao {

	public Theater addTheater(Theater theater) throws MovieException;

	public boolean deleteTheater(int theaterId) throws MovieException;

	public Show addShow(int theaterId, Show show) throws MovieException;

	public boolean deleteShow(int theaterId, int showId) throws MovieException;
}
