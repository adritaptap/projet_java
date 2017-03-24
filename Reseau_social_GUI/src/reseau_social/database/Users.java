/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;
import reseau_social.Moderateur_1;
import reseau_social.Moderateur_2;
import reseau_social.User;

/**
 *
 * @author adrien.juhem
 */
public class Users {
    public static void getList() {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        String url = "jdbc:mysql://localhost/java_reseau_social";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(url, properties);

            Statement state = conn.createStatement();

            ResultSet result = state.executeQuery("SELECT * FROM user");

            ResultSetMetaData resultMeta = result.getMetaData();

            /*System.out.println("\n**********************************");

            //On affiche le nom des colonnes
            for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
            }

            System.out.println("\n**********************************");*/
            System.out.println("---------------------------------");
            int i = 1;
            while (result.next()) {
                //System.out.println("---------------------------------\n");                    
                    System.out.print("N°" + i + ": " 
                            + result.getObject("name").toString() + " " 
                            + result.getObject("lastname").toString() +  ".\n");
                  System.out.println("---------------------------------");  
                i++;
            }
            
            result.close();
            state.close();

        } catch (Exception e) {
            // handle the error
            System.out.println(" getlist: Erreur de connection avec la base de données.");
        }
    }
    public static void getUser(String userName, String Userlastname) {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        String url = "jdbc:mysql://localhost/java_reseau_social";

        try {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(url, properties);

            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            String query = "SELECT * FROM user";
            query += " WHERE name=?";
            query += " AND lastname=?";
            //query += " WHERE id='6'";
            //System.out.println(query); 
            
            PreparedStatement prepare = conn.prepareStatement(
                    query,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
     
            prepare.setString(1, userName);
            prepare.setString(2, Userlastname);
            ResultSet result = prepare.executeQuery();
            result.first();
                       
            System.out.println("**********************************");            
            System.out.println("Affichage de votre Profile ");
            System.out.println("votre prénom est: " + result.getObject("name").toString());
            System.out.println("votre nom est : " + result.getObject("lastname").toString());
            System.out.println("vous êtes né(e) en " + result.getObject("yearOfBirth").toString());
            System.out.println("**********************************");
            
            prepare.close();
            state.close();

        } catch (Exception e) {
            // handle the error
            System.out.println("getUser: Erreur de connection avec la base de données.");
            System.out.println(e);
        }
    }
    public static void createtUser(String userName, String userlastname, int yearOfBirth, String userStatus) {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        String url = "jdbc:mysql://localhost/java_reseau_social";

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(url, properties);

            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            String query = "INSERT INTO user (name, lastname, yearOfBirth, status)";
            query += " VALUES (?, ?, ?, ?)";
             
            PreparedStatement prepare = conn.prepareStatement(
                    query,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            prepare.setString(1, userName);
            prepare.setString(2, userlastname);
            prepare.setInt(3, yearOfBirth);
            prepare.setString(4, userStatus);
            prepare.executeUpdate();
            
            System.out.println("**********************************");
            System.out.println("Bonjour, "+ userName + " " + userlastname + " vous avez " + (2017 - yearOfBirth) + " ans." );
            System.out.println("**********************************");

            prepare.close();
            state.close();

        } catch (Exception e) {
            // handle the error
            System.out.println("createtUser: Erreur de connection avec la base de données.");
            System.out.println(e);
        }
    }
    
    public static void updateUser(String userName, String userlastname, int yearOfBirth, int userId) {

        
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        String url = "jdbc:mysql://localhost/java_reseau_social";

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(url, properties);
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String query = "UPDATE user";
            query += " SET name=?, lastname=?, yearOfBirth=?";
            query += " WHERE id=?";

            PreparedStatement prepare = conn.prepareStatement(
                    query,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            prepare.setString(1, userName);
            prepare.setString(2, userlastname);
            prepare.setInt(3, yearOfBirth);
            prepare.setInt(4, userId);

            prepare.executeUpdate();

            System.out.println("**********************************");
            System.out.println("Vous êtes deshormais, " + userName + " " + userlastname + " et vous avez " + (2017 - yearOfBirth) + " ans.");
            System.out.println("**********************************");

            prepare.close();
            state.close();

        } catch (Exception e) {
            // handle the error
            System.out.println("updateUser:Erreur de connection avec la base de données.");
            System.out.println(e);
        }
    }
    public static int getId(String userName, String Userlastname) {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        String url = "jdbc:mysql://localhost/java_reseau_social";
        int userId = 0;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(url, properties);

            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String query = "SELECT * FROM user";
            query += " WHERE name=?";
            query += " AND lastname=?";
            //query += " WHERE id='6'";
            //System.out.println(query); 

            PreparedStatement prepare = conn.prepareStatement(
                    query,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            prepare.setString(1, userName);
            prepare.setString(2, Userlastname);

            ResultSet result = prepare.executeQuery();

            result.first();

            userId = (int) result.getObject("id");
            System.out.println("**********************************");
            System.out.println("Affichage de votre Profile ");
            System.out.println("votre prénom est: " + result.getObject("name").toString());
            System.out.println("votre nom est : " + result.getObject("lastname").toString());
            System.out.println("vous êtes né(e) en " + result.getObject("yearOfBirth").toString());
            System.out.println("**********************************");

            prepare.close();
            state.close();
 

        } catch (Exception e) {
            // handle the error
            System.out.println("getId: Erreur de connection avec la base de données.");
            System.out.println(e);
        }
        
        return userId;
    }
    public static User getUserById(int userId) {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        String url = "jdbc:mysql://localhost/java_reseau_social";
        User user = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(url, properties);

            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String query = "SELECT * FROM user";
            query += " WHERE id=?";

            PreparedStatement prepare = conn.prepareStatement(
                    query,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
           
            prepare.setInt(1, userId);
           
            ResultSet result = prepare.executeQuery();
            result.first();
            
            String name = result.getObject("name").toString();
            String lastname = result.getObject("lastname").toString();
            int year = (int) result.getObject("yearOfBirth");
            String status = result.getObject("status").toString();
            
            System.out.println(name + " " + lastname + ", vous avez " +(2017 - year) + " ans et vous avez le status de "   + status);
            
            if (status.equalsIgnoreCase("Moderateur_1")){
                user = new Moderateur_1(name, lastname, year);
            } else if (status.equalsIgnoreCase("Moderateur_2")){
                user = new Moderateur_2(name, lastname, year);
            } else {
                user = new User(name, lastname, year);
            }

            prepare.close();

            state.close();

        } catch (Exception e) {
            // handle the error
            System.out.println("getUserById :Erreur de connection avec la base de données.");
            System.out.println(e);
        }
        return user;
    }
}
