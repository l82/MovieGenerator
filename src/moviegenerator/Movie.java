package moviegenerator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The Movie class is responsible for one single movie. 
 * @author Lotta Hagborg
 */
public class Movie {
    
    /** Time that a movie last */
    private int time;
    /** Title of the movie */
    private String title;
    /** Genre of the movie for example "children" */
    private String genre;
    /** Director of the movie */
    private String director;
    /** Minimum age required to see the movie */
    private int age;
    /** Customer who has rented the movie */
    private String customer;
    
    /** Constructor used for a dummy movie */
    public Movie() {
        time = 0;
        age = 0;
        title = "no title";
        genre = "no genre";
        director = "no director";
        customer = "";
    }
    
    /** Constructor used for initiate a movie with "real" data
     * 
     * @param mTitle        Title of movie to add
     * @param mGenre        Genre of movie to add
     * @param mDirector     Director of movie to add
     * @param mAge          Min age of movie to add
     * @param mTime         Time for movie to add
     */
    public Movie(String mTitle, 
                 String mGenre, 
                 String mDirector, 
                 int mAge, 
                 int mTime) {
        time = mTime;
        age = mAge;
        title = mTitle;
        genre = mGenre;
        director = mDirector;
        customer = "";
    }  

    /**
     * Getter to get the time the movie will last
     * @return The time
     */
    public int getTime() {
        return time;
    }

    /**
     * Getter to get the title of the movie
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter to get the genre of the movie
     * @return The genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Getter to get the director of the movie
     * @return The director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Getter to get the age required to see the movie
     * @return The age
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Getter to get the customer who has rented the file
     * @return The customer
     */
    public String getCustomer() {
        return customer;
    }
    
    /**
     * Setter to set the time a movie will last
     * @param time The time to set
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Setter to set the title of the movie
     * @param title The title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Setter to set the genre of the movie
     * @param genre The genre to set
     */ 
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Setter to set the director of the movie
     * @param director The director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Setter to set the minimum allowed age to see the movie
     * @param age The age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * Setter to set the customer that has rented the movie
     * @param customer The age to set
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    /**
     * Format a string with information about the movie starting with a number
     * 
     * @param movieNo The number to print for the movie
     * @param formatting The formatting string to use to print movie
     * @return The formatted string with the information 
     */
    public String printMovie(int movieNo, String formatting) {
        return  String.format(formatting, movieNo,
                this.title, this.genre, this.director, this.age, this.time,
                this.customer);
    }
    
    /**
     * Puts together a formatted string with the movie information
     * @return The string with movie information
     */
    @Override
    public String toString() {
        String movie;
        
        movie = this.title + ";" + this.genre + ";" + this.director + ";" + 
                this.age + ";" + this.time + ";" + this.customer;
        return movie;
    }
}