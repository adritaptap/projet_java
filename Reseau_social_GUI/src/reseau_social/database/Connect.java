/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
//import java.sql.SQLException;
import java.util.Properties;
/**
 *
 * @author adrien.juhem
 */
public class Connect {
    
    public static void testJCBD() {
        
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        String url = "jdbc:mysql://localhost/java_reseau_social";
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver OK.");
            
            Connection conn = DriverManager.getConnection(url, properties);
            System.out.println("Connection à la base de données OK.");
            
            Statement state = conn.createStatement();
            
            ResultSet result = state.executeQuery("SELECT * FROM user");
            
            ResultSetMetaData resultMeta = result.getMetaData();
            
            System.out.println("\n**********************************");

            //On affiche le nom des colonnes
            for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
            }

            System.out.println("\n**********************************");
            
            
            while (result.next()) {

                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    System.out.print("\t" + result.getObject(i).toString() + "\t |");
                }

                System.out.println("\n---------------------------------");

            }

            result.close();

            state.close();
            
            } catch (Exception e) {
                // handle the error
                System.out.println("Erreur de connection avec la base de données.");
            }      
        } 
}
