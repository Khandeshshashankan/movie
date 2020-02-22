package com.cg.movie.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cg.movie.bean.Movie;
import com.cg.movie.bean.Screen;
import com.cg.movie.bean.Show;
import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public class AdminDaoImpl implements AdminDao
{
	private Map<Integer,Theater> map ;
	private List<Show> listOfShow ;
	private Screen screen = null;
	private Theater th =null;
	
	public AdminDaoImpl() {
		map=new HashMap<Integer,Theater>();
		listOfShow = new ArrayList<Show>();
	    screen = new Screen();
	    
	}
    @Override
	public Theater addTheater(Theater theater) throws MovieException {
		
		boolean flag =map.containsKey(theater.getTheaterId());
		if(flag) {
			throw new MovieException("Id already exists");
			
		}
		th = theater;
		map.put(theater.getTheaterId(), th);
		
		return theater;
	}
    
    @Override
	public boolean deleteTheater(int theaterId) throws MovieException {
		boolean flag =map.containsKey(theaterId);
		if(flag)
		{
			map.remove(theaterId);
			return true;
		}
		else
		{
			throw new MovieException(theaterId+"Id is not found");			
		}

}
		
    @Override
	public Movie addMovie(Movie movie) throws MovieException {
		
		
		Theater theater = new Theater();
		List<Movie> list =  theater.getMoviesList();
		
		boolean flag = list.equals(movie);
		if(flag) {
			throw new MovieException("Movie ID already exists");
			
		}
		
		
		
		
		list.add(movie);
		
		return movie;
	}
    @Override
	public boolean deleteMovie(int movieId) throws MovieException {

		Theater theater = new Theater();
		List<Movie> list =  theater.getMoviesList();
		List<Integer> list1 = list.stream().map(p->p.getMovieId()).collect(Collectors.toList());
		
		boolean flag = list1.contains(movieId);
		if(flag)
		{
			list.remove(movieId);
			return true;
		}
		
		else
		{
			
			throw new MovieException("Movie Does Not Exist");
			
		}
	}
    @Override
	public Screen addScreen(Screen screen) throws MovieException {
		return screen;
     /*Theater theater = new Theater();

     List<Screen> list =  theater.getListOfScreens();
     
		boolean flag = list.equals(screen);
		if(flag) {
			throw new MovieException("Screen ID already exists");
			
		}
		
		list.add(screen);   	
    	
		return screen;*/
	}
    @Override
	public boolean deleteScreen(int screenId) throws MovieException {
		return false;

    	/*Theater theater = new Theater();
		List<Screen> list =  theater.getListOfScreens();
		List<Integer> list1 = list.stream().map(p->p.getScreenId()).collect(Collectors.toList());
		
		boolean flag = list1.contains(screenId);
		if(flag)
		{
			list.remove(screenId);
			return true;
		}
		
		else
		{
			
			throw new MovieException("Screen Does Not Exist");
			
		}*/
	}
    @Override
	public Show addShow(int theaterId,Show show) throws MovieException {
    	
    	//Screen screen = new Screen();
        
        List<Integer> list = listOfShow.stream().map(p->p.getShowId()).collect(Collectors.toList());
        
   		boolean flag = list.contains(show.getShowId());
   		if(flag) {
   			throw new MovieException("Show already exists");
   			
   		}
   		
   		listOfShow.add(show);   
   		screen.setShowList(listOfShow);
       	System.out.println(listOfShow);
   		return show;
   	}
    	
    @Override
	public boolean deleteShow(int theaterId,int showId) throws MovieException {
		boolean flag = false;
    	//Screen screen= new Screen();
        List<Integer> list1 = listOfShow.stream().map(p->p.getShowId()).collect(Collectors.toList());
		
	    flag = list1.contains(showId);
		if(flag)
			
		{
			for(Show sh : listOfShow) {
				if(sh.getShowId()==showId) {
					listOfShow.remove(sh);
					flag = true;
					break;
				}
			}
		//List<Show> list2 =	listOfShow.stream().filter(p-> p.getShowId() != showId).collect(Collectors.toList());
		//screen.setShowList(list2);
			
		}
		
		else
		{
			
			throw new MovieException("ShowId Does Not Exist");
			
		}
		return flag;
	
    }
   	
}
