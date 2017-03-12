/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social;

import java.util.Scanner;

/**
 *
 * @author adrien.juhem
 */
public class Menu {
    static String menuChoice() {
    
        System.out.println("Gestion de votre compte : ");
        System.out.println("Que voulez-vous faire ? ");
                
        System.out.println("Afficher votre profil ? /////////////////// 'profile'");
        System.out.println("Modifier vos infos personnelles ? ///////// 'setting'");
        System.out.println("Ecrire un message ? /////////////////////// 'write'");
        System.out.println("Effacer un message ? ///////////////////// 'remove'");
        System.out.println("Afficher un message ? ///////////////////// 'read'");
        System.out.println("Ajouter un ami ? ////////////////////////// 'add'");
        System.out.println("Afficher le nom d’un ami ? //////////////// 'friends'");
        System.out.println("Sortir de la gestion de votre compte ? //// 'quit'");          
        
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine(); 
        return choice;
    }
    
    static char logoutChoice() {
        
        System.out.println("Voulez-vous entrer un nouvel utilisateur ? (O/N)");
        
        Scanner scan = new Scanner(System.in);
        char answerLogout = scan.next().charAt(0);
        scan.nextLine();
        return answerLogout;
    }
    
    static User createUser() {
            
            boolean isNumber;
            int yearOfBirthUser = 0;
            UserList userList = new UserList();
            User toto = new User("toto", "titi", 1999);
            userList.setUserList(toto);
            for (User user : userList.getUserList()) {
            System.out.println(user.getName()); 
            }
            Scanner scan = new Scanner(System.in);
    
            System.out.println("Veuillez vous enregistrer");         
            System.out.println("Veuillez saisir un prenom :");
            String nameUser = scan.nextLine();
            
            System.out.println("Veuillez saisir votre nom de famille :");
            String lastnameUser = scan.nextLine();
            
            System.out.println("Veuillez saisir votre date de naissance :");
            
            do {     
                if(scan.hasNextInt()){      
                    yearOfBirthUser = scan.nextInt();
                    isNumber = true;
                }else{
                    System.out.println("Veuillez rentrer une date !");
                    scan.nextLine();
                    isNumber = false;
                }
            }while(!(isNumber));
           
            scan.nextLine();
            System.out.println("Etes-vous Moderateur ? N/Y");
            char mederator = scan.next().charAt(0);
            scan.nextLine();
            
           if (mederator == 'N'){ 
                User user = new User(nameUser, lastnameUser, yearOfBirthUser);
                userList.setUserList(user);
                System.out.println("Bonjour " + user.getName() + " " + user.getLastname() + ", vous avez " + (2017 - user.getYearOfBirth()) + " ans");
                 return user; 
           } else {
                Moderateur_2 user = new Moderateur_2(nameUser, lastnameUser, yearOfBirthUser);
                userList.setUserList(user);
                System.out.println("Bonjour " + user.getName() + " " + user.getLastname() + ", vous avez " + (2017 - user.getYearOfBirth()) + " ans");
                 return user; 
           }
                
    }
}
