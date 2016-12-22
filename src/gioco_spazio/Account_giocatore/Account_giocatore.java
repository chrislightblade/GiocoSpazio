/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio.Account_giocatore;

import gioco_spazio.Sistemi.Pianeta;
import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class Account_giocatore {
    
    private String nomeGiocatore;
    private int cristalloTotale;
    private int metalloTotale;
    private int idrogenoTotale;
    //private int creditiTotale;
    private int numeroPianetiPosseduti;
    //private String ufficiali;
    ArrayList<Pianeta> pianetiPosseduti = new ArrayList<Pianeta>();
    
    /*public void costruisciStruttura(){
        check sul limite delle strutture, sullo spazio sul pianeta, 
                su risorse, sulle ricerche, sui bonus per il tempo costruzione e costi
                        calcola tempo in base a tempo base struttura e bonus sulla riduzione tempo
    }*/

    public String getNomeGiocatore() {
        return nomeGiocatore;
    }

    public void setNomeGiocatore(String nomeGiocatore) {
        this.nomeGiocatore = nomeGiocatore;
    }

    public int getCristalloTotale() {
        return cristalloTotale;
    }

    public void setCristalloTotale(int cristalloTotale) {
        this.cristalloTotale = cristalloTotale;
    }

    public int getMetalloTotale() {
        return metalloTotale;
    }

    public void setMetalloTotale(int metalloTotale) {
        this.metalloTotale = metalloTotale;
    }

    public int getIdrogenoTotale() {
        return idrogenoTotale;
    }

    public void setIdrogenoTotale(int idrogenoTotale) {
        this.idrogenoTotale = idrogenoTotale;
    }

    public int getNumeroPianetiPosseduti() {
        return numeroPianetiPosseduti;
    }

    public void setNumeroPianetiPosseduti(int numeroPianetiPosseduti) {
        this.numeroPianetiPosseduti = numeroPianetiPosseduti;
    }

    public ArrayList<Pianeta> getPianetiPosseduti() {
        return pianetiPosseduti;
    }

    public void setPianetiPosseduti(ArrayList<Pianeta> pianetiPosseduti) {
        this.pianetiPosseduti = pianetiPosseduti;
    }
    
    
}
