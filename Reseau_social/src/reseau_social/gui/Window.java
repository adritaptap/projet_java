/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social.gui;



import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author adrien.juhem
 */
public class Window extends JFrame{
    
    CardLayout cardLayout = new CardLayout();
    JPanel content = new JPanel();
    
    String[] listContent = {"CARD_1", "CARD_2", "CARD_3"};
    int indice = 0;
    
   // private JPanel pan = new JPanel();
   // private JButton bouton = new JButton("Ne surtout pas Appuyer");
      
    public Window() {
        
        this.setTitle("Hellow first Window");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              
        //pan.setBackground(Color.PINK);
        //pan.add(bouton);
        //this.setContentPane(pan);  
        //this.setLayout(new BorderLayout());
        
        //this.getContentPane().add(new JButton("Ne pas Appuyer"), BorderLayout.NORTH);
        //this.getContentPane().add(new JButton("Hello Wordl !"), BorderLayout.CENTER);
        //this.setVisible(true);
        
        JPanel card1 = new JPanel();
        card1.setBackground(Color.BLUE);
        JPanel card2 = new JPanel();
        card2.setBackground(Color.RED);
        JPanel card3 = new JPanel();
        card3.setBackground(Color.GREEN);
        
        JPanel boutonPane = new JPanel();
        JButton bouton = new JButton("Contenue d'apres");
        
        bouton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                cardLayout.next(content);
                
            }
        });
      
        JButton bouton2 = new JButton("Contenu par indice");
        
        bouton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(++indice >2)
                    indice = 0;
                cardLayout.show(content, listContent[indice]);
            }
        });
        
        boutonPane.add(bouton);
        boutonPane.add(bouton2);
        
        content.setLayout(cardLayout);
        content.add(card1, listContent[0]);
        content.add(card2, listContent[1]);
        content.add(card3, listContent[2]);
        JLabel label1 = new JLabel();
        label1.setText("Mon premier JLabel");
        
        this.getContentPane().add(boutonPane, BorderLayout.NORTH);
        this.getContentPane().add(content, BorderLayout.CENTER);
        this.setVisible(true);
                
    }   
  
}
