/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_exercice1;

import java.util.Scanner;

/**
 *
 * @author Adrien.JUHEM
 */
public class Java_exercice1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /**
         * First : j'instancie un nouvel objet User avec des valeurs fixes
         */
        
        User user_test1 = new User("Adrien", "Juhem", 1988);
        System.out.println("Bonjour " + user_test1.getName() + " " + user_test1.getLastname() + ", vous avez " + (2017 - user_test1.getYearOfBirth()) + " ans");
        
        /**
         * Second : j'instancie un nouvel objet avec des valuers à rentrer en input par Sczanner
         */
       
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un prenom :");
        String name = sc.nextLine();
        System.out.println("Veuillez saisir votre nom de famille :");
        String lastname = sc.nextLine();
        System.out.println("Veuillez saisir votre date de naissance :");
        int yearOfBirth = sc.nextInt();

        User user_test2 = new User(name, lastname, yearOfBirth);
        System.out.println("Bonjour " + user_test2.getName() + " " + user_test2.getLastname() + ", vous avez " + (2017 - user_test2.getYearOfBirth()) + " ans");
    
        
        /**
         * Third: J'instancie un nouvel objet User avec mes valeur d'input tant que que l'utilisateur continue keypress O;
         */
        
        Scanner scan = new Scanner(System.in);
        int i = 0;
        char answer = ' ';
        
        do {
                     
            System.out.println("Veuillez saisir un prenom :");
            String nameUser = scan.nextLine();
            
            System.out.println("Veuillez saisir votre nom de famille :");
            String lastnameUser = scan.nextLine();
            
            System.out.println("Veuillez saisir votre date de naissance :");
            int yearOfBirthUser = scan.nextInt();           
            
            User user = new User(nameUser, lastnameUser, yearOfBirthUser);
            System.out.println("Bonjour " + user.getName() + " " + user.getLastname() + ", vous avez " + (2017 - user.getYearOfBirth()) + " ans");
                    
            do {
                System.out.println("Voulez-vous entrer un nouvel utilisateur ? (O/N)");
                 answer = scan.next().charAt(0);
                 scan.nextLine();
            } while(answer != 'O' && answer != 'N');
            
        } while(answer == 'O');
        
       System.out.println("Vous voulez partir ? A bientôt !");
    }
}
