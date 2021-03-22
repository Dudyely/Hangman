/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author eduarda_scardoso
 */
public class WordsList {
    
    private List<Word> words;
    
    public WordsList(){}

    public WordsList(List<Word> words) {
        this.words = words;
    }
/*
    public List<Word> getWords() {
        return words;
    }*/

    public void setWords(List<Word> words) {
        this.words = words;
    }

    
    public List<Word> getWords() throws SAXException, IOException, ParserConfigurationException {
        List<Word> wordsList = new ArrayList<>();
        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = fabrica.newDocumentBuilder();
        Document document = builder.parse("src/words.xml");
        
        NodeList words = document.getElementsByTagName("word");
        
        for(int i = 0; i < words.getLength(); i++){
            Element word= (Element) words.item(i);
            wordsList.add(new Word(word.getTextContent(), word.getTextContent().length()));
        }
        
        return wordsList;
    }
}
