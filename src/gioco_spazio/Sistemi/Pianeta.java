/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio.Sistemi;

import gioco_spazio.Strutture.Struttura;
import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class Pianeta {
    
    private String nome;
    private int dimensione;
    private int spazioDisponibile;
    private int posizione;
    private ArrayList<Struttura> strutture;
    private ArrayList<Difese> difese;
    private ArrayList<Navi> navi;
    //private int abitanti;
    private int riservaMetallo;
    private int riservaCristallo;
    private int riservaIdrogeno;
    private int depositoMetallo;
    private int depositoCristallo;
    private int depositoIdrogeno;
    //private int crediti;

    public Pianeta(String nome, int dimensione, int spazioDisponibile, int posizione, ArrayList<Struttura> strutture, ArrayList<Difese> difese, ArrayList<Navi> navi, int riservaMetallo, int riservaCristallo, int riservaIdrogeno) {
        this.nome = nome;
        this.dimensione = dimensione;
        this.spazioDisponibile = spazioDisponibile;
        this.posizione = posizione;
        this.strutture = strutture;
        this.difese = difese;
        this.navi = navi;
        this.riservaMetallo = 10000;
        this.riservaCristallo = 10000;
        this.riservaIdrogeno = 10000;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDimensione() {
        return dimensione;
    }

    public void setDimensione(int dimensione) {
        this.dimensione = dimensione;
    }

    public int getSpazioDisponibile() {
        return spazioDisponibile;
    }

    public void setSpazioDisponibile(int spazioDisponibile) {
        this.spazioDisponibile = spazioDisponibile;
    }

    public int getPosizione() {
        return posizione;
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }

    public ArrayList<Struttura> getStrutture() {
        return strutture;
    }

    public void setStrutture(ArrayList<Struttura> strutture) {
        this.strutture = strutture;
    }

    public ArrayList<Difese> getDifese() {
        return difese;
    }

    public void setDifese(ArrayList<Difese> difese) {
        this.difese = difese;
    }

    public ArrayList<Navi> getNavi() {
        return navi;
    }

    public void setNavi(ArrayList<Navi> navi) {
        this.navi = navi;
    }

    public int getRiservaMetallo() {
        return riservaMetallo;
    }

    public void setRiservaMetallo(int riservaMetallo) {
        this.riservaMetallo = riservaMetallo;
    }

    public int getRiservaCristallo() {
        return riservaCristallo;
    }

    public void setRiservaCristallo(int riservaCristallo) {
        this.riservaCristallo = riservaCristallo;
    }

    public int getRiservaIdrogeno() {
        return riservaIdrogeno;
    }

    public void setRiservaIdrogeno(int riservaIdrogeno) {
        this.riservaIdrogeno = riservaIdrogeno;
    }

    public int getDepositoMetallo() {
        return depositoMetallo;
    }

    public void setDepositoMetallo(int depositoMetallo) {
        this.depositoMetallo = depositoMetallo;
    }

    public int getDepositoCristallo() {
        return depositoCristallo;
    }

    public void setDepositoCristallo(int depositoCristallo) {
        this.depositoCristallo = depositoCristallo;
    }

    public int getDepositoIdrogeno() {
        return depositoIdrogeno;
    }

    public void setDepositoIdrogeno(int depositoIdrogeno) {
        this.depositoIdrogeno = depositoIdrogeno;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void potenziaDepositoMetallo(){
        if(checkCosto){
            
        }
        
        richiama funzione level uop della struttura
    }
    
    public void potenziaDepositoCristallo(){
        
    }
    
    public void potenziaDepositoIdrogeno(){
        
    }
    
}
pianeti adibiti = ricerca ingengeristica, bioingegneria (hanno la rete di ricerca);
fascia esterna = meteoriti, nebulosa, 
            trovi= sfera dyson, base aliena ,base pirata
