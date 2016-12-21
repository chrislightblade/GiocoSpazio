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
public class Struttura {

    private String nomeStruttura;
    private int livelloStruttura;
    private int costoMetallo;
    private int costoCristallo;
    private int costoIdrogeno;
    private String tempoLevelUp;
    private double fattoreProduzione;
    private boolean levelUp = false;

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

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void levelUp(Pianeta p) {
        if (p.getRiservaMetallo() >= costoMetallo && p.getRiservaCristallo() >= costoCristallo && p.getRiservaIdrogeno() >= costoIdrogeno ) {//level up in tot tempo;
            levelUp = true;
            p.setRiservaCristallo(costoCristallo);
            p.setRiservaMetallo(costoMetallo);
            p.setRiservaIdrogeno(costoIdrogeno);
        }

    }

    public void setParametriPostLevelUp(double p1, double p2, double p3, double p4) {

        setCostoMetallo(costoMetallo * p1(parametro));
        setCostoCristallo(costoCristallo * p2(parametro));
        setCostoIdrogeno(costoIdrogeno * p3(parametro));
        setTempoLevelUp(tempoLevelUp * p4(parametro));
    }

    public static void aggiornaProduzioni() {

    }

    public static void checkCosto() {//--------> consegue aggiornamento struttura dopo x tempo
        //controlla se si ha abbastanza risorse per costruire una struttura
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
