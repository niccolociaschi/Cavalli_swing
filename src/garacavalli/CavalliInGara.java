/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garacavalli;

/**
 *
 * @author nicco
 */
public class CavalliInGara implements Runnable {
    Cavallo cav;
    GaraCavalli campo;
    int velocita;
    Thread t;
    int conta;
    int pos;
    

    public CavalliInGara(Cavallo c, GaraCavalli ca) {
        cav = c;
        campo = ca;
        velocita = 2;
        t = new Thread(this);
        t.start();
        conta = 0;
        pos = 0;
    }
    
    

  
    public void run() {
       int dimImmagine = 49;
       int dimPista = 1060;
       while((cav.getCordx()+dimImmagine)<dimPista){
           if((conta%10)==0)
               velocita = (int)(Math.random()*4+1);
           cav.setCordx(cav.getCordx()+velocita);
           conta++;
           try{Thread.sleep(75);}
           catch(Exception e){}
           campo.repaint();
       }
       
       pos = campo.getPosizione();
       campo.controlloArrivi();
    }
    
}
