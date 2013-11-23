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

import java.io.BufferedReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.FileNotFoundException; 

/**
 *
 * @author lotta
 */
public class RegisterTest {
    
    static Register instance;
    
    public RegisterTest() {
        instance = null;
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        instance = new Register();
            
        System.out.println("setUp");
        
        try {
            instance.openFile("Register.txt");
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
     */
    @Test
    public void testFileOpen() {
       
        instance.closeFile();
        try {
            instance.openFile("Register.txt");
        }
        catch (FileNotFoundException fnf) {
            fail("Should not have raised a fileNotFoundException");
        }
        
        try {
            instance.openFile("Kalle.txt");
            fail("Should have raised a fileNotFoundException");
        }
        catch (FileNotFoundException fnf) {
        }
        
    }
    
    @Test
    public void getFile() {
        
    }

}
