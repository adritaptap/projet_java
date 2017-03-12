/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social;

import java.util.ArrayList;

/**
 *
 * @author adrien
 */
public class UserList {
    private ArrayList<User> userList = new ArrayList();

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(User user) {
        this.userList.add(user);
    }

    
}
