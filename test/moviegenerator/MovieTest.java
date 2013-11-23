/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviegenerator;

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
public class MovieTest {
    
    public MovieTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTime method, of class Movie.
     */
    @Test
    public void testGetTime() {
        int expResult = 102; 
        System.out.println("getTime");
        Movie instance = new Movie("Kalle Kula springer fort", "barn", "Nisse Nissesson", 11, expResult);
        int result = instance.getTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Movie.
     */
    @Test
    public void testGetTitle() {
        String expResult = "Kalle Kula springer fort";
        System.out.println("getTitle");
        Movie instance = new Movie(expResult, "barn", "Nisse Nissesson", 11, 102);
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGenre method, of class Movie.
     */
    @Test
    public void testGetGenre() {
        String expResult = "deckare";
        System.out.println("getGenre");
        Movie instance = new Movie("Kalle Kula springer fort", expResult, "Nisse Nissesson", 11, 102);
        String result = instance.getGenre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDirector method, of class Movie.
     */
    @Test
    public void testGetDirector() {
        String expResult = "Nisse Nissesson";
        System.out.println("getDirector");
        Movie instance = new Movie("Kalle Kula springer fort", "barn", 
                expResult, 11, 102);
        String result = instance.getDirector();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAge method, of class Movie.
     */
    @Test
    public void testGetAge() {
        int expResult = 11;
        System.out.println("getAge");
        Movie instance = new Movie("Kalle Kula springer fort", "barn", "Pelle", 
                expResult, 102);
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTime method, of class Movie.
     */
    @Test
    public void testSetTime() {
        int valueToSet = 5;
        System.out.println("setTime");
        Movie instance = new Movie("Kalle Kula", "barn", "Pelle", 
                valueToSet, 102);
        instance.setTime(valueToSet);
        int result = instance.getTime();
        assertEquals(valueToSet, result);
    }

    /**
     * Test of setTitle method, of class Movie.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "Kalle Kula med två hårstrån";
        Movie instance = new Movie(title, "barn", "Pelle", 10, 102);
        instance.setTitle(title);
        String result = instance.getTitle();
        assertEquals(title, result);
    }

}