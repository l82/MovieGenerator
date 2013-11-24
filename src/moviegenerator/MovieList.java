package moviegenerator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList; 

/**
 * The MovieList class is responsible for handling the list of movies. 
 * @author Lotta Hagborg
 */
public class MovieList {
    
    /** ArrayList used to store references to the movies */
    private final ArrayList<Movie> myMovies;
    /** Number of movies in the list */

    /** Constructor used for initiate arrayList with movies */
    public MovieList() {
       myMovies = new ArrayList();
    }
   
    /** 
     * Puts the list of movies into a formatted string
     * @param format Format of the string
     * 
     * @return The string of movies
     */
    public String movieListToString(String format) {
        Movie movieToPrint;
        String movieToString = "";
        String concatMovieList = "";
        
        for (int i = 0; i < myMovies.size(); i++) {
            movieToPrint = myMovies.get(i);
            movieToString = movieToPrint.printMovie((i + 1), format);
            concatMovieList = concatMovieList + movieToString + "\n";
        }
        return concatMovieList;
    }
    
    /** 
     * Adds a movie into list
     * 
     * @param mTitle        The title of the movie to add
     * @param mGenre        The genre of the movie, for example children 
     * @param mDirector     The director of the movie to add
     * @param mAge          The age which the movie is allowed from
     * @param mTime         The time in minutes which the movie last
     */
    public void addMovie(String mTitle, 
                           String mGenre, 
                           String mDirector,
                           int mAge, 
                           int mTime) {
        
        Movie movie;
        movie = new Movie(mTitle, mGenre, mDirector, mAge, mTime);
        myMovies.add(movie);
 
    }
    
     /** 
     * Adds a movie into list
     * 
     * @param object        The object to be added
     */
    public void addMovieObject(Movie object) {
        
        myMovies.add(object);
 
    }
    
    /** 
     * Removes a movie from the list
     * 
     * @param movieNo   The movie number to be removed. Note! This parameter 
     * should not be the list number but the number as the user see (number in 
     * list + 1)
     * @return The title of the removed movie
     */
     public String removeMovie(int movieNo) {
        
        Movie movieToRemove;
        String movieTitle = null;
        movieToRemove = myMovies.get((movieNo - 1));
        
        if (movieToRemove != null) {
            movieTitle = movieToRemove.getTitle();
            myMovies.remove(movieToRemove);
        }
        return movieTitle;
    }
    
    /**
     * 
     * @param movieId     Id in movie array
     * @return 
     */
    public Movie getMovieNo(int movieId) {
        
        Movie movie;
        movie = myMovies.get((movieId));
        return movie;
    }
    
    /**
     * Returns the number of movies in the list
     * @return The current number of movies
     */
    public int getNumberOfMovies() {
        return myMovies.size();
    }
    
}
