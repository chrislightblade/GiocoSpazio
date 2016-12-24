/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio.Strutture;

import gioco_spazio.Sistemi.Pianeta;
import gioco_spazio.Utility;
import java.util.Date;
import util.DateFunction;

/**
 *
 * @author tss
 */
public class Struttura {

    String nomeStruttura = "";
    private int livelloStruttura = 0;
    private int costoMetallo = 0;
    private int costoCristallo = 0;
    private int costoIdrogeno = 0;
    private double parametroTempoLevelUp = 0;
    private int tempoLevelUp = 0;//oppure costruzione da zero
    private int parametroAumentoCostoMetallo = 0;
    private int parametroAumentoCostoCristallo = 0;
    private int parametroAumentoCostoIdrogeno = 0;
    private int parametroAumentoCostoTempo = 0;
    private String requisitiPerCostruirlo[];
    private int livelloRequisitiPerCostruirlo[];
    
    private boolean levelUp = false;//oppure fase di costruzione da zero, se in true lo sto costruendo la prima volta
    private Date dataInizioUp = null;//oppure data inizio costruzione da zero
    
    private boolean attivo = false;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void inizioLevelUp(Pianeta p) {
        //level up in tot tempo;
        if (Utility.checkCosto(p, nomeStruttura)) {
            //Date data = new Date();
            levelUp = true;
            p.setRiservaCristallo(-costoCristallo);
            p.setRiservaMetallo(-costoMetallo);
            p.setRiservaIdrogeno(-costoIdrogeno);
            dataInizioUp = new Date();
        }

    }

    /*public void setParametriPostLevelUp(Pianeta p, int index) {

        //levelUp = false;
        for (Struttura s : p.getStrutture().strutture) {
            if (s.getNomeStruttura().equals(nomeStruttura)) {
                setCostoMetallo(costoMetallo * parametroAumentoCostoMetallo);
                setCostoCristallo(costoCristallo * parametroAumentoCostoCristallo);
                setCostoIdrogeno(costoIdrogeno * parametroAumentoCostoIdrogeno);
                setTempoLevelUp(tempoLevelUp * parametroAumentoCostoTempo);
            }
        }        
    }*/
    public void setParametriPostLevelUp() {

        setCostoMetallo(costoMetallo * parametroAumentoCostoMetallo);
        setCostoCristallo(costoCristallo * parametroAumentoCostoCristallo);
        setCostoIdrogeno(costoIdrogeno * parametroAumentoCostoIdrogeno);
        setTempoLevelUp(tempoLevelUp * parametroAumentoCostoTempo);
        levelUp = false;
        dataInizioUp = null;
        livelloStruttura++;

    }

    public void tempoScaduto() {//verifica se la struttura ha finito di uppare, farlo ogni volta checckando se dataInizioUp != null;
        Date data = new Date();        
        int secondi = Utility.cambioInSecondi(dataInizioUp, data);
        if (secondi >= tempoLevelUp) {
            setAttivo(true);
            setParametriPostLevelUp();            
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

    public int getTempoLevelUp() {
        return tempoLevelUp;
    }

    public void setTempoLevelUp(int tempoLevelUp) {
        this.tempoLevelUp = tempoLevelUp;
    }

    public int getParametroAumentoCostoMetallo() {
        return parametroAumentoCostoMetallo;
    }

    public void setParametroAumentoCostoMetallo(int parametroAumentoCostoMetallo) {
        this.parametroAumentoCostoMetallo = parametroAumentoCostoMetallo;
    }

    public int getParametroAumentoCostoCristallo() {
        return parametroAumentoCostoCristallo;
    }

    public void setParametroAumentoCostoCristallo(int parametroAumentoCostoCristallo) {
        this.parametroAumentoCostoCristallo = parametroAumentoCostoCristallo;
    }

    public int getParametroAumentoCostoIdrogeno() {
        return parametroAumentoCostoIdrogeno;
    }

    public void setParametroAumentoCostoIdrogeno(int parametroAumentoCostoIdrogeno) {
        this.parametroAumentoCostoIdrogeno = parametroAumentoCostoIdrogeno;
    }

    public int getParametroAumentoCostoTempo() {
        return parametroAumentoCostoTempo;
    }

    public void setParametroAumentoCostoTempo(int parametroAumentoCostoTempo) {
        this.parametroAumentoCostoTempo = parametroAumentoCostoTempo;
    }

    
    
    /*public boolean isLevelUp() {
        return levelUp;
    }

    public void setLevelUp(boolean levelUp) {
        this.levelUp = levelUp;
    }

    public Date getDataInizioUp() {
        return dataInizioUp;
    }

    public void setDataInizioUp(Date dataInizioUp) {
        this.dataInizioUp = dataInizioUp;
    }*/

    public String[] getRequisitiPerCostruirlo() {
        return requisitiPerCostruirlo;
    }

    public void setRequisitiPerCostruirlo(String[] requisitiPerCostruirlo) {
        this.requisitiPerCostruirlo = requisitiPerCostruirlo;
    }

    public int[] getLivelloRequisitiPerCostruirlo() {
        return livelloRequisitiPerCostruirlo;
    }

    public void setLivelloRequisitiPerCostruirlo(int[] livelloRequisitiPerCostruirlo) {
        this.livelloRequisitiPerCostruirlo = livelloRequisitiPerCostruirlo;
    }

    public boolean isLevelUp() {
        return levelUp;
    }

    public void setLevelUp(boolean levelUp) {
        this.levelUp = levelUp;
    }

    public Date getDataInizioUp() {
        return dataInizioUp;
    }

    public void setDataInizioUp(Date dataInizioUp) {
        this.dataInizioUp = dataInizioUp;
    }

    public boolean getAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public double getParametroTempoLevelUp() {
        return parametroTempoLevelUp;
    }

    public void setParametroTempoLevelUp(double parametroTempoLevelUp) {
        this.parametroTempoLevelUp = parametroTempoLevelUp;
    }
    
    
}

