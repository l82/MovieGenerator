package moviegenerator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 * The MovieMenu class is responsible for the menu of the program and the
 * different choices that may be done there.
 * @author Lotta Hagborg
 */
public class MovieMenu {
    
    /** ArrayList used to store references to the movies */
    private MovieList myMovieList;
    private String xmlFile;
    
    /** Constructor used for a dummy movie */
    public MovieMenu(String fileName) {
        myMovieList = new MovieList();
        xmlFile = fileName;
        initiateMovies();
        menuLoop();
    }
        
    /** 
     * Prints the main menu
     */
    public void printMenu() {
        System.out.println("Welcome to MovieGenerator!");
        System.out.println("What do you want to do?");
        System.out.println("----------------------------------");
        System.out.println("1. Watch list of Movies");
        System.out.println("2. Add a Movie");
        System.out.println("3. Remove a Movie");
        System.out.println("----------------------------------");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }
    
    /**
     * Get user input when user should add an integer
     * @return The chosen integer value
     */
    public int getNumber() { 
        Scanner myScanner = new Scanner(System.in);
        int choice = myScanner.nextInt();
        return choice;
    }
    
     /**
     * Get user input when user should add an string
     * @return The entered string.
     */
    private String getStringChoice() {
        Scanner myScanner = new Scanner(System.in);
        myScanner.useDelimiter("\n");
        String choice = myScanner.nextLine();
        return choice;
    }
    
    /**
     * Prints a string without new line in end
     * @param stringToWrite 
     */
    private void printString(String stringToWrite) {
        System.out.print(stringToWrite);
    }
    
    /**
     * Print back and exit menu with a new line
     */
    private void printBackExitMenu() {
        System.out.println("0 - Back to head menu 9 - Exit");
    }
    
    /**
     * Asks for title and handles answer
     * @return The title
     */
    private String askAndGetTitle() {
        String title;
        
        printString("Enter name of movie: ");
        title = getStringChoice();
        return title;
    }
    
    /**
     * Asks for genre and handles answer
     * @return The genre
     */
    private String askAndGetGenre() {
        String genre;
        
        printString("Enter genre: ");
        genre = getStringChoice();
        return genre;
    }
    
    /**
     * Asks for director and handles answer
     * @return The genre
     */
    private String askAndGetDirector() {
        String director;
        
        printString("Enter director: ");
        director = getStringChoice();
        return director;
    }
    
    /**
     * Asks for age and handles answer
     * @return The age
     */
    private int askAndGetAge() {
        int age;
        
        printString("Enter minimum age: ");
        age = getNumber();
        return age;
    }
    
    /**
     * Asks for time and handles answer
     * @return The time
     */
    private int askAndGetTime() {
        int time;
        
        printString("Enter time in minutes: ");
        time = getNumber();
        return time;
    }
    
    /**
     * Prints "dialog" when user has chosen to add a movie and add the movie
     * into movie list
     */
    private void enterMovie() {
        
        String title = askAndGetTitle();
        String genre = askAndGetGenre();
        String director = askAndGetDirector();
        int age = askAndGetAge();
        int time = askAndGetTime();            
        myMovieList.addMovie(title, genre, director, age, time);
        System.out.println("Added movie: " + title);
        printBackExitMenu();
    }
    
    /**
     * Initiates some default movies
     */
    private void initiateMovies() {
        XMLParser docToParse;
       
        docToParse = new XMLParser(xmlFile); 
        myMovieList = docToParse.parseDocument(); //Inte så vackert tycker jag!
    }
    
    /**
     * Prints header and all movies
     */
    private void printMovieList() {
        String formatting = "%-10s%-50s%-30s%-30s%-10s%-10s";
        System.out.println("Number of movies in list: " + 
                myMovieList.getNumberOfMovies());
        System.out.println(String.format(formatting, "Movie No", "Title", "Genre", 
                "Director", "Min Age", "Time(min)"));
        System.out.println(myMovieList.movieListToString(formatting));
        printBackExitMenu();
    }
    
    /** 
     * Asks for title of movie to remove
     * @return The number of the movie to remove
     */
    private int askAndGetMovieToRemove() {
        int movieToRemove;
        
        printString("Enter movie number to erase: ");
        movieToRemove = getNumber();
        return movieToRemove;
    }
    
    /**
     * Prints the dialog for removing a movie and deletes it
     */
    private void removeMovie() {
        String removedMovie;
        
        printMovieList();
        int movieToRemove = askAndGetMovieToRemove();
        removedMovie = myMovieList.removeMovie(movieToRemove);
        System.out.println("Removed movie: " + removedMovie);
        printBackExitMenu();
    }
    
    /**
     * Shows the information for the menu item chosen
     * @param menuChoice The menu choice that the user has done
     */
    public void showMenuChoice(int menuChoice) {
        switch(menuChoice) {
            case 0:
                printMenu();
                break;
            case 1:
                printMovieList();
                break;
            case 2:
                enterMovie();
                break;
            case 3:
                removeMovie();
                break;
            case 9:
                exitProgram();
                break;
            default:
                System.out.print("Not a valid choice");
                break;
        }
                
    }
    
    /**
     * Exits the program
     */
    private void exitProgram() {
        
        XMLWriter instance = new XMLWriter(xmlFile);
        instance.writeToFile(myMovieList);
        System.exit(0);
    }
    
    /**
     * Shows the menu item chosen or exits the program depending on the choice 
     * of the user
     */
    private void menuLoop() {
        int menuChoice;
        
        printMenu();
        while (true) {
            menuChoice = getNumber();
            if (menuChoice == (int)9) {
                exitProgram();
            }
            else {
                showMenuChoice(menuChoice);
            }
        }
    }
    
}
