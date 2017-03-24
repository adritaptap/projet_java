/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social.gui;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import reseau_social.Person;
import reseau_social.UserList;
import reseau_social.database.Users;

/**
 *
 * @author adrien.juhem
 */
public class ModelUserList extends AbstractTableModel{

    
    ArrayList<String> nameList = NameList.getNameList();
    ArrayList<String> lastnamelist = LastnameList.getLastnameList();
    ArrayList<Integer> yearList = YearList.getYearList();
    ArrayList<String> statusList = Status.getStatusList();
    ArrayList<String> listeColonne = new ArrayList();

    @Override
    public int getRowCount() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return nameList.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    
    ResultSet result = Users.getList() ; 
    
           switch(columnIndex)
           {
               case 0: return nameList.get(rowIndex);
               case 1: return lastnamelist.get(rowIndex);
               case 2: return yearList.get(rowIndex);
               case 3: return statusList.get(rowIndex);
               default : return "Indefini";
           }
    }
    
    @Override
    public String getColumnName(int column){
       listeColonne.add("Prénom");
       listeColonne.add("Nom");
       listeColonne.add("Age");
       listeColonne.add("Status");
       
      return listeColonne.get(column); 
    }
}
