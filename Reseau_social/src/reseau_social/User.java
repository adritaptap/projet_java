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
 * 
 * class User à part qui a pour proporiété 
 * name
 * last name
 * Year of birht
 */
public class User {
    Scanner scan = new Scanner(System.in);

    protected String name;
    protected String lastname;
    protected int yearOfBirth;
    protected ArrayList<Message> messageList = new ArrayList();
    protected ArrayList<Friend> friendList = new ArrayList();
    
     public User(String name, String lastname, int yearOfBirth) {
        this.name = name;
        this.lastname = lastname;
        this.yearOfBirth = yearOfBirth;
    }

    public User() {
    }

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    } 
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    
    public void setMessageList(Message message) {
        this.messageList.add(message);
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }
    
     public void setFriendList(Friend friend) {
        this.friendList.add(friend);
    }
     
    public ArrayList<Friend> getFriendList() {
        return friendList;
    }
    
    public User create(){
            boolean isNumber;
            int yearOfBirthUser = 0;
            
    
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
            
            User user = new User (nameUser, lastnameUser, yearOfBirthUser);
            
            return user; 
    }
    public void show (){
        System.out.println("Affichage de votre Profile ");

        System.out.println("votre prénom est: " + this.getName());

        System.out.println("votre nom est : " + this.getLastname()); 

        System.out.println("vous êtes né(e) en " + this.getYearOfBirth());
    }
  
    public void update (){
        
        boolean isNumber;
        int changeYearOfBirth = 0;
        
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

            this.setName(changeName);
            this.setLastname(changeLastname);
            this.setYearOfBirth(changeYearOfBirth);
   }
    
    public void presentation () {
        System.out.println("Bonjour " + this.getName() + " " + this.getLastname() + ", vous avez " + (2017 - this.getYearOfBirth()) + " ans");
    }
    
    public void showMessage (){
        if (this.getMessageList().size() > 0) {

            int i = 1;
            for (Message mess : this.getMessageList()) {

                System.out.println("le message n°"+ i + " est : " + mess.getTitle());
                System.out.println("le contenu est : " + mess.getContent());
                i++;
            }                           

        } else {
        System.out.println("Vous n'avez aucun message");
        }
    }
    
    public void createMessage () {
        System.out.println("Donnez un titre à votre message :");
        String title = scan.nextLine();

        System.out.println("Ecrivez votre message :");
        String content = scan.nextLine();

        Message message = new Message(title, content);
        this.setMessageList(message);
    }
    
     public void deleteMessage () {
        int nbMessage = 0;
        boolean isNumber;
        if (this.getMessageList().size() > 0) {

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
            this.getMessageList().remove(nb);
            System.out.println("Le message a bien été effacé.");
        } 
     }
     
    public void addFriend (){
        System.out.println("Ajouter un ami ");

        System.out.println("Quel est son prénom ?");
        String friendName = scan.nextLine();

        System.out.println("Quel est son nom ?");
        String friendLastname = scan.nextLine();

        Friend friend = new Friend(friendName, friendLastname);
        this.setFriendList(friend);

        System.out.println("Votre ami " + friendName + " " + friendLastname + " a bien été ajouté.");
    }
    
    public void showFriends () {

        if (this.getFriendList().size() > 0) {
    
            for (Friend frnd : this.getFriendList()) {

                System.out.println("Vous êtes ami avec : " + frnd.getName() + " " + frnd.getLastname() + ".");
            }

        } else {
            System.out.println("Vous n'avez aucun amis pour le moment");
        }
    }
}
