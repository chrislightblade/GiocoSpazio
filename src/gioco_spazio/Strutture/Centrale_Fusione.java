/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio.Strutture;

import gioco_spazio.Account_giocatore.Account_giocatore;
import gioco_spazio.Sistemi.Pianeta;
import gioco_spazio.Utility;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Centrale_Fusione extends Struttura {//contare solo il max prodotto e poi sottrarre per i cosnumi delle industrie
    
    private double prodotto;//al secondo      
    private double bonusProduzione;
    private double prodottoTotale;
    private int consumoDeuterio;//all'ora

    
    public void calcolaCostoStruttura() {        
            setCostoMetallo((int) (900 * Math.pow(1.8, getLivelloStruttura() - 1)));
            setCostoCristallo((int) (360 * Math.pow(1.8, getLivelloStruttura() - 1)));
            setCostoIdrogeno((int) (180 * Math.pow(1.8, getLivelloStruttura() - 1)));
        
    }
    
    
    public void calcolaConsumoDeuterio(Pianeta p, Account_giocatore ac){
        this.consumoDeuterio = (int) ((10 * getLivelloStruttura() * Math.pow(1.1, getLivelloStruttura())) * ac.getVelEconomia());
    }

    public void calcolaProduzioneOraria(Pianeta p) {//migliorare espressione livello tech energetica

        this.prodotto = (int) ((30 * getLivelloStruttura() * Math.pow(1.1, getLivelloStruttura()) * Math.pow(1,05 + livello della tecnologia energetica * 0,01, getLivelloStruttura())));
    }

    public void aggiornaProduzioniPostLevelUp(Pianeta p, Account_giocatore ac){
        setParametriPostLevelUp();
        calcolaCostoStruttura();
        calcolaProduzioneOraria(p);
        calcolaConsumoDeuterio(p, ac);
    } 
    
    public double getProdotto() {
        return prodotto;
    }

    public void setProdotto(double prodotto) {
        this.prodotto = prodotto;
    }

    public double getBonusProduzione() {
        return bonusProduzione;
    }

    public void setBonusProduzione(double bonusProduzione) {
        this.bonusProduzione = bonusProduzione;
    }

    public String getNomeStruttura() {
        return nomeStruttura;
    }

    public void setNomeStruttura(String nomeStruttura) {
        this.nomeStruttura = nomeStruttura;
    }

    public double getProdottoTotale() {
        return prodottoTotale;
    }

    public void setProdottoTotale(double prodottoTotale) {
        this.prodottoTotale = prodottoTotale;
    }

    public int getConsumoDeuterio() {
        return consumoDeuterio;
    }

    public void setConsumoDeuterio(int consumoDeuterio) {
        this.consumoDeuterio = consumoDeuterio;
    }

    
    
}
