/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio.Strutture;

import gioco_spazio.Sistemi.Pianeta;
import java.util.Date;
import util.DateFunction;

/**
 *
 * @author tss
 */
public class Struttura {

    private String nomeStruttura;
    private int livelloStruttura;
    private int costoMetallo;
    private int costoCristallo;
    private int costoIdrogeno;
    private String tempoLevelUp;
    private double fattoreProduzione;//per aggiornare la produzione post levelUp    
    private int valoreProdotto;//al secondo    
    private boolean levelUp = false;

    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void levelUp(Pianeta p) {
        //level up in tot tempo;
            levelUp = true;
            p.setRiservaCristallo(costoCristallo);
            p.setRiservaMetallo(costoMetallo);
            p.setRiservaIdrogeno(costoIdrogeno);
        
    }

    public void setParametriPostLevelUp(double p1, double p2, double p3, double p4) {

        setCostoMetallo(costoMetallo * p1(parametro));
        setCostoCristallo(costoCristallo * p2(parametro));
        setCostoIdrogeno(costoIdrogeno * p3(parametro));
        setTempoLevelUp(tempoLevelUp * p4(parametro));
    }

    public void aggiornaProduzioni(Pianeta p) {
        Date data = new Date();
        String Data = DateFunction.converti(data);
        tempo = converti in secondi da usare per il calcolo;
        p.setRiservaCristallo(valoreProdottoCristallo * tempo);
        p.setRiservaMetallo(valoreProdottoMetallo * tempo);
        p.setRiservaIdrogeno(valoreProdottoIdrogeno * tempo);
    }
    

    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getTempoLevelUp() {
        return tempoLevelUp;
    }

    public void setTempoLevelUp(String tempoLevelUp) {
        this.tempoLevelUp = tempoLevelUp;
    }

    public String getNomeStruttura() {
        return nomeStruttura;
    }

    public void setNomeStruttura(String nomeStruttura) {
        this.nomeStruttura = nomeStruttura;
    }

    public int getLivelloStruttura() {
        return livelloStruttura;
    }

    public void setLivelloStruttura(int livelloStruttura) {
        this.livelloStruttura = livelloStruttura;
    }

    public int getCostoMetallo() {
        return costoMetallo;
    }

    public void setCostoMetallo(int costoMetallo) {
        this.costoMetallo = costoMetallo;
    }

    public int getCostoCristallo() {
        return costoCristallo;
    }

    public void setCostoCristallo(int costoCristallo) {
        this.costoCristallo = costoCristallo;
    }

    public int getCostoIdrogeno() {
        return costoIdrogeno;
    }

    public void setCostoIdrogeno(int costoIdrogeno) {
        this.costoIdrogeno = costoIdrogeno;
    }

    public double getFattoreProduzione() {
        return fattoreProduzione;
    }

    public void setFattoreProduzione(double fattoreProduzione) {
        this.fattoreProduzione = fattoreProduzione;
    }    

    public int getValoreProdottoIdrogeno() {
        return valoreProdotto;
    }

    public void setValoreProdotto(int valoreProdotto) {
        this.valoreProdotto = valoreProdotto;
    }

    public boolean isLevelUp() {
        return levelUp;
    }

    public void setLevelUp(boolean levelUp) {
        this.levelUp = levelUp;
    }

    

}
miniera metallo, cristallo, idrogeno;
deposito metallo, cristallo, idrogeno;
centrale solare, fusione, satelliti;
centro robot, microbot, nanobot;
centro ricerca;
spazioporto;
portale spaziale;
luna/e;
terraformatore;
