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

/**
 *
 * @author lotta
 */
public class FileHandler {
    BufferedReader fileHandle;
    String fileName;
    
    public FileHandler() {
        fileHandle = null;
        fileName = "";
    }
    
    public FileHandler(String name) {
        fileHandle = null;
        fileName = name;
    }
    
    public void openFile() throws FileNotFoundException {
        
        try {
            fileHandle = new BufferedReader(new FileReader(fileName));
        }
        catch (FileNotFoundException fnf) {
            System.out.println("Error message catched: " + fnf.getMessage());
            throw new FileNotFoundException();
        }
    }
    
    public void closeFile() {
        
        try {
            fileHandle.close();
        }
        catch (IOException ioe) {
            System.out.println("Error message catched: " + ioe.getMessage());
        }
    }
    
    public BufferedReader getFile() {
        return fileHandle;
    }
    
    public String getFileName() {
        return fileName;
    }
    
}
