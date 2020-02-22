package com.cg.movie.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.movie.bean.Screen;
import com.cg.movie.bean.Show;
import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public class ScreenDaoImpl implements ScreenDao 
{
	private Map<Integer,Theater> map ;
	public ScreenDaoImpl()
	{
		map=new HashMap<Integer,Theater>();
	}
    
	@Override
	public Show searchShow(String showName) throws MovieException
	{
		Show show = new Show();
		Screen screen = new Screen();
		
		if((screen.getShowList()).equals(showName))
		{
			return show;
		}
		else
		{
			throw new MovieException("ShowName Not Available");
		}

			
		
		
	}
	@Override
	public List<Show> showShows() throws MovieException
	{
		
		Screen scr = new Screen();
		
		List<Show> list =scr.getShowList();
		
		
		return list;
	}

	
	

}
