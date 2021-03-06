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
public class Centrale_Solare extends Struttura {//contare solo il max prodotto e poi sottrarre per i cosnumi delle industrie
    
    private double prodotto;//al secondo      
    private double bonusProduzione;
    private double prodottoTotale;

    
    public void calcolaCostoStruttura() {       
            setCostoMetallo((int) (75 * Math.pow(1.5, getLivelloStruttura() - 1)));
            setCostoCristallo((int) (30 * Math.pow(1.5, getLivelloStruttura() - 1)));
            setCostoIdrogeno(0);
        
    }    

    public void calcolaProduzioneOraria(Pianeta p) {//migliorare espressione livello tech energetica

        this.prodotto = (int) ((20 * getLivelloStruttura() * Math.pow(1.1, getLivelloStruttura()) * Math.pow(1,05 + livello della tecnologia energetica * 0,01, getLivelloStruttura())));
    }

    public void aggiornaProduzioniPostLevelUp(Pianeta p, Account_giocatore ac){
        setParametriPostLevelUp();
        calcolaCostoStruttura();
        calcolaProduzioneOraria(p);         
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

}
