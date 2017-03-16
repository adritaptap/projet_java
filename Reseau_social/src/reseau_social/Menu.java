/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social;

import reseau_social.company.MenuCompany;
import java.util.Scanner;

/**
 *
 * @author adrien.juhem
 */
public class Menu {
    
    
    
    static void menuChoice() {
    
        System.out.println("Gestion de votre compte : ");
        System.out.println("Que voulez-vous faire ? ");
                
        System.out.println("Afficher votre profil ? /////////////////// 'profile'");
        System.out.println("Modifier vos infos personnelles ? ///////// 'setting'");
        System.out.println("Ecrire un message ? /////////////////////// 'write'");
        System.out.println("Effacer un message ? ////////////////////// 'remove'");
        System.out.println("Afficher un message ? ///////////////////// 'read'");
        System.out.println("Ajouter un ami ? ////////////////////////// 'add'");
        System.out.println("Afficher le nom d’un ami ? //////////////// 'friends'");
        System.out.println("Sortir de la gestion de votre compte ? //// 'quit'");
         
        
    }
    
    static char logoutChoice() {
        
        System.out.println("Voulez-vous entrer un nouvel utilisateur ? (Y/N)");
        
        Scanner scan = new Scanner(System.in);
        char answerLogout = scan.next().charAt(0);
        scan.nextLine();
        return answerLogout;
    }
    
    static void start (){
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Etes-vous membre de l'entreprise ? N/Y");
        char company = scan.next().charAt(0);
        scan.nextLine();
        if (company == 'Y'){
            
            
            MenuCompany.choice();
            System.exit(0);
        }
    }    
    static User stepOne () {
        Scanner scan = new Scanner(System.in);
        Menu.start();
        User user = Menu.CheckUser();
        if (user != null) {
            return user;
        }
        System.out.println("Etes-vous Moderateur ? N/Y");
        char mederator = scan.next().charAt(0);
        scan.nextLine();
         //User user;   
           if (mederator == 'N'){ 
               
                user = new User();
                user.update();
                user.presentation();
                UserList.setUserList(user);
                return user;
           
           } else {
               
               System.out.println("Etes-vous un moderateur de niveau 1 ou 2 ? 1/2");
               int nbModerator = Control.intControl("Veuillez entrer 1 ou 2");
               
                if(nbModerator == 2) {
                    user = new Moderateur_2();
                    user.update();
                    user.presentation();
                    UserList.setUserList(user);
                    return user;
                } else {
                   user = new Moderateur_1();
                    user.update();
                    user.presentation();
                    UserList.setUserList(user);
                    return user;
                }
                
           }
        }
      
    
    static public User CheckUser() {

        Scanner scan = new Scanner(System.in);
        User user = null;
        boolean connexion  = true;
        do {
        System.out.println("Etes-vous Deja inscrit ? N/Y");
        char inscrit = scan.next().charAt(0);
        scan.nextLine();
        if (inscrit == 'Y'){

            System.out.println("Connexion");
            System.out.println("Veuillez entrer votre prénom:");
            String name = scan.nextLine();
            System.out.println("Veuillez entrer votre nom:");
            String lastname = scan.nextLine();
            
            for (User us : UserList.getUserList()) {

                if ((us.getName().equals(name)) || (us.getLastname().equals(lastname))) {
                    connexion = false;
                    user = us;
                    System.out.println("Bon retour parmis nous !");
                    return user;
                } else {
                   
                    
                }
            }
            if(user == null) {
                System.out.println("Désolé vous n'êtes pas connu de nos services !");
            }
            
        }
        else {
            connexion = false;
        }
        } while (connexion == true);
        return user;
    }
}
