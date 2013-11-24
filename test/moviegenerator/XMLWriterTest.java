/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviegenerator;

import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;

/**
 *
 * @author lotta
 */
public class XMLWriterTest {
    
    public XMLWriterTest() {
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
     * Test of writeToFile method, of class XMLWriter.
     */
    @Test
    public void testWriteToFile() {
        String fileToTest;
        FileHandler fileToTestHandle;
        MovieList list;
        
        System.out.println("writeToFile");
        
        fileToTest = "Nisse.xml";
        
        File file = new File(fileToTest);
        file.delete();
        
        XMLParser docToParse;
       
        docToParse = new XMLParser("Register.xml"); 
        list = docToParse.parseDocument(); //Inte så vackert tycker jag!
        
        XMLWriter instance = new XMLWriter(fileToTest);
        instance.writeToFile(list);
        
        fileToTestHandle = new FileHandler(fileToTest);

        try {
            fileToTestHandle.openFile();
        }
        catch (FileNotFoundException fnf) {
            fail("Should have raised a fileNotFoundException");
        }
       
    }
    
}
