/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio.Strutture;

import gioco_spazio.Sistemi.Pianeta;
import gioco_spazio.Utility;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Centrale_Solare extends Struttura{//contare solo il max prodotto e poi sottrarre per i cosnumi delle industrie
    
    private double fattoreProduzione;//per aggiornare la produzione post levelUp    
    private double prodotto;//al secondo      
    private double bonusProduzione;
    private double prodottoTotale;
       
    public void aggiornaProduzioniPostLevelUp(){
        setParametriPostLevelUp();
        this.prodotto *= fattoreProduzione;        
    }  
    
    public void aggiornaProduzione(){
        if(prodottoTotale !=(bonusProduzione * prodotto))
        this.prodottoTotale = prodotto * fattoreProduzione;
    }

    public double getFattoreProduzione() {
        return fattoreProduzione;
    }

    public void setFattoreProduzione(double fattoreProduzione) {
        this.fattoreProduzione = fattoreProduzione;
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
