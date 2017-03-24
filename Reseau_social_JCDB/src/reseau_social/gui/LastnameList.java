/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social.gui;

import java.util.ArrayList;

/**
 *
 * @author adrien.juhem
 */
public class LastnameList {
    static ArrayList<String> lastnameList = new ArrayList();

    public static ArrayList<String> getLastnameList() {
        return lastnameList;
    }

    public static void setLastnameList(String lastname) {
        LastnameList.lastnameList.add(lastname);
    }

    public LastnameList() {
    }
}
