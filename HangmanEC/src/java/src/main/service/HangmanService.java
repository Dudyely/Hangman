/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.service;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import src.main.model.Word;
import src.main.model.WordsList;

/**
 *
 * @author eduarda_scardoso
 */
public class HangmanService {

    private final WordsService wordsService;
    private Word word;

    public HangmanService() {
        wordsService = new WordsService(new WordsList());
        word = wordsService.getWord();
    }
  

    public void hangmanGame() {

        char[] wordToGuess = word.getWord().toUpperCase().toCharArray();
        char[] guess = word.getWord().toCharArray();
        Scanner input = new Scanner(System.in);
        Set<String> letters = new HashSet<>();
        int attempts = 0;
        String wordToPrint = "";
        
        for (int i = 0; i < word.getSize(); i++) {
            guess[i] = '*';
            wordToPrint = wordToPrint.concat("*");
        }

        while (!String.valueOf(guess).equals(word.getWord())) {

            boolean correct = false;
            boolean repeatedLetter = false;

            System.out.print("Word to guess: " + wordToPrint);

            System.out.println("\nType your guess: ");
            String letter = input.next().toUpperCase().substring(0, 1);
            char aux = letter.charAt(0);

            if (letters.contains(letter)) {
                System.out.println("You already guessed this letter!");
                repeatedLetter = true;
            }

            letters.add(letter);

            if (!repeatedLetter) {
                wordToPrint = "";
                for (int i = 0; i < word.getSize(); i++) {
                    if (wordToGuess[i] == aux) {
                        guess[i] = aux;
                        correct = true;
                        wordToPrint = wordToPrint.concat(letter);
                    } else {
                        wordToPrint = wordToPrint.concat(String.valueOf(guess[i]));
                    }
                }

            }
            attempts++;
            if (correct) {
                System.out.println("Correct! ");
            } else {
                System.out.println("Incorrect! ");
            }
        }
        System.out.println("You guessed the entire word " + word.getWord() + " correctly! It took you " + attempts + " attempts!");
    }
}
