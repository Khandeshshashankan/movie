package com.cg.movie.service;

import com.cg.movie.bean.Show;
import com.cg.movie.bean.Theater;
import com.cg.movie.dao.AdminDao;
import com.cg.movie.dao.AdminDaoImpl;
import com.cg.movie.exception.MovieException;

public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao;

	public AdminServiceImpl() {
		adminDao = new AdminDaoImpl();
	}

	@Override
	public Theater addTheater(Theater theater) throws MovieException {

		int id = theater.getTheaterId();
		boolean flag = validateId(id);

		if (flag == false) {

			throw new MovieException("Theater Id must be 4 digit starting with 2");
		}
		String name = theater.getTheaterName();
		boolean flag1 = validateName(name);

		if (flag1 == true) {
			throw new MovieException("Theater Name must not be Null ");
		}

		String mname = theater.getManagerName();
		boolean flag2 = validateName(mname);

		if (flag2 == true) {
			throw new MovieException("Manager Name must not be Null ");
		}
		String mcontact = theater.getManagerContact();
		boolean flag3 = validateContact(mcontact);

		if (flag3 == false) {
			throw new MovieException("Manager Contact Number must be 10 digits");
		}
		Theater th = adminDao.addTheater(theater);

		return th;
	}

	@Override
	public boolean deleteTheater(int theaterId) throws MovieException {

		boolean flag = validateId(theaterId);

		if (flag == false) {
			throw new MovieException("Theater Id must be 4 digits starting with 2");
		}
		boolean flag1 = adminDao.deleteTheater(theaterId);
		return flag1;
	}

	@Override
	public Show addShow(int theaterId, Show show) throws MovieException {
		int id = show.getShowId();

		boolean flag = validateShowId(id);
		if (flag == false) {
			throw new MovieException("Show Id must be 4 digits");
		}
		String name = show.getShowName();
		boolean flag1 = validateName(name);

		if (flag1 == true) {
			throw new MovieException("Show Name must not be Null");
		}
		Show sh = adminDao.addShow(theaterId, show);
		int id1 = show.getScreenId();

		boolean flag4 = validateScreenId(id1);
		if (flag4 == false) {
			throw new MovieException("Screen Id must be 4 digits");
		}
		return sh;
	}

	@Override
	public boolean deleteShow(int theaterId, int showId) throws MovieException {
		boolean flag = validateShowId(showId);

		if (!flag) {
			throw new MovieException("Show Id must be 4 digits");
		}
		boolean flag1 = adminDao.deleteShow(theaterId, showId);

		return flag1;
	}

	@Override
	public boolean validateShowId(int id) throws MovieException {

		boolean flag = false;
		if (id == 0) {
			flag = false;
		} else {
			String s = Integer.toString(id);
			flag = s.matches("[0-9]{4}");
		}
		return flag;
	}
	@Override
	public boolean validateScreenId(int id) throws MovieException {

		boolean flag = false;
		if (id == 0) {
			flag = false;
		} else {
			String s = Integer.toString(id);
			flag = s.matches("[0-9]{4}");
		}
		return flag;
	}

	@Override
	public boolean validateContact(String number) throws MovieException {
		boolean flag = false;

		flag = number.matches("[0-9]{10}");
		return flag;
	}

	@Override
	public boolean validateId(int id) throws MovieException {
		boolean flag = false;

		if (id == 0) {
			flag = false;
		} else {
			String s = Integer.toString(id);
			flag = s.matches("(2)[0-9]{3}");

		}

		return flag;

	}

	@Override
	public boolean validateName(String name) throws MovieException {
		boolean flag = false;
		flag = name.isEmpty();

		if (flag) {
			flag = true;
		}
		return flag;
	}
}