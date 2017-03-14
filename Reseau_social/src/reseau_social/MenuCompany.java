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
public class MenuCompany {
    
    
    
    public static void displayChoice() {
        
        System.out.println("Que voulez-vous faire ? ");
        System.out.println();        
        
        System.out.println("Ajouter un employé ? ///////////////////////////// 'add'");
        System.out.println("Afficher vos employé ? /////////////////////////// 'display'");
        System.out.println("Sortir de la gestion de votre compte ? /////////// 'quit'");
        System.out.println();
    }
    
    public static String getChoice() {
        Scanner scan = new Scanner(System.in);
        MenuCompany.displayChoice();
        String answer = scan.nextLine();
        return answer;
    }
    
    public static void choice() {
        boolean logout = false;
        Ceo boss  = Ceo.editProfile();
        do {
            String choice = MenuCompany.getChoice();
            switch(choice)
                    {
                        case "add": 
                            System.out.println("********************************");
                            boss.addPerson();
                            System.out.println("********************************");
                            break;
                        case "display": 
                            System.out.println("********************************");
                            boss.showEmployee();
                            System.out.println("********************************");
                            break;
                        case "quit": 
                            System.out.println("********************************");
                            System.out.println("A bientôt patron !");
                            logout = true;
                            System.out.println("********************************");
                            break;                          
                        default:
                           System.out.println("********************************");
                           System.out.println("Pardon ?");
                           System.out.println("********************************");
                           break;
                    }
        }while(logout == false);
    }
    
    
}
