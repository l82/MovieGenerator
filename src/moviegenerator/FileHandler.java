/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviegenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * The file handler is responsible for opening and closing files and to handle
 * errors when file not found etc. This is a layer between MovieGenerator and
 * file system.
 * @author Lotta Hagborg
 */
public class FileHandler {
    
    /** Reader for file */
    BufferedReader fileHandle;
    /** File name to read from */
    String fileName;
    
    /** Dummy constructor for file handler */
    public FileHandler() {
        fileHandle = null;
        fileName = "";
    }
    
    /** Constructor which initiates fileName to use */
    public FileHandler(String name) {
        fileHandle = null;
        fileName = name;
    }
    
    /**
     * Opens the file chosen in constructor
     * @throws FileNotFoundException 
     */
    public void openFile() throws FileNotFoundException {
        
        try {
            fileHandle = new BufferedReader(new FileReader(fileName));
        }
        catch (FileNotFoundException fnf) {
            System.out.println("Error message catched: " + fnf.getMessage());
            throw new FileNotFoundException();
        }
    }
    
    /**
     * Closes the file that is chosen in constructor
     */
    public void closeFile() {
        
        try {
            fileHandle.close();
        }
        catch (IOException ioe) {
            System.out.println("Error message catched: " + ioe.getMessage());
        }
    }
    
    /**
     * Gets the BufferedReader for file that was opened in openFile 
     * @return The handle to the BufferedReader
     */
    public BufferedReader getFile() {
        return fileHandle;
    }
    
    /**
     * Gets the name of the file provided in constructor 
     * @return The name of the file
     */
    public String getFileName() {
        return fileName;
    }
    
    /**
     * Copies one file to another and overwrites the file to copy to if file 
     * already exists
     * @param fromFileName File name to copy from
     * @param toFileName File name to copy to
     * @throws IOException 
     */
    public void copyFile (String fromFileName, 
                          String toFileName) throws IOException{
        Path FROM = Paths.get(fromFileName);
        Path TO = Paths.get(toFileName);
       
        try {
            Files.copy(FROM, TO, REPLACE_EXISTING);
        } 
        catch (IOException ioe) {
            System.out.println("Error message catched: " + ioe.getMessage());
            throw new IOException();
        }
    }
    
}
