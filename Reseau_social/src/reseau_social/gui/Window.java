/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social.gui;


import javax.swing.JFrame;
import java.awt.Graphics;
/**
 *
 * @author adrien.juhem
 */
public class Window extends JFrame{
      
    public Window() {
        
        this.setTitle("Hellow first Window");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              
        //pan.setBackground(Color.PINK);
       
        this.setContentPane(new Panel());  
        this.setVisible(true);
        
        
    }   
  
}
