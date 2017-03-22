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
public class Message {
    private String title;
    private String content;
    private String sender;
    private String reciever;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public Message(String title, String content) {
        this.title = title;
        this.content = content;
    }   

    public Message(String title, String content, String sender, String reciever) {
        this.title = title;
        this.content = content;
        this.sender = sender;
        this.reciever = reciever;
    }
   
}
