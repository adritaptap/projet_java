/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social.company;


import java.util.ArrayList;
import java.util.Scanner;
import reseau_social.Control;

/**
 *
 * @author adrien
 */
public class Ceo extends Employee implements Relation {

    protected ArrayList<Employee> employeeList = new ArrayList();
    Scanner scan = new Scanner(System.in);
    
    public Ceo() {
    }

    public Ceo(int pay, String contract) {
        super(pay, contract);
    }
    
    public void addPerson() { 
        
            
        System.out.println("Embaucher un employé ");

        System.out.println("Quel est son prénom ?");
        String nameD = scan.nextLine();

        System.out.println("Quel est son nom ?");
        String lastnameD = scan.nextLine();
       
        
        System.out.println("Veuillez saisir sa date de naissance :");
        int yearOfBirthD = Control.intControl("Veuillez rentrer une date valide !");
           
        System.out.println("Veuillez definir le type de contrat:");
        String contract = scan.nextLine();
        
        System.out.println("Veuillez definir le Salaire (en €):");
         int salary = Control.intControl("Veuillez rentrer un montant valide !");
          
        Employee dev  = new Developer(salary, contract);
        dev.setName(nameD);
        dev.setLastname(lastnameD);
        dev.setYearOfBirth(yearOfBirthD);
        employeeList.add(dev);
        System.out.println(dev.getName() + " " + dev.getLastname() + " a bien été embauché en " + dev.getContract() + ", pour " + dev.getPay() + " € mensuel.");
    }
    public void showEmployee() {
        int i = 1;
        for (Employee employee : this.employeeList) {
            System.out.println("Votre employé n°" + i + ": est "
                    + employee.getName() 
                    + " " 
                    + employee.getLastname() 
                    + ", embauché en " 
                    + employee.getContract() 
                    + ", pour un salaire de " 
                    + employee.getPay()
                    + "€.");
            i++;
        }
    }
    public static Ceo editProfile (){
        Ceo boss  = new Ceo();
        Scanner scan = new Scanner(System.in);
        System.out.println("****************************************************");
        System.out.println("Bonjour Patron !");
        System.out.println();
        System.out.println("Veuillez renseignerer votre profile:");
       
        System.out.println("Votre prénom :");
        String bossName = scan.nextLine();
        boss.setName(bossName);
        
        System.out.println("Votre nom :");
        String bossLastname = scan.nextLine();
        boss.setLastname(bossLastname);
        
        System.out.println("Votre année de naissance :");
        int bossYearOfBirth = Control.intControl("Veuillez rentrer une date valide !");
        boss.setYearOfBirth(bossYearOfBirth);
        System.out.println("****************************************************"); 
        System.out.println(); 
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Vous êtes " + boss.getName() + " " + boss.getLastname() +" et vous avez " + (2017 - boss.getYearOfBirth()) +" ans");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(); 
        return boss;
    } 
}
