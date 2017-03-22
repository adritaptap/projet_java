/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author adrien.juhem
 */
public class Index extends JFrame{
    
    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Vous voulez :");
    private JRadioButton check1 = new JRadioButton("Vous connecter");
    private JRadioButton check2 = new JRadioButton("Vous inscrire");
    private JRadioButton check3 = new JRadioButton("Allez sur l'espace entreprise");
    private ButtonGroup bg = new ButtonGroup();
    public Index(){
        
    this.setTitle("Index");
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
  
    JPanel top = new JPanel();
    
   
    check1.addActionListener(new StateListener());
    check2.addActionListener(new StateListener());
    check3.addActionListener(new StateListener());
    
    bg.add(check1);
    bg.add(check2);
    bg.add(check3);
    top.add(label);
    top.add(check1);
    top.add(check2);
    top.add(check3);
    container.add(top, BorderLayout.NORTH);
    this.setContentPane(container);
    this.setVisible(true);            
    
    }
    
    class StateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //System.out.println("source : " + ((JRadioButton)e.getSource()).getText() + " - etat : " + ((JRadioButton)e.getSource()).isSelected());
            if (check1.isSelected()) {
                System.out.println("connexion");
                Connexion connexion = new Connexion();
            }
            else if (check2.isSelected()) {
                System.out.println("inscription");
                
            }
            else {
                System.out.println("entreprise");
            }
        }
    }   
    
   
    
    
}
