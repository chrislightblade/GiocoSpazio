/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio;

import gioco_spazio.Sistemi.Pianeta;
import gioco_spazio.Strutture.Struttura;

/**
 *
 * @author tss
 */
public class Utility {
    
        
    public static boolean checkCosto(Pianeta p, String nome) {//--------> consegue aggiornamento struttura dopo x tempo
        //controlla se si ha abbastanza risorse per costruire una struttura
        for(cerca la struttura in pianeta)
        Struttura s = new Struttura();
        s = p.getStrutture().get(0);
        
        if (p.getRiservaMetallo() >= s.getCostoMetallo() && p.getRiservaCristallo() >= s.getCostoCristallo() && p.getRiservaIdrogeno() >= s.getCostoIdrogeno() ) {
            return true;
        }
        return false;
    }
    
}
