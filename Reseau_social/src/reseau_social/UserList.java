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
public class UserList {
    
    
    static ArrayList<User> userList = new ArrayList();

    public UserList() {
    }  
    
    static public ArrayList<User> getUserList() {
        return userList;
    }

    static public void setUserList(User user) {
        UserList.userList.add(user);
    }
    static public void showUsers (){
        int i = 1;
        for(User user : UserList.getUserList()) {
            System.out.println("amis N°" + i + " : " + user.getName() + " " + user.getLastname());
            i++;
        }
    }
    static public void removeUser (){
        Scanner scan = new Scanner(System.in);
        int nbUser = 0;
        boolean isNumber;
                
        if (UserList.getUserList().size() > 0) {
            UserList.showUsers();
            System.out.println("Quel utilisateur souhaitez vous supprimer ?");
            do {  

                if(scan.hasNextInt()){      
                    nbUser = scan.nextInt();
                    isNumber = true;
               }else{
                    System.out.println("Veuillez rentrer un numero valide !");
                    scan.nextLine();
                    isNumber = false;
                    }
            }while(!(isNumber));
            int nb = nbUser - 1;
            UserList.getUserList().remove(nb);
            System.out.println("L'utilisateur a bien été effacé.");
        } else {
            System.out.println("Il n'y a pas d'utilisateur à supprimer");
        }
    }
    
    /*static public void displayMessagesByUser () {
        
        int j = 1;
        for (User usr : UserList.getUserList()) {
            for (Message mess : usr.getMessageList()) {
                System.out.println(j + ". titre: " + mess.getTitle() + ". contenu: " + mess.getContent());
                j++;
            }
        }
    }*/
    
   static public int displayMessagesByUser (){
        Scanner scan = new Scanner(System.in);
        int j = 1;   
        int nbUser = 0;
        if (UserList.getUserList().size() > 0) {
            UserList.showUsers();
            System.out.println("Gestion des messages :");
            System.out.println("Selectionnez un utilisateurs");
            nbUser = Control.intControl("Veuillez rentrer un numero valide !");
            
            int nb = nbUser - 1;
            
            User usr  = UserList.getUserList().get(nb);
            for (Message mess : usr.getMessageList()) {
                System.out.println(j + ". titre: " + mess.getTitle() + ". contenu: " + mess.getContent());
                j++;
            }
        
        } else {
            System.out.println("Il n'y a pas d'utilisateur à supprimer");
        }
        return nbUser;
    }
   
   static public void removeMessageByUser () {
       
       Scanner scan = new Scanner(System.in);  
       
       if (UserList.getUserList().size() > 0) {
           int nbUser = UserList.displayMessagesByUser();
          
           System.out.println("Selectionnez un message à effacer :");
           int nbMessage = Control.intControl("Veuillez rentrer un numero valide !");
           
           int nbMess = nbMessage - 1;

           User usr = UserList.getUserList().get(nbUser - 1);
           usr.getMessageList().remove(nbMess);
           
           System.out.println("Le message a bien été effacé."); 
           
       } else {
           System.out.println("Il n'y a pas d'utilisateur à supprimer");
       }
       
   }
       
}
