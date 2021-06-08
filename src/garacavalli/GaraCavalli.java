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
public class GaraCavalli extends JFrame {
    int pos;
    Cavallo[]partecipanti;
    CavalliInGara[] thread_partecipanti;
    Campo percorso;
    Graphics offscreen;
    Image buffer_v;

    public GaraCavalli() {
        super("Gara Cavalli");
        setSize(1000,645);
        setLocation(10,40);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        percorso = new Campo();
        partecipanti = new Cavallo[6];
        thread_partecipanti= new CavalliInGara[6];
        pos=1;
        
        int partenza = 15;
        for (int xx=0; xx<6; xx++){
            partecipanti[xx]=new Cavallo(partenza, xx+1);
            thread_partecipanti[xx]= new CavalliInGara(partecipanti[xx],this);
            partenza= partenza +100;
        }
        
        this.add(percorso);
        setVisible(true);
    }
    
    public synchronized int getPosizione(){
        return pos++;
    }
    
    public synchronized void controlloArrivi(){
        boolean arrivati = true;
        for ( int xx=0; xx<6; xx++){
            if(thread_partecipanti[xx].pos==0){
                arrivati=false;
            }
        }
        if (arrivati){
            visualizzaClassifica();
        }
    }
    
    public void visualizzaClassifica(){
        JLabel[] arrivi;
        arrivi = new JLabel[6];
        JFrame classifica= new JFrame("La Classifica");
        classifica.setSize(500,500);
        classifica.setLocation(280,180);
        classifica.setBackground(Color.BLUE);
        classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
        classifica.getContentPane().setLayout(new GridLayout(6,1));
        
        for (int xx=1; xx<7; xx++){
            for (int yy=0; yy<6; yy++){
                if (thread_partecipanti[yy].pos==xx){
                    arrivi[yy] = new JLabel (xx+"° posto al cavallo del  "+(yy+1)+"° percorso");
                    arrivi[yy].setForeground(Color.black);
                    classifica.getContentPane().add(arrivi[yy]);                     
                }
            }
        }
        classifica.setVisible(true);
    }
    
    public void update(Graphics ca){
        paint(ca);
    }
    
    public void paint(Graphics ca){
        if (partecipanti !=null){
            Graphics2D screen = (Graphics2D)ca;
            buffer_v= createImage(1000,645);
            offscreen = buffer_v.getGraphics();
            Dimension d= getSize();
            percorso.paint(offscreen);
            for(int xx=0;xx<6;xx++){
                partecipanti[xx].paint(offscreen);
            }
            screen.drawImage(buffer_v, 0, 30, this);
            offscreen.dispose();
        }
    }
    
    public static void main(String[]a){
        GaraCavalli m = new GaraCavalli();
    }
    
}
