/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio.Strutture;

import gioco_spazio.Account_giocatore.Account_giocatore;
import gioco_spazio.Sistemi.Pianeta;
import gioco_spazio.Utility;
import java.util.ArrayList;
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
    
    
    //private double fattoreProduzione = 0;//per aggiornare la produzione post levelUp    
    private double prodottoAllOra = 0;//al secondo  
    private Date oldDate = new Date();
    //private double bonusProduzione = 0;
    private double consumo = 0;//20 * level * Math.pow(1.1, level)   
    
    public void aggiornaProduzioni(Pianeta p) {
        Date data = new Date();
        //String Data = DateFunction.converti(data);
        double tempo = Utility.cambioInSecondi(oldDate , data) ;
        double prodotto = (prodottoAllOra / 3600) * tempo;
        /*if(bonusProduzione != 0){
            prodotto += (prodotto * bonusProduzione)/100;
        }*/
        if(nomeStruttura == "Fabbrica di Deuterio"){
        int index = 0;
        for (Struttura struttura : p.getStrutture()) {
            if(struttura.getNomeStruttura().equals("Centrale a Fusione")){
                break;
            }
            index++;            
        }
        
        Centrale_Fusione cf = new Centrale_Fusione();
        
        if(cf.getLivelloStruttura() !=0){//della centrale a fusione
            prodotto -= ((cf.getConsumoDeuterio() / 3600) * tempo);
            p.riempiRiserva(prodotto, nomeStruttura);            
        } else {
            p.riempiRiserva(prodotto, nomeStruttura);
        }
        } else {
        p.riempiRiserva(prodotto, nomeStruttura);   
        }     
        oldDate = data;
        //if(tempoScaduto()){
        //    aggiornaProduzioniPostLevelUp();//da mettere in un aggiorna totale
        //}
    }    
    
    public void calcolaConsumoEnergia(){
        if (getNomeStruttura().equals("Miniera di Metallo")) {
            this.consumo = (int) 10 * getLivelloStruttura() * Math.pow(1.1, getLivelloStruttura());
        }

        if (getNomeStruttura().equals("Miniera di Cristallo")) {
            this.consumo = (int) 10 * getLivelloStruttura() * Math.pow(1.1, getLivelloStruttura());
        }

        if (getNomeStruttura().equals("Fabbrica di Idrogeno")) {
            this.consumo = (int) 20 * getLivelloStruttura() * Math.pow(1.1, getLivelloStruttura());
        }
    }
    
    public void calcolaProduzioneOraria(Pianeta p, Account_giocatore ac){
        if (getNomeStruttura().equals("Miniera di Metallo")) {
            this.prodottoAllOra = (int) ((30 * getLivelloStruttura() * Math.pow(1.1, getLivelloStruttura()))/* * (1 + 0.01 * livelloplasmi)*/) * ac.getVelEconomia();
        }

        if (getNomeStruttura().equals("Miniera di Cristallo")) {
            this.prodottoAllOra = (int) ((20 * getLivelloStruttura() * Math.pow(1.1, getLivelloStruttura()))/* * (1 + 0.0066 * livelloplasmi)*/) * ac.getVelEconomia();
        }

        if (getNomeStruttura().equals("Fabbrica di Idrogeno")) {
            this.prodottoAllOra = (int) ((10 * getLivelloStruttura() * Math.pow(1.1, getLivelloStruttura())) * (-0.004 * p.getTemperatura() + 1.44)/* * (1 + 0.0033 * livelloplasmi)*/) * ac.getVelEconomia();
        }        
    }
    
    public void calcolaCostoStruttura(){
        if (getNomeStruttura().equals("Miniera di Metallo")) {            
            setCostoMetallo((int) (60*Math.pow(1.5, getLivelloStruttura() - 1)));        
            setCostoCristallo((int) (15*Math.pow(1.5, getLivelloStruttura() - 1)));
            setCostoIdrogeno(0);           
        }

        if (getNomeStruttura().equals("Miniera di Cristallo")) {
            setCostoMetallo((int) (48*Math.pow(1.6, getLivelloStruttura() - 1)));        
            setCostoCristallo((int) (24*Math.pow(1.6, getLivelloStruttura() - 1)));
            setCostoIdrogeno(0);
        }

        if (getNomeStruttura().equals("Fabbrica di Idrogeno")) {
            setCostoMetallo((int) (225*Math.pow(1.5, getLivelloStruttura() - 1)));        
            setCostoCristallo((int) (75*Math.pow(1.5, getLivelloStruttura() - 1)));
            setCostoIdrogeno(0);
        }    
    }
        
    public void aggiornaProduzioniPostLevelUp(Pianeta p, Account_giocatore ac){
        setParametriPostLevelUp();
        calcolaCostoStruttura();
        calcolaProduzioneOraria(p, ac);
        calcolaConsumoEnergia();
        
    } 
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    

    public Date getOldDate() {
        return oldDate;
    }

    public void setOldDate(Date oldDate) {
        this.oldDate = oldDate;
    }

   

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    

    public String getNomeStruttura() {
        return nomeStruttura;
    }

    public void setNomeStruttura(String nomeStruttura) {
        this.nomeStruttura = nomeStruttura;
    }

    public double getProdottoAllOra() {
        return prodottoAllOra;
    }

    public void setProdottoAllOra(double prodottoAllOra) {
        this.prodottoAllOra = prodottoAllOra;
    }

   
    
    
}
