/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio.Strutture;

import gioco_spazio.Sistemi.Pianeta;

/**
 *
 * @author tss
 */
public class Miniera_metallo extends Struttura{

    public Miniera_metallo() {
        setNomeStruttura("Miniera di Metallo");
        setLivelloStruttura(1);
        setCostoMetallo(costoMetallo);
        setCostoCristallo(costoCristallo);
        setCostoIdrogeno(costoIdrogeno);
        setTempoLevelUp(tempoLevelUp);
    }
    
    
    
    public void produciMetallo(Pianeta p){
        
        if(p.getRiservaMetallo() < p.getDepositoMetallo())
        fattore produzione;
        livello struttura;
        bonus ricerca;
        (se la produz super deposito, allora riempi semplicemente il deposito)
        
    }
    
}
