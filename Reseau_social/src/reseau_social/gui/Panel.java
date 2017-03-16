/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau_social.gui;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author adrien.juhem
 */
public class Panel extends JPanel{
    public void paintComponent(Graphics g){
        g.drawString("Hello Everybody ! This is my first window with text in it! ", 10, 20);
    }
}
