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
 * The XMLParser class is responsible to parse the XML file used for movie
 * register
 * Quite a lot of the used code is copied from:
 * http://www.javacodegeeks.com/2012/01/xml-parsing-using-saxparser-with.html
 * and then remade to fit my example
 * @author Lotta Hagborg
 */
public class XMLParser extends DefaultHandler {
    
    /** File to read from */
    private final String xmlFile;
    
    /** Movie list to add data from file into */
    private final MovieList listOfMovies;
    
    /** Used as an temporarily object when using SAX parser */
    private Movie tmpMovie;
    
    /** Used as an temporarily variable when using SAX parser*/
    private String tmpValue;
    
     /** Constructor used for a dummy parser object */
    public XMLParser() {
        xmlFile = "";
        listOfMovies = new MovieList();
    }
    
     /** Constructor used to create an XMLParser object 
      * @param fileName Name of file to read
      */
    public XMLParser(String fileName) {
        xmlFile = fileName;
        listOfMovies = new MovieList();
    }
    
    /**
     * Parse the file used in constructor and adds into the list of movies
     * @return A MovieList objects with movies in file
     */
    public MovieList parseDocument() {
        
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
    
    /**
     * Searches XML data for the tag "movie"
     * @param s See documentation for SAX parser
     * @param s1 See documentation for SAX parser
     * @param elementName See documentation for SAX parser
     * @param attributes See documentation for SAX parser
     * @throws SAXException 
     */
    @Override
    public void startElement(String s, String s1, String elementName, Attributes attributes) throws SAXException {
        
        // if current element is movie , create new movie
        // clear tmpValue on start of element
        if (elementName.equalsIgnoreCase("movie")) {
            tmpMovie = new Movie(); 
        }
    }
    
    /**
     * Writes data from file for a movie into a movie object and adds that into
     * MovieList object
     * @param s See documentation for SAX parser
     * @param s1 See documentation for SAX parser
     * @param element See documentation for SAX parser
     * @throws SAXException 
     */
    @Override
    public void endElement(String s, String s1, String element) throws SAXException {
        
        String tmpAgeS;
        String tmpLengthS;
        String tmpTitle;
        String tmpGenre;
        String tmpDirector;
        String tmpCustomer;
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

        if (element.equalsIgnoreCase("customer")) {
            tmpCustomer = tmpValue;
            System.out.println(tmpCustomer);
            tmpMovie.setCustomer(tmpCustomer);
        }
        if (element.equals("movie")) {
            listOfMovies.addMovieObject(tmpMovie); 
        }
    }

    /**
     * See SAX parser documentation
     * @param ac See documentation for SAX parser
     * @param i See documentation for SAX parser
     * @param j See documentation for SAX parser
     * @throws SAXException 
     */
    @Override
    public void characters(char[] ac, int i, int j) throws SAXException {
        tmpValue = new String(ac, i, j);
    }
}
