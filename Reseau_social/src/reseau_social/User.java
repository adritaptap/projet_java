/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social;


import reseau_social.company.Relation;
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
    
    public User create(){           
    
            System.out.println("Veuillez vous enregistrer");         
            System.out.println("Veuillez saisir un prenom :");
            String nameUser = scan.nextLine();
            
            System.out.println("Veuillez saisir votre nom de famille :");
            String lastnameUser = scan.nextLine();
            
            System.out.println("Veuillez saisir votre date de naissance :");
            int yearOfBirthUser = Control.intControl("Veuillez rentrer une date !");
            
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
            
   }
    
    public void presentation () {
        System.out.println("Bonjour " + this.getName() + " " + this.getLastname() + ", vous avez " + (2017 - this.getYearOfBirth()) + " ans");
    }
    
    public void showMessage (){
        if (this.getMessageList().size() > 0) {

            int i = 1;
            for (Message mess : this.getMessageList()) {

                System.out.println("le message n°"+ i + " est : " + mess.getTitle() + " destiné à " + mess.getReciever() );
                System.out.println("le contenu est : " + mess.getContent());
                
                i++;
            }                           

        } else {
        System.out.println("Vous n'avez aucun message");
        }
    }
    
    public void createMessage (String sender) {
        System.out.println("Donnez un titre à votre message :");
        String title = scan.nextLine();

        System.out.println("Ecrivez votre message :");
        String content = scan.nextLine();
                
        System.out.println("Quel est le nom du destinataire ?");
        String reciever = scan.nextLine();
        
        Message message = new Message(title, content, sender, reciever);
        this.setMessageList(message);
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
        
        UserList.showUsers();
        System.out.println(this.getName());
        System.out.println("Qui voulez-vous ajouter ?");
        
        int nbUser = Control.intControl("Veuillez entrer un numero valide!");
        boolean friendExist = false; 
       
        User friend = UserList.getUserList().get(nbUser - 1);
        for (User user : this.getFriendList()) {
            if ((friend.getName().equals(user.getName())) && (friend.getLastname().equals(user.getLastname()))){
                
                 friendExist = true;
                
            }            
        }
        if (((this.getName().equals(friend.getName())) && (this.getLastname().equals(friend.getLastname())))){
                
                 friendExist = true;
                
            }
        if (friendExist == false) {
            this.setFriendList(friend);
            System.out.println("Votre ami " + friend.getName() + " " + friend.lastname + " a bien été ajouté.");
        } else {
            System.out.println("Vous êtes déja ami avec cette personne .");
        }
    }
    
    
    
    
    public void showFriends () {

        if (this.getFriendList().size() > 0) {
    
            for (User frnd : this.getFriendList()) {

                System.out.println("Vous êtes ami avec : " + frnd.getName() + " " + frnd.getLastname() + ".");
            }

        } else {
            System.out.println("Vous n'avez aucun amis pour le moment");
        }
    }

    void getPaid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
