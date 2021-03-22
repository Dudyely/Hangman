package src.main.service;


import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import src.main.model.Word;
import src.main.model.WordsList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author eduarda_scardoso
 */
public class WordsService {
    
    public final WordsList wordsList;

    public WordsService(WordsList wordsList) {
        this.wordsList = wordsList;
    }    
   
    public Word getWord(){
        try {            
            List<Word> words = wordsList.getWords();
            return wordsList.getWords().get(getPosition(0, words.size()-1));
        } catch (SAXException ex) {
            Logger.getLogger(WordsList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WordsList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(WordsList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    
    
    private static int getPosition(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    
}
