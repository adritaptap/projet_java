/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social;


import java.util.Scanner;

import reseau_social.database.Connect;
import reseau_social.database.Users;
import reseau_social.gui.IndexJFrame;
/**
 *
 * @author Adrien.JUHEM
 */
public class Reseau_social {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        User user = new User("toto", "titi", 1999);
        UserList.setUserList(user);
        IndexJFrame start = new IndexJFrame();
        Users.getList();
    }
}
    
