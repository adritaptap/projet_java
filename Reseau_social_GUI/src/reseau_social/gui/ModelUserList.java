/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social.gui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import reseau_social.Person;
import reseau_social.UserList;

/**
 *
 * @author adrien.juhem
 */
public class ModelUserList extends AbstractTableModel{
ArrayList<Person> personList = UserList.getUserList();
ArrayList<String> listeColonne = new ArrayList();

    @Override
    public int getRowCount() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return personList.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       switch(columnIndex)
       {
        case 0: return personList.get(rowIndex).getName();
                case 1: return personList.get(rowIndex).getLastname();
                case 2: return (2017 - personList.get(rowIndex).getYearOfBirth());
                case 3: return (personList.get(rowIndex).getClass().getSimpleName());
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
