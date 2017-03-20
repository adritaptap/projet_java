/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social.gui;


import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import reseau_social.Menu;
import reseau_social.User;


/**
 *
 * @author adrien.juhem
 */
public class Connexion extends JFrame {
    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Veuillez entrer :");
    private JLabel name = new JLabel("votre prenom :");
    private JLabel lastname = new JLabel("votre nom :");
    private JTextField inputName = new JTextField();
    private JTextField inputLastname = new JTextField();
    
    
   public Connexion () {
    this.setTitle("Connexion");
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    
        
    inputName.setPreferredSize(new Dimension(120, 25));
    inputLastname.setPreferredSize(new Dimension(120, 25));
    
    container.setBackground(Color.WHITE);
    
    container.setLayout(new BorderLayout());
    
    Font police = new Font("Arial", Font.BOLD, 14);
    JPanel top = new JPanel();
    JPanel panConnexion = new JPanel();
    JPanel panValidate = new JPanel ();
    
       JButton bouton = new JButton("valider");
           
       
       bouton.addActionListener(new ActionListener() {

           public void actionPerformed(ActionEvent event) {
        
               //Via cette instruction, on passe au prochain conteneur de la pile
               System.out.println(inputName.getText() + " " + inputLastname.getText());
              User user =  Menu.CheckUser(inputName.getText(), inputLastname.getText());
              if (user == null){
                JOptionPane alert = new JOptionPane();
                alert.showMessageDialog(null, "Votre identifiant n'est pas reconnu", "Attention", JOptionPane.WARNING_MESSAGE);
              } else {
                JOptionPane info = new JOptionPane();
                info.showMessageDialog(null, "Vous êtes connecté !", "Bon retour parmis nous", JOptionPane.INFORMATION_MESSAGE);             
              }
           }

       });
    
    top.add(label);  
    panConnexion.add(name);
    panConnexion.add(inputName);
    panConnexion.add(lastname);
    panConnexion.add(inputLastname);
    panValidate.add(bouton);
    container.add(top, BorderLayout.NORTH);
    container.add(panConnexion, BorderLayout.CENTER);
    container.add(panValidate, BorderLayout.PAGE_END);
    
    

        
    
    
    this.setContentPane(container);
    this.setVisible(true);     
   }
}
