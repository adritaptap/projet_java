/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social;

import reseau_social.company.Salaried;

/**
 *
 * @author adrien.juhem
 */
public class Moderateur_1 extends User implements Salaried {

    public Moderateur_1(String name, String lastname, int yearOfBirth) {
        super(name, lastname, yearOfBirth);
    }

    public Moderateur_1() {
    }  
    
    public void getPaid () {
        System.out.println("vous avez gagné de 50€ en bons d'achats pour votre travail");
    }
}
