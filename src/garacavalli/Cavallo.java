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
public class Cavallo extends JFrame {
    int cordx;
    int cordy;
    Image img;
    int pos;
    
    public Cavallo(int yy, int xx){
        cordx =0;
        cordy=yy;
        setSize(10,12);
        Toolkit tk= Toolkit.getDefaultToolkit();
        switch(xx){
            case 1: { img = tk.getImage("C:\\Users\\nicco\\Desktop\\GaraCavalli\\src\\garacavalli\\cavallo.jpg");break;}
            case 2: { img = tk.getImage("C:\\Users\\nicco\\Desktop\\GaraCavalli\\src\\garacavalli\\cavallo.jpg");break;}
            case 3: { img = tk.getImage("C:\\Users\\nicco\\Desktop\\GaraCavalli\\src\\garacavalli\\cavallo.jpg");break;}
            case 4: { img = tk.getImage("C:\\Users\\nicco\\Desktop\\GaraCavalli\\src\\garacavalli\\cavallo.jpg");break;}
            case 5: { img = tk.getImage("C:\\Users\\nicco\\Desktop\\GaraCavalli\\src\\garacavalli\\cavallo.jpg");break;}
            case 6: { img = tk.getImage("C:\\Users\\nicco\\Desktop\\GaraCavalli\\src\\garacavalli\\cavallo.jpg");break;}
        }
        MediaTracker mt= new MediaTracker(this);
        mt.addImage(img,1);
        try{mt.waitForID(1);}
        catch(InterruptedException e){}
    }
    
    public void setCordx(int n){
        cordx=n;
    }
    
    public int getCordx(){
        return cordx;
    }
    
    public void paint(Graphics ca){
        ca.drawImage(img, cordx, cordy, null);
    }
}
