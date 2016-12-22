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
 * @author tss
 */
public class Miniera extends Struttura{

    /*public Miniera() {
        setNomeStruttura("Miniera di Metallo");
        setLivelloStruttura(1);
        setCostoMetallo(costoMetallo);
        setCostoCristallo(costoCristallo);
        setCostoIdrogeno(costoIdrogeno);
        setTempoLevelUp(tempoLevelUp);
        this.fattoreProduzione = 0;//per aggiornare la produzione post levelUp        
        setValoreProdotto(valoreProdotto);//al secondo
        
    }*/
    
    private boolean attivo = false;
    private double fattoreProduzione = 0;//per aggiornare la produzione post levelUp    
    private double prodottoAlSecondo = 0;//al secondo  
    private Date oldDate = null;
    private double bonusProduzione = 0;
    private double consumo = 0;
    private double fattoreconsumo = 0;
    private double produzioneBase = 0; 
    
    public void aggiornaProduzioni(Pianeta p) {
        Date data = new Date();
        //String Data = DateFunction.converti(data);
        int tempo = Utility.cambioInSecondi(oldDate , data);
        double prodotto = prodottoAlSecondo * tempo;
        if(bonusProduzione != 0){
            prodotto += (prodotto * bonusProduzione)/100;
        }
        p.riempiRiserva(prodotto, nomeStruttura);        
        oldDate = data;
        //if(tempoScaduto()){
        //    aggiornaProduzioniPostLevelUp();//da mettere in un aggiorna totale
        //}
    }    
        
    public void aggiornaProduzioniPostLevelUp(){
        setParametriPostLevelUp();
        prodottoAlSecondo *= fattoreProduzione;
    }  

    public double getFattoreProduzione() {
        return fattoreProduzione;
    }

    public void setFattoreProduzione(double fattoreProduzione) {
        this.fattoreProduzione = fattoreProduzione;
    }

    public double getProdottoAlSecondo() {
        return prodottoAlSecondo;
    }

    public void setProdottoAlSecondo(int prodottoAlSecondo) {
        this.prodottoAlSecondo = prodottoAlSecondo;
    }

    public Date getOldDate() {
        return oldDate;
    }

    public void setOldDate(Date oldDate) {
        this.oldDate = oldDate;
    }

    public double getBonusProduzione() {
        return bonusProduzione;
    }

    public void setBonusProduzione(int bonusProduzione) {
        this.bonusProduzione = bonusProduzione;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public double getFattoreconsumo() {
        return fattoreconsumo;
    }

    public void setFattoreconsumo(double fattoreconsumo) {
        this.fattoreconsumo = fattoreconsumo;
    }

    public String getNomeStruttura() {
        return nomeStruttura;
    }

    public void setNomeStruttura(String nomeStruttura) {
        this.nomeStruttura = nomeStruttura;
    }

    public double getProduzioneBase() {
        return produzioneBase;
    }

    public void setProduzioneBase(double produzioneBase) {
        this.produzioneBase = produzioneBase;
    }
    
    
}
