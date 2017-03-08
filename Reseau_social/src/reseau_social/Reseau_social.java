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
        // TODO code application logic here
        
      
        /**
         * Creation d'un utilisateur.
         */
        
        Scanner scan = new Scanner(System.in);
        char answer;
        String choice;
        ArrayList<String> messageList;
        messageList = new ArrayList();
        messageList.add("premier message");
        messageList.add("second message");
        ArrayList<String> friendList;
        friendList = new ArrayList();
        friendList.add("Joel");
        friendList.add("Jerome");
        friendList.add("Ben");
        friendList.add("Boris");
        
        
        do {
            System.out.println("Veuillez vous enregistrer");         
            System.out.println("Veuillez saisir un prenom :");
            String nameUser = scan.nextLine();
            
            System.out.println("Veuillez saisir votre nom de famille :");
            String lastnameUser = scan.nextLine();
            
            System.out.println("Veuillez saisir votre date de naissance :");
            int yearOfBirthUser = scan.nextInt();           
            scan.nextLine();
            
            User user = new User(nameUser, lastnameUser, yearOfBirthUser);
            System.out.println("Bonjour " + user.getName() + " " + user.getLastname() + ", vous avez " + (2017 - user.getYearOfBirth()) + " ans");
            
            /**
             * choice Question/Answer 
             */
            Boolean logout;
            logout = false;
            
            do{
            
                System.out.println("Gestion de votre compte : ");

                System.out.println("Que voulez-vous faire ? ");
                System.out.println("Afficher votre profil ? 'Profile'");
                System.out.println("Modifier vos infos personnelles ? 'Setting'");
                System.out.println("Ecrire un message ? 'Write'");
                System.out.println("Afficher un message ? 'Read'");
                System.out.println("Ajouter un ami ? 'Add'");
                System.out.println("Afficher le nom d’un ami ? 'Friends'");
                System.out.println("Sortir dela gestion de votre compte ? 'Quit' )");          

                
                choice = scan.nextLine(); 

                switch(choice)
                {
                    /**
                     * Display profile
                     */
                    case "Profile": 
                        System.out.println("Affichage de votre Profile ");

                        System.out.println("votre prénom est: " 
                                 + user.getName());

                        System.out.println("votre nom est : " 
                                 + user.getLastname()); 

                        System.out.println("vous êtes né(e) en " 
                                + user.getYearOfBirth());
                        break;

                        /**
                         * Setting Profile
                         */
                    case "Setting": 
                        System.out.println("Gestion de votre Profile ");

                        System.out.println("nouveau prénom : ");
                        String changeName = scan.nextLine();

                        System.out.println("nouveau nom : ");
                        String changeLastname = scan.nextLine();

                        System.out.println("nouvelle date de naissance : ");
                        int changeYearOfBirth = scan.nextInt();
                        scan.nextLine();

                        user.setName(changeName);
                        user.setLastname(changeLastname);
                        user.setYearOfBirth(changeYearOfBirth);

                        System.out.println("Bravo, vous vous apellez desormais " + user.getName() + " " + user.getLastname() + " et vous avez " + (2017 - user.getYearOfBirth()) + " ans");                   
                        break;

                        /**
                         * Write a new message
                         */
                    case "Write":                    
                        System.out.println("Ecrivez votre message :");
                        String message = scan.nextLine();
                        messageList.add(message);

                        System.out.println("Votre message a bien été enregistré.");
                        break;

                        /**
                         * Read all messages
                         */
                    case "Read": 
                        System.out.println("Vos messages : ");
                        int i = 1;
                        for (String mess : messageList) {

                            System.out.println("le message n°"+ i + " est : " + mess);
                            i++;
                        }
                        break;

                        /**
                         * Add a new friend
                         */
                    case "Add": 
                        System.out.println("Ajouter un ami ");

                        System.out.println("Quel est son nom ?");
                        String friend = scan.nextLine();
                        friendList.add(friend);

                        System.out.println("Votre ami " + friend + " a bien été ajouté.");
                        break;

                        /**
                         * Display a list of friends
                         */
                    case "Friends": 

                         System.out.println("Vos amis : ");
                         i = 1;
                        for (String frnd : friendList) {

                            System.out.println("le message n°"+ i + " est : " + frnd);
                             i++;
                        }
                        break;
                        /**
                         * Use to qui the Questionning loop
                         */
                    case "Quit": 
                        System.out.println("Vous nous quittez déjà ");
                        logout = true;
                        break;
                    default:
                       System.out.println("Pardon ?");
                       break;
                }
            }while(logout == false);   
            
            do {
                System.out.println("Voulez-vous entrer un nouvel utilisateur ? (O/N)");
                 answer = scan.next().charAt(0);
                 scan.nextLine();
            } while(answer != 'O' && answer != 'N');
            
        } while(answer == 'O');
        
       System.out.println("Vous voulez partir ? A bientôt !");
    }
}
    
