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
public class Employee extends Person{
    private int pay;
    private String contract;
    
    public void work (){
        System.out.println("j'ai un contrat en " + this.contract + " , pour un salaire de" + this.pay);
    }

    public Employee(int pay, String contract) {
        this.pay = pay;
        this.contract = contract;
    }
    
    public Employee() {
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
    
    
}
