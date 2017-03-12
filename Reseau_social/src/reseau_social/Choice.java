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
 * @author adrien
 */
public class Choice {
    
    /**
     * display reponse depend to the choice.
     */
    static public User various(){
        
        User user = Menu.createUser();
        
        
        
        
        
        boolean logout = false;
        Scanner scan = new Scanner(System.in);
        
        do{ 
            switch(Menu.menuChoice( ))
                    {
                        /**
                         * Display profile
                         */
                        case "profile": 
                            System.out.println("********************************");

                            System.out.println("Affichage de votre Profile ");

                            System.out.println("votre prénom est: " 
                                     + user.getName());

                            System.out.println("votre nom est : " 
                                     + user.getLastname()); 

                            System.out.println("vous êtes né(e) en " 
                                    + user.getYearOfBirth());

                            System.out.println("********************************");
                            break;

                            /**
                             * Setting Profile
                             */
                        case "setting": 
                            boolean isNumber;
                            int changeYearOfBirth = 0;

                            System.out.println("********************************");

                            System.out.println("Gestion de votre Profile ");

                            System.out.println("nouveau prénom : ");
                            String changeName = scan.nextLine();

                            System.out.println("nouveau nom : ");
                            String changeLastname = scan.nextLine();

                            System.out.println("nouvelle date de naissance : ");

                            do {  

                                if(scan.hasNextInt()){      
                                changeYearOfBirth = scan.nextInt();
                                isNumber = true;
                                }else{
                                    System.out.println("Veuillez rentrer une date valide !");
                                    scan.nextLine();
                                    isNumber = false;
                                }
                            }while(!(isNumber));

                            user.setName(changeName);
                            user.setLastname(changeLastname);
                            user.setYearOfBirth(changeYearOfBirth);

                            System.out.println("Bravo, vous vous apellez desormais " + user.getName() + " " + user.getLastname() + " et vous avez " + (2017 - user.getYearOfBirth()) + " ans");  

                            System.out.println("********************************");
                            break;

                            /**
                             * Write a new message
                             */
                        case "write": 
                            System.out.println("********************************");

                            System.out.println("Donnez un titre à votre message :");
                            String title = scan.nextLine();

                            System.out.println("Ecrivez votre message :");
                            String content = scan.nextLine();

                            Message message = new Message(title, content);
                            user.setMessageList(message);

                            System.out.println("Votre message a bien été enregistré.");

                            System.out.println("********************************");
                            break;

                            /**
                             * Read all messages
                             */
                        case "read": 

                            System.out.println("********************************");

                            if (user.getMessageList().size() > 0) {

                                int i = 1;
                                for (Message mess : user.getMessageList()) {

                                    System.out.println("le message n°"+ i + " est : " + mess.getTitle());
                                    System.out.println("le contenu est : " + mess.getContent());
                                    i++;
                                }                           

                            } else {
                                System.out.println("Vous n'avez aucun message");
                            }

                            System.out.println("********************************");
                            break;
                        case "remove":
                           
                            int nbMessage = 0;
                            if (user.getMessageList().size() > 0) {

                                int i = 1;
                                for (Message mess : user.getMessageList()) {
                                    
                                    System.out.println("********************************");
                                    System.out.println("le message n°"+ i + " est : " + mess.getTitle());
                                    System.out.println("le contenu est : " + mess.getContent());
                                    i++;
                               
                                    System.out.println("********************************");
                                }                           
                                System.out.println("********************************");
                                System.out.println("quel message souhaitez vous effacer ?");
                                do {  

                                    if(scan.hasNextInt()){      
                                    nbMessage = scan.nextInt();
                                    isNumber = true;
                                    }else{
                                        System.out.println("Veuillez rentrer un numero valide !");
                                        scan.nextLine();
                                        isNumber = false;
                                    }
                                }while(!(isNumber));
                                int nb = nbMessage - 1;
                                user.getMessageList().remove(nb);
                                System.out.println("Le message a bien été effacé.");


                            } else {
                                System.out.println("Vous n'avez aucun message à effacer");
                            }
                            
                            System.out.println("********************************");
                            break;
                            /**
                             * Add a new friend
                             */
                        case "add": 
                            System.out.println("Ajouter un ami ");

                            System.out.println("Quel est son prénom ?");
                            String friendName = scan.nextLine();

                            System.out.println("Quel est son nom ?");
                            String friendLastname = scan.nextLine();

                            Friend friend = new Friend(friendName, friendLastname);
                            user.setFriendList(friend);

                            System.out.println("Votre ami " + friendName + " " + friendLastname + " a bien été ajouté.");
                            break;

                            /**
                             * Display a list of friends
                             */
                        case "friends": 

                            System.out.println("********************************");

                            if(user.getFriendList().size() > 0) {                            

                                for (Friend frnd : user.getFriendList()) {

                                    System.out.println("Vous êtes ami avec : " + frnd.getName() + " " + frnd.getLastname() + ".");
                                }

                            } else {
                                System.out.println("Vous n'avez aucun amis pour le moment");
                            }

                            System.out.println("********************************");
                            break;
                            /**
                             * Use to qui the Questionning loop
                             */
                        case "quit": 
                            System.out.println("********************************");
                            System.out.println("Vous nous quittez déjà ");
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
        
         return user;
    }
}
