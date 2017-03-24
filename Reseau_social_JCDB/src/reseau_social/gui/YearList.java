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
public class YearList {
     static ArrayList<Integer> yearList = new ArrayList();

    public YearList() {
    }

    public static ArrayList<Integer> getYearList() {
        return yearList;
    }

    public static void setYearList(int year) {
        YearList.yearList.add(year);
    }
     
}
