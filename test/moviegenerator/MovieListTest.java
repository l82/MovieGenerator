/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviegenerator;

import java.io.IOException;
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
        instance.addRemoveCustomer(2, expectedCustomer);
        testMovie = instance.getMovieNo(1);
        customer = testMovie.getCustomer();
        assertEquals(expectedCustomer, customer);
    }
    
}
