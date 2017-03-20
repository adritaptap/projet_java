/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social;

import java.util.Scanner;

/**
 *
 * @author adrien
 */
public class Control {
    
    public static int intControl(String errorMessage) {
         Scanner scan = new Scanner(System.in);
         boolean isNumber;
         int numberbOK = 0;
         
         do {     
                if(scan.hasNextInt()){      
                     numberbOK = scan.nextInt();
                    isNumber = true;
                }else{
                    System.out.println(errorMessage);
                    scan.nextLine();
                    isNumber = false;
                }
            }while(!(isNumber));
           
            scan.nextLine();
            return  numberbOK;
    }
}
