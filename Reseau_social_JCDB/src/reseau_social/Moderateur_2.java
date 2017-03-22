/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social;


/**
 *
 * @author adrien.juhem
 */
public class Moderateur_2 extends Moderateur_1{
    

    public Moderateur_2(String name, String lastname, int yearOfBirth) {
        super(name, lastname, yearOfBirth);
    }
    public Moderateur_2(){
        
    }
    
    public void getPaid () {
        System.out.println("vous avez gagné de 100€ en bons d'achats pour votre travail");
    }
}
