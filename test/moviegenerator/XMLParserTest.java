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
public class XMLParserTest {
    
    private String testFileName;
    
    public XMLParserTest() {
        
        testFileName = "";
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
        testFileName = toFileName;
        instance = new FileHandler(fromFileName);
        
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

    @Test
    public void testParseDocument() {
        XMLParser docToParse;
        MovieList list;
        String formatting = "%-10s%-50s%-30s%-30s%-10s%-10s";
       
        docToParse = new XMLParser(testFileName); 
        list = docToParse.parseDocument();
        System.out.println("Number of movies: " + list.getNumberOfMovies());
        System.out.println(String.format(formatting, "Movie No", "Title", "Genre", 
                "Director", "Min Age", "Time(min)"));
        System.out.println(list.movieListToString(formatting));
    }
    
}
