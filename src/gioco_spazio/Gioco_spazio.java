package gioco_spazio;

import gioco_spazio.Sistemi.Pianeta;
import gioco_spazio.Sistemi.SchermataPianeta;
import java.util.Date;
import util.DateFunction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tss
 */
public class Gioco_spazio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Pianeta p = new Pianeta("Ciaone", 163, 6);
        p.creaMinieraMetallo();
       
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchermataPianeta(p).setVisible(true);
            }
        });
    }
}
        
        


