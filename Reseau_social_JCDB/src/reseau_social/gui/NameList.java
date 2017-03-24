/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social.gui;

import java.util.ArrayList;
import reseau_social.Person;

/**
 *
 * @author adrien.juhem
 */
public class NameList {
    static ArrayList<String> nameList = new ArrayList();

    public NameList() {
    }

    public static ArrayList<String> getNameList() {
        return nameList;
    }

    public static void setNameList(String name) {
        NameList.nameList.add(name);
    }
    
    
}
