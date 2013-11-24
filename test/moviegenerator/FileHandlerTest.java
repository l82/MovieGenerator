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
import static java.nio.file.StandardCopyOption.*;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    
    static void copyFile (String fromFileName, String toFileName) {
        Path FROM = Paths.get(fromFileName);
        Path TO = Paths.get(toFileName);
       
        try {
            Files.copy(FROM, TO, REPLACE_EXISTING);
        } 
        catch (IOException ioe) {
            fail("Could not copy file");
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        String toFileName = "TestRegister.txt";
        String fromFileName = "Register.txt";
        testFileName = toFileName;    
        
        copyFile(fromFileName, toFileName);
        
        instance = new FileHandler(toFileName);
            
        System.out.println("setUp");
        
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
        
        fileToTest = new FileHandler("Kalle.txt");
        
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

}
