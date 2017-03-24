/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social;


import reseau_social.company.Relation;
import java.util.ArrayList;
import java.util.Scanner;
import reseau_social.database.Users;


/**
 *
 * @author Adrien.JUHEM
 * 
 * class User à part qui a pour proporiété 
 * name
 * last name
 * Year of birht
 */
public class User extends Person implements Relation{
    Scanner scan = new Scanner(System.in);

    
    protected ArrayList<Message> messageList = new ArrayList();
    protected ArrayList<User> friendList = new ArrayList();
    
     public User(String name, String lastname, int yearOfBirth) {
        this.name = name;
        this.lastname = lastname;
        this.yearOfBirth = yearOfBirth;
    }

    public User() {}

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    } 
       
    public void setMessageList(Message message) {
        this.messageList.add(message);
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }
    
     public void setFriendList(User friend) {
        this.friendList.add(friend);
    }
     
    public ArrayList<User> getFriendList() {
        return friendList;
    }
    
    public void create(){           
    
            System.out.println("Veuillez saisir votre prenom : ");

        String changeName = scan.nextLine();

        System.out.println("Veuillez saisir votre nom : ");
        String changeLastname = scan.nextLine();

        System.out.println("veuillez saisir votre année de naissance : ");
        int changeYearOfBirth = 0;

        try {
            changeYearOfBirth = scan.nextInt();
            scan.nextLine();
            this.setYearOfBirth(changeYearOfBirth);
        } catch (Exception e) {
            changeYearOfBirth = Control.intControl("Veuillez entrer une date valide !");
        }

        this.setName(changeName);
        this.setLastname(changeLastname);
    }
    public void show (){
        Users.getUser(this.getName(), this.getLastname());
    }
  
    public void update (){
        
        int userId = Users.getId(this.getName(), this.getLastname());
        System.out.println("Gestion de votre Profile ");
        System.out.println("Veuillez saisir votre prenom : ");
       
        String changeName = scan.nextLine();

        System.out.println("Veuillez saisir votre nom : ");
        String changeLastname = scan.nextLine();

        System.out.println("veuillez saisir votre année de naissance : ");
        int changeYearOfBirth = 0;
       

            try {      
                changeYearOfBirth = scan.nextInt();
                scan.nextLine();
                this.setYearOfBirth(changeYearOfBirth);
                }catch(Exception e){
                changeYearOfBirth = Control.intControl("Veuillez entrer une date valide !");
                }
               

            this.setName(changeName);
            this.setLastname(changeLastname);
            Users.updateUser(this.getName(), this.getLastname(), this.getYearOfBirth(), userId);
            
   }
   
    
    public void showMessage (){
        if (this.getMessageList().size() > 0) {

            int i = 1;
            for (Message mess : this.getMessageList()) {

                System.out.println("le message n°"+ i + " est : " + mess.getTitle());
                System.out.println("De : " + mess.getSender() + " pour : " + mess.getReciever());
                System.out.println("le contenu est : " + mess.getContent());
                i++;
            }                           

        } else {
        System.out.println("Vous n'avez aucun message");
        }
    }
    
    public void createMessage (String sender) {
        
        if (this.getFriendList().size() > 0) {
            
            System.out.println("Donnez un titre à votre message :");
            String title = scan.nextLine();

            System.out.println("Ecrivez votre message :");
            String content = scan.nextLine();
            
            this.showFriends();        
            System.out.println("a qui souhaitez vous l'envoyer ?");

            int nbReciever = Control.intControl("veuillez renter un numero valide !");
            User reciever = this.getFriendList().get(nbReciever - 1);

            Message message = new Message(title, content, sender, (reciever.getName() + " " + reciever.getLastname()));
            this.setMessageList(message);
            reciever.setMessageList(message);
            
        } else {
            System.out.println("Vous n'avez pas encore d'amis a qui envoyer un message !");
        }
                
    }
    
     public void deleteMessage () {
         
        if (this.getMessageList().size() > 0) {

            System.out.println("quel message souhaitez vous effacer ?");
            int nbMessage = Control.intControl("Veuillez rentrer un numero valide !");
            
            int nb = nbMessage - 1;
            this.getMessageList().remove(nb);
            System.out.println("Le message a bien été effacé.");
        } 
     }
     
    public void addPerson (){
        System.out.println("Ajouter un ami ");
        Users.getList();
        System.out.println("Qui voulez-vous ajouter ?");
        
     
    }
    
    public void removeFriends (){
        System.out.println("Supprimer un ami ");
        
        this.showFriends();
        System.out.println("Qui voulez-vous supprimer ?");
        int nbfriend = Control.intControl("Veuillez entrer un numero valide!");
        this.getFriendList().remove(nbfriend - 1);
        System.out.println("Vous n'êtes plus ami avec cette personne.");
        
    }
    
    
    public void showFriends () {

        if (this.getFriendList().size() > 0) {
            int i = 1;
            for (User frnd : this.getFriendList()) {

                System.out.println(i + ". Vous êtes ami avec : " + frnd.getName() + " " + frnd.getLastname() + ".");
            }

        } else {
            System.out.println("Vous n'avez aucun amis pour le moment");
        }
    }
    public void getPaid(){};
    
    public void Search () {
        
        System.out.println("Systeme de recherche :");
        System.out.println();
        System.out.println("Entrer un prenom");
        String SearchName = scan.nextLine();
        System.out.println("Entrer un nom");
        String SearchLastname = scan.nextLine();
        String message = "Cette personne n'est pas inscrite sur le site.";
 
        
        
        
        for (User friend : this.getFriendList()) {
            
            if ((friend.getName().equals(SearchName)) && (friend.getLastname().equals(SearchLastname))){   
                message = "Vous êtes ami avec cette peronne.";
                
            }            
        }
        
        System.out.println(message);
        
    }
 
}
