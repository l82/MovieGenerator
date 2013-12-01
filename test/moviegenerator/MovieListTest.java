/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviegenerator;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lotta
 */
public class MovieListTest {
    
    private String xmlFile;
    
    public MovieListTest() {
        xmlFile = "";
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        FileHandler instance;
        String toFileName = "TestRegister.xml";
        String fromFileName = "Register.xml";
        xmlFile = toFileName;
        instance = new FileHandler(toFileName);
        
        try {
            instance.copyFile(fromFileName, toFileName);
        }
        catch (IOException ioe) {
            fail("Should not have raised a IO exception");
        }
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of addCustomer for a movie.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        MovieList instance = new MovieList();
        Movie testMovie;
        String customer;
        String expectedCustomer;
        expectedCustomer = "Totte Tottesson";
        
        //First add some movies
        instance.addMovie("Pelle Fnutt", "barn", "Kalle Kula", 3, 12);
        instance.addMovie("Fnuttidutt", "barn", "Kalle Kula", 3, 12);
        instance.addMovie("Pluttiplutt", "deckare", "Kalle Kula", 3, 12);
        //Add customer
        instance.addRemoveCustomer(2, expectedCustomer);
        testMovie = instance.getMovieNo(1);
        customer = testMovie.getCustomer();
        assertEquals(expectedCustomer, customer);
    }
    
    /**
     * Test of printing a list of movies for a certain customer.
     */
    @Test
    public void testGetMoviesForCustomer() {
        System.out.println("getMoviesForCustomer");
        MovieList instance = new MovieList();
        String formatting = "%d%s%s%s%d%d%s";
        String customer;
        customer = "Grisiana Gris";
        String actualString;
        String expectedString;
        String movieVariables[][];
        final int MAX_NO_OF_ENTRIES;
        MAX_NO_OF_ENTRIES = 7;
        expectedString = "";
        movieVariables = new String[3][MAX_NO_OF_ENTRIES];
        movieVariables[0][0] = "1";
        movieVariables[0][1] = "Nisse dansar balett";
        movieVariables[0][2] = "deckare";
        movieVariables[0][3] = "Nisse Nissesson";
        movieVariables[0][4] = "15";
        movieVariables[0][5] = "350";
        movieVariables[0][6] = "Grisiana Gris";
        
        movieVariables[1][0] = "2";
        movieVariables[1][1] = "Klara fixar med bilen";
        movieVariables[1][2] = "barn";
        movieVariables[1][3] = "Klara Klarasson";
        movieVariables[1][4] = "7";
        movieVariables[1][5] = "120";   
        movieVariables[1][6] = "Grisiana Gris";
        
        movieVariables[2][0] = "1";
        movieVariables[2][1] = "Petter spelar kula";
        movieVariables[2][2] = "barn";
        movieVariables[2][3] = "Petter Pettersson";
        movieVariables[2][4] = "0";
        movieVariables[2][5] = "12";
        movieVariables[2][6] = "Kalle Kula";
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < MAX_NO_OF_ENTRIES; j++) {
                expectedString = expectedString + movieVariables[i][j];
            }
            expectedString = expectedString + "\n";
        }
        System.out.println(expectedString);
        //First add some movies
        for (int i = 0; i < 3; i++) {
            instance.addMovie(movieVariables[i][1], movieVariables[i][2],
                movieVariables[i][3], Integer.parseInt(movieVariables[i][4]), 
                Integer.parseInt(movieVariables[i][5]));
        }
        instance.addRemoveCustomer(1, customer);
        instance.addRemoveCustomer(2, customer);
        instance.addRemoveCustomer(3, "");
        actualString = instance.getMoviesForCustomer(customer, formatting);
        
        assertEquals(expectedString, actualString);
    }
    
}
