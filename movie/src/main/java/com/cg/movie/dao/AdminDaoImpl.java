package com.cg.movie.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cg.movie.bean.Screen;
import com.cg.movie.bean.Show;
import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public class AdminDaoImpl implements AdminDao {
	private Map<Integer, Theater> map;
	private List<Show> listOfShow;
	private Screen screen = null;
	private Theater th = null;

	public AdminDaoImpl() {
		map = new HashMap<Integer, Theater>();
		listOfShow = new ArrayList<Show>();
		screen = new Screen();

	}

	@Override
	public Theater addTheater(Theater theater) throws MovieException {

		boolean flag = map.containsKey(theater.getTheaterId());
		if (flag) {
			throw new MovieException("Id already exists");

		}
		th = theater;
		map.put(theater.getTheaterId(), th);

		return theater;
	}

	@Override
	public boolean deleteTheater(int theaterId) throws MovieException {
		boolean flag = map.containsKey(theaterId);
		if (flag) {
			map.remove(theaterId);
			return true;
		} else {
			throw new MovieException(theaterId + "Id is not found");
		}

	}

	@Override
	public Show addShow(int theaterId, Show show) throws MovieException {

		// Screen screen = new Screen();

		List<Integer> list = listOfShow.stream().map(p -> p.getShowId()).collect(Collectors.toList());

		boolean flag = list.contains(show.getShowId());
		if (flag) {
			throw new MovieException("Show already exists");

		}

		listOfShow.add(show);
		screen.setShowList(listOfShow);
		return show;
	}

	@Override
	public boolean deleteShow(int theaterId, int showId) throws MovieException {
		boolean flag = false;
		// Screen screen= new Screen();
		List<Integer> list1 = listOfShow.stream().map(p -> p.getShowId()).collect(Collectors.toList());

		flag = list1.contains(showId);
		if (flag)

		{
			for (Show sh : listOfShow) {
				if (sh.getShowId() == showId) {
					listOfShow.remove(sh);
					flag = true;
					break;
				}
			}
			// List<Show> list2 = listOfShow.stream().filter(p-> p.getShowId() !=
			// showId).collect(Collectors.toList());
			// screen.setShowList(list2);

		}

		else {

			throw new MovieException("ShowId Does Not Exist");

		}
		return flag;

	}

}
