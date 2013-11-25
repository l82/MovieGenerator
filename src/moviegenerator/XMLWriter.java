/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviegenerator;


import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.FileWriter;

/**
 * The XMLWriter class is responsible for writing movieList to XML file
 * Example used quite a lot to figure out how this should be done:
 * http://www.java2s.com/Code/Java/JDK-6/XMLStreamWriterDemo.htm
 * 
 * @author lotta
 */
public class XMLWriter {
    
    /** xmlFile to write to */
    private final String xmlFile;
    
    /** Dummy constructor */
    public XMLWriter() {
        xmlFile = "";
    }
    
    /** Constructor that intiates the file name to write to */
    public XMLWriter(String fileName) {
        xmlFile = fileName;
    }
    
    /**
     * Loops through the movieList and writes the objects to the buffer
     * @param writer Buffer for XML data
     * @param list MovieList to buffer
     * @throws XMLStreamException 
     */
    private void writeMovies(XMLStreamWriter writer,
            MovieList list) throws XMLStreamException {
        
        Movie  movie;
        String ageS;
        String timeS;
        
        for (int i = 0; i < list.getNumberOfMovies(); i++) {
            movie = list.getMovieNo(i);
            writer.writeStartElement("movie");
            writer.writeStartElement("title");
            writer.writeCharacters(movie.getTitle());
            writer.writeEndElement();
            writer.writeStartElement("genre");
            writer.writeCharacters(movie.getGenre());
            writer.writeEndElement();
            writer.writeStartElement("director");
            writer.writeCharacters(movie.getDirector());
            writer.writeEndElement(); 
            writer.writeStartElement("age");
            ageS = String.valueOf(movie.getAge());
            writer.writeCharacters(ageS);
            writer.writeEndElement();
            writer.writeStartElement("time");
            timeS = String.valueOf(movie.getTime());
            writer.writeCharacters(timeS);
            writer.writeEndElement();
            writer.writeStartElement("customer");
            String customer = movie.getCustomer();
            if (customer.contentEquals("")) {
                customer = "-";
            }
            writer.writeCharacters(customer);
            writer.writeEndElement(); 
            writer.writeEndElement();
        }
    }
    
    /**
     * Write the header for XML data
     * @param writer XML buffer to write to
    */
    private void createXmlHeader(XMLStreamWriter writer) {
        try {
            writer.writeStartDocument("1.0");
            writer.writeStartElement("register");
             }
        catch  (XMLStreamException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Writes XML data to the file provided in constructor
     * @param list MovieList to print to file
     */
    public void writeToFile(MovieList list) {
    
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        
        try {
            XMLStreamWriter writer;
            writer = factory.createXMLStreamWriter(new FileWriter(xmlFile));
            createXmlHeader(writer);
            writeMovies(writer, list);
            writer.writeEndDocument();
            writer.flush();
            writer.close();
        }
        catch  (XMLStreamException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}