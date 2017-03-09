/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social;

import java.util.ArrayList;

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
    private String name;
    private String lastname;
    private int yearOfBirth;
    private ArrayList<Message> messageList = new ArrayList();
    private ArrayList<Friend> friendList = new ArrayList();

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
}
