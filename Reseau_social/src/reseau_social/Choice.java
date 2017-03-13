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
        
        User user = Menu.start();
               
        boolean logout = false;
        Scanner scan = new Scanner(System.in);
        boolean isNumber;
        int changeYearOfBirth = 0;
        
        do{ 
            Menu.menuChoice();
            System.out.println(user.getClass().getSimpleName());
            
             if ((user.getClass().getSimpleName().equals("Moderateur_2")) || (user.getClass().getSimpleName().equals("Moderateur_1"))) {
        System.out.println();
       
        System.out.println("***************MODERATOR*****************");
        System.out.println("Effacer un message //////////////////////// 'mod mess'");
        System.out.println("Supprimer un utilisateur ////////////////// 'mod users'");
        System.out.println("*****************************************");
        }
            
            String choice = scan.nextLine();         
            switch(choice)
                    {
                        case "profile": 
                            System.out.println("********************************");
                            user.show();
                            System.out.println("********************************");
                            break;
                        case "setting": 
                            System.out.println("********************************");
                            user.update ();
                            user.presentation ();
                            System.out.println("********************************");
                            break;
                        case "write": 
                            System.out.println("********************************");
                            user.createMessage();
                            System.out.println("********************************");
                            break;
                        case "read":
                            System.out.println("********************************");
                            user.showMessage();
                            System.out.println("********************************");
                            break;                           
                        case "remove":
                            System.out.println("********************************");
                            user.showMessage();
                            user.deleteMessage();
                            System.out.println("********************************");
                            break;
                        case "add": 
                            System.out.println("********************************");
                            user.addFriend();
                            System.out.println("********************************");
                            break;
                        case "friends": 
                            System.out.println("********************************");
                            user.showFriends();
                            System.out.println("********************************");
                            break;
                        case "quit": 
                            System.out.println("********************************");
                            System.out.println("Vous nous quittez déjà ");
                            logout = true;
                            System.out.println("********************************");
                            break;                          
                        case "mod mess":
                            System.out.println("********************************");
                            if ((user.getClass().getSimpleName().equals("Moderateur_2")) || (user.getClass().getSimpleName().equals("Moderateur_1"))) {
                             UserList.removeMessageByUser();
                            } else {
                                System.out.println("Vous ne disposez pas des droits necessaires ");
                            }                            
                            System.out.println("********************************");
                            break;
                        case "mod users":
                            System.out.println("********************************");
                            if (user.getClass().getSimpleName().equals("Moderateur_2")) { 
                                
                                UserList.removeUser();
                                
                            } else {
                                System.out.println("Vous ne disposez pas des droits necessaires ");
                            }                            
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
