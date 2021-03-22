/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main;

import src.main.service.HangmanService;

/**
 *
 * @author eduarda_scardoso
 */
public class Application {
    
    public static void main(String[] args){
        
        HangmanService  hangmanService = new HangmanService();
        hangmanService.hangmanGame();       
        
    }  
   
}
