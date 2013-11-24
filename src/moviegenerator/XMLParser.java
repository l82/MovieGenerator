/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviegenerator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.IOException;

/**
 * Quite a lot of the used code is copied from:
 * http://www.javacodegeeks.com/2012/01/xml-parsing-using-saxparser-with.html
 * and then remade to fit my example
 * @author lotta
 */
public class XMLParser extends DefaultHandler {
    private final String xmlFile;
    private final MovieList listOfMovies;
    private Movie tmpMovie;
    private String tmpValue;
    
    public XMLParser() {
        xmlFile = "";
        listOfMovies = new MovieList();
    }
    
    public XMLParser(String fileName) {
        xmlFile = fileName;
        listOfMovies = new MovieList();
    }
    
    public MovieList parseDocument() {
        
        String formatting = "%-10s%-50s%-30s%-30s%-10s%-10s";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(xmlFile, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
        }
        return listOfMovies;
    }
    
    @Override
    public void startElement(String s, String s1, String elementName, Attributes attributes) throws SAXException {
        
        // if current element is movie , create new movie
        // clear tmpValue on start of element
        if (elementName.equalsIgnoreCase("movie")) {
            tmpMovie = new Movie(); 
        }
    }
    
    @Override
    public void endElement(String s, String s1, String element) throws SAXException {
        
        String tmpAgeS;
        String tmpLengthS;
        String tmpTitle;
        String tmpGenre;
        String tmpDirector;
        int    tmpAgeI;
        int    tmpLengthI;
        
        if (element.equalsIgnoreCase("title")) {
            tmpTitle = tmpValue;
            tmpMovie.setTitle(tmpTitle);
        }
        if (element.equalsIgnoreCase("genre")) {
            tmpGenre = tmpValue;
            tmpMovie.setGenre(tmpGenre);
        }
        if (element.equalsIgnoreCase("director")) {
            tmpDirector = tmpValue;
            tmpMovie.setDirector(tmpDirector);
        }
        if (element.equalsIgnoreCase("age")) {
            tmpAgeS = tmpValue;
            tmpAgeI = Integer.parseInt(tmpAgeS);
            tmpMovie.setAge(tmpAgeI);
        }
        if (element.equalsIgnoreCase("time")) {
            tmpLengthS = tmpValue;
            tmpLengthI = Integer.parseInt(tmpLengthS);
            tmpMovie.setTime(tmpLengthI);
        }
        if (element.equals("movie")) {
            listOfMovies.addMovieObject(tmpMovie); 
        }
    }

    @Override
    public void characters(char[] ac, int i, int j) throws SAXException {
        tmpValue = new String(ac, i, j);
    }
}
