/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio.Strutture;

/**
 *
 * @author Administrator
 */
public class Deposito extends Struttura{
    
     
    private int capienzaDepositoBase = 10000;
    private int fattoreCrescita = 2;
    private int capienzaDepositofinale;

    /*public Deposito(int capienzaDeposito) {
        this.capienzaDeposito = capienzaDeposito;
        setNomeStruttura("Deposito Cristallo");
        setLivelloStruttura(1);
        setCostoMetallo(costoMetallo);
        setCostoCristallo(costoCristallo);
        setCostoIdrogeno(costoIdrogeno);
        setTempoLevelUp(tempoLevelUp);
    }   */
        
    public void potenziaDepositoMetallo(){
        setParametriPostLevelUp();
    }       

    public String getNomeStruttura() {
        return nomeStruttura;
    }

    public void setNomeStruttura(String nomeStruttura) {
        this.nomeStruttura = nomeStruttura;
    }

    public int getCapienzaDepositoBase() {
        return capienzaDepositoBase;
    }

    public void setCapienzaDepositoBase(int capienzaDepositoBase) {
        this.capienzaDepositoBase = capienzaDepositoBase;
    }

    public int getFattoreCrescita() {
        return fattoreCrescita;
    }

    public void setFattoreCrescita(int fattoreCrescita) {
        this.fattoreCrescita = fattoreCrescita;
    }

    public int getCapienzaDepositofinale() {
        return capienzaDepositofinale;
    }

    public void setCapienzaDepositofinale(int capienzaDepositofinale) {
        this.capienzaDepositofinale = capienzaDepositofinale;
    }
    
    
    
}
