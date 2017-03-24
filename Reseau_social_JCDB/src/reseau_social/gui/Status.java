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
public class Status {
    static ArrayList<String> statusList = new ArrayList();

    public Status() {
    }

    public static ArrayList<String> getStatusList() {
        return statusList;
    }

    public static void setStatusList(String status) {
        Status.statusList.add(status);
    }
}
