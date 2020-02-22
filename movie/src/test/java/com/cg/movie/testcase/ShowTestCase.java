package com.cg.movie.testcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import com.cg.movie.bean.Show;
import com.cg.movie.bean.Theater;
import com.cg.movie.dao.AdminDao;
import com.cg.movie.dao.AdminDaoImpl;
import com.cg.movie.exception.MovieException;

class ShowTestCase {

	AdminDao adminDao;
	Theater theater;
	Show show;

	@BeforeEach
	public void setup() {
		adminDao = new AdminDaoImpl();
	}

	@Test
	public void testAddTheater() throws Exception {
		theater = new Theater(2134, "shashi", "Adilabad", null, null, "rahul", "9999999999");

		Theater th = adminDao.addTheater(theater);

		assertEquals(2134, th.getTheaterId());

	}

	@Test
	public void testAddTheaterException() throws Exception {
		theater = new Theater(2134, "shashi", "adilabad", null, null, "rahul", "9999999999");

		adminDao.addTheater(theater);

		assertThrows(MovieException.class, () -> adminDao.addTheater(theater));

	}

	@Test
	public void testDeleteTheater() throws Exception {
		theater = new Theater(2134, "shashi", "adilabad", null, null, "rahul", "9999999999");
		adminDao.addTheater(theater);
		boolean flag = adminDao.deleteTheater(2134);

		assertTrue(flag);
	}

	@Test
	public void testDeleteTheaterException() throws Exception {
		theater = new Theater(2134, "shashi", "adilabad", null, null, "rahul", "9999999999");
		adminDao.addTheater(theater);
		assertThrows(MovieException.class, () -> adminDao.deleteTheater(2234));
	}

	@Test
	public void testAddShow() throws Exception {
		theater = new Theater(2134, "shashi", "adilabad", null, null, "rahul", "9999999999");
		Theater th = adminDao.addTheater(theater);
		show = new Show(1234, null, null, "firstshow", null, 2132, 2133);
		Show sh = adminDao.addShow(th.getTheaterId(), show);
		assertEquals(1234, sh.getShowId());

	}

	@Test
	public void testAddShowException() throws Exception {
		theater = new Theater(2134, "shashi", "adilabad", null, null, "rahul", "9999999999");
		Theater th = adminDao.addTheater(theater);
		show = new Show(1234, null, null, "firstshow", null, 2132, 2133);
		adminDao.addShow(th.getTheaterId(), show);
		assertThrows(MovieException.class, () -> adminDao.addShow(th.getTheaterId(), show));

	}

	@Test
	public void testDeleteShow() throws Exception {
		theater = new Theater(2134, "shashi", "adilabad", null, null, "rahul", "9999999999");
		Theater th = adminDao.addTheater(theater);
		show = new Show(1234, null, null, "firstshow", null, 2132, 2133);
		adminDao.addShow(th.getTheaterId(), show);
		boolean flag = adminDao.deleteShow(th.getTheaterId(), 1234);

		assertTrue(flag);
	}

	@Test
	public void testDeleteScreenException() throws Exception {
		theater = new Theater(2134, "shashi", "adilabad", null, null, "rahul", "9999999999");
		Theater th = adminDao.addTheater(theater);
		show = new Show(1234, null, null, "firstshow", null, 2132, 2133);

		assertThrows(MovieException.class, () -> adminDao.deleteShow(th.getTheaterId(), 1234));
	}
}
