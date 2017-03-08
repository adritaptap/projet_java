/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social;

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
        // TODO code application logic here
        
      
        /**
         * Creation d'un utilisateur.
         */
        
        Scanner scan = new Scanner(System.in);
        char answer = ' ';
        String choice = " ";
        
        do {
            System.out.println("Veuillez vous enregistrer");         
            System.out.println("Veuillez saisir un prenom :");
            String nameUser = scan.nextLine();
            
            System.out.println("Veuillez saisir votre nom de famille :");
            String lastnameUser = scan.nextLine();
            
            System.out.println("Veuillez saisir votre date de naissance :");
            int yearOfBirthUser = scan.nextInt();           
            
            User user = new User(nameUser, lastnameUser, yearOfBirthUser);
            System.out.println("Bonjour " + user.getName() + " " + user.getLastname() + ", vous avez " + (2017 - user.getYearOfBirth()) + " ans");
            
            
            System.out.println("Gestion de votre compte : ");
            
            System.out.println("Que voulez-vous faire ? "
                                    + "Afficher votre profil ? 'Profile'"
                                    + "Modifier vos infos personnelles ? 'Settings' "
                                    + "Ecrire un message ? 'Write' "
                                    + "Afficher un message ? 'Read' "
                                    + "Ajouter un ami ? 'Add' "
                                    + "Afficher le nom d’un ami ? 'Friends' "
                                    + "Sortir dela gestion de votre compte ? 'Quit' )");
            
           
            choice = scan.nextLine();
            switch (choice)
            {
                case "Profile": 
                    System.out.println("Affichage de votre Profile ");
                    break;
                case "Settings": 
                    System.out.println("Gestion de votre Profile ");
                    break;
                case "Write": 
                    System.out.println("Ecrire un message ");
                    break;
                case "Read": 
                    System.out.println("Lire un message ");
                    break;
                case "Add": 
                    System.out.println("Ajouter un ami ");
                    break;
                case "Friends": 
                    System.out.println("Afficher vo amis ");
                    break;
               case "Quit": 
                    System.out.println("Vous nous quittez déjà ");
                    break;
               default:
                   System.out.println("Ecrire un message ");
            }
                    
            do {
                System.out.println("Voulez-vous entrer un nouvel utilisateur ? (O/N)");
                 answer = scan.next().charAt(0);
                 scan.nextLine();
            } while(answer != 'O' && answer != 'N');
            
        } while(answer == 'O');
        
       System.out.println("Vous voulez partir ? A bientôt !");
    }
}
    
