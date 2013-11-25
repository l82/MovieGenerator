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
public class MovieMenuTest {
    private String xmlFile;
    
    public MovieMenuTest() {
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
     * Test of printMenu method, of class MovieMenu.
     */
    @Test
    public void testPrintMenu() {
        System.out.println("printMenu");
        MovieMenu instance = new MovieMenu(xmlFile);
        instance.printMenu();
    }
    
    /**
     * Test of printMenu method, of class MovieMenu.
    */
    @Test
    public void testPrintMovieListForCustomer() {
        System.out.println("printMovieListForCustomer");
        MovieMenu instance = new MovieMenu(xmlFile);
        instance.printMoveListForCustomer();
    }
    
}
