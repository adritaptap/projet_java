/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import java.sql.SQLException;

/**
 *
 * @author adrien.juhem
 */
public class Connect {
   

    private String url = "jdbc:mysql://localhost/java_reseau_social";
    private String user = "root";
    private String password = "root";
    private static Connection connection;
    private static Connect connect = new Connect();
            
    private Connect(){
        try {
            connection = DriverManager.getConnection(url, user, password);
        }catch(SQLException e) {
            e.printStackTrace();
            }
        }
        
    public static Connection getInstance() {
        if (connection == null) {
           connect = new Connect(); 
            System.out.println("INSTANCIATION DE LA CONNEXION SQL ! ");
         } 
        return connection;
    }
}
