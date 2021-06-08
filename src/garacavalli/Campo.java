/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garacavalli;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author nicco
 */
public class Campo extends JPanel {
    public void paint(Graphics ca){
        ca.setColor(Color.yellow);
        ca.fillRect(0, 0, 1000, 645);
        
        ca.setColor(Color.black);
        ca.fillRect(0, 0, 1000, 10);
        ca.fillRect(0, 110, 1000, 10);
        ca.fillRect(0, 210, 1000, 10);
        ca.fillRect(0, 310, 1000, 10);
        ca.fillRect(0, 410, 1000, 10);
        ca.fillRect(0, 510, 1000, 10);
        ca.fillRect(0, 610, 1000, 10);
        
        ca.fillRect(900, 0, 5, 645);
        ca.fillRect(900, 0, 5, 645);
        ca.fillRect(900, 0, 5, 645);
    }
}
