/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviegenerator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.FileNotFoundException; 
import java.io.IOException;
/**
 *
 * @author lotta
 */
public class FileHandlerTest {
    
    static FileHandler instance;
    static String testFileName;
    
    public FileHandlerTest() {
        instance = null;
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
        
        String toFileName = "TestRegister.xml";
        String fromFileName = "Register.xml";
        testFileName = toFileName;
        instance = new FileHandler(toFileName);
        
        System.out.println("setUp");
        try {
            instance.copyFile(fromFileName, toFileName);
        }
        catch (IOException ioe) {
            fail("Should not have raised a IO exception");
        }
        
        try {
            instance.openFile();
        }
        catch (FileNotFoundException fnf) {
            fail("Should not have raised a fileNotFoundException");
        }
    }  
    
    @After
    public void tearDown() {
        
        System.out.println("tearDown");
        instance.closeFile();
    }

    /**
     * Test openFile
     * This test do only test that an exception is raised if file does not exist.
     * The case when file exists is tested in set-up function.
     */
    @Test
    public void testFileOpen() {
       
        FileHandler fileToTest;
        
        fileToTest = new FileHandler("Kalle.xml");
        
        try {
            fileToTest.openFile();
            fail("Should have raised a fileNotFoundException");
        }
        catch (FileNotFoundException fnf) {
        }
    }
    
    @Test
    public void getFileName() {
        String expectedName;
        String currentName; 
        
        expectedName = testFileName;
        currentName = instance.getFileName();
        assertEquals(expectedName, currentName);
    }
    
    @Test
    public void copyFile() {
        String expectedName;

        expectedName = "justATest.xml";
        try {
            instance.copyFile(testFileName, expectedName);
        }
        catch (IOException ioe) {
            fail("Should not have raised a IO exception");
        }
        //Should probably delete file here as well... Never mind right now.
        //Also check for file does not exists from beginning is missing...
    }

}
