/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social;

import java.util.ArrayList;

/**
 *
 * @author adrien.juhem
 */
public class Moderateur_2 extends User{
    
   protected int status = 2;
   protected ArrayList<User> userListModerator = new ArrayList();

    public ArrayList<User> getUserListModerator() {
        return userListModerator;
    }

    public void setUserListModerator(ArrayList<User> userListModerator) {
        this.userListModerator = userListModerator;
    }
   
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Moderateur_2(String name, String lastname, int yearOfBirth) {
        super(name, lastname, yearOfBirth);
    }
   
}
