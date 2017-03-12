/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adrien.JUHEM
 */
public class Reseau_social {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        /**
         * Some variables are created to start
         */
        Scanner scan = new Scanner(System.in);
        
        char answer;
        /**
         * First: a do while loop to set a new user
         */
        do {       
            /**
             * choice Question/Answer 
             * a do while loop to repeat questions until QUIT
             */
                            
            Choice.various(); 
           
            do {
                
                 answer = Menu.logoutChoice();
                 
            } while(answer != 'O' && answer != 'N');
            
        } while(answer == 'O');
        
       System.out.println("Vous voulez partir ? A bientôt !");
    }
}
    
