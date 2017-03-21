/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social.company;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author adrien.juhem
 */
public class Inscritpion extends JFrame{
    
    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Veuillez entrer :");
    private JLabel name = new JLabel("votre prenom :");
    private JLabel lastname = new JLabel("votre nom :");
    private JLabel YearOfBirth = new JLabel("votre année de naissance :");
    private JTextField inputName = new JTextField();
    private JTextField inputLastname = new JTextField();
    private JTextField inputYearOfBirth = new JTextField();
       
    public Inscritpion () {
        
    this.setTitle("Inscription");
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    inputName.setPreferredSize(new Dimension(120, 25));
    inputLastname.setPreferredSize(new Dimension(120, 25));
    inputYearOfBirth.setPreferredSize(new Dimension(120, 25));
    
    
    Font police = new Font("Arial", Font.BOLD, 14);
    JPanel top = new JPanel();
    JPanel input1 = new JPanel();
    JPanel input2 = new JPanel();
    JPanel input3 = new JPanel();
    JPanel panName = new JPanel();
    JPanel panLastname = new JPanel();
    JPanel panYearOfBirth = new JPanel();
    
    container.setBackground(Color.WHITE);
    JPanel panValidate = new JPanel ();
    JButton bouton = new JButton("Inscription");
    
    bouton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent event) {

            System.out.println(inputName.getText() + " " + inputLastname.getText());
            System.out.println("Inscription réussi !");
            
        }

    });
    container.setLayout(new GridLayout(16, 3));    
    top.add(label);
    panName.add(name);
    input1.add(inputName);
    panLastname.add(lastname);
    input2.add(inputLastname);
    panYearOfBirth.add(YearOfBirth);
    input3.add(inputYearOfBirth);
    panValidate.add(bouton);
    
    container.add(top, "5");
    container.add(panName, "11");
    container.add(input1, "14");
    container.add(panLastname, "23");
    container.add(input2, "26");
    container.add(panYearOfBirth, "35");
    container.add(input3, "38");
    container.add(panValidate, "47");
    

   
    this.setContentPane(container);
    this.setVisible(true);     
    
    }
}

