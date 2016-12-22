/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio.Sistemi;

import gioco_spazio.Navi.Nave;
import gioco_spazio.Difese.Difesa;
import gioco_spazio.Strutture.Centrale_Solare;
import gioco_spazio.Strutture.Deposito;
import gioco_spazio.Strutture.Miniera;
import gioco_spazio.Strutture.Struttura;

import gioco_spazio.Strutture.Strutture_Pianeta;
import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class Pianeta {
    
    private String nome;
    //private int dimensione; ( dal quale calcolo gli spazi?)
    private int spazioDisponibile;
    private int spazioUtilizzato;
    private int posizione;
    private int temperatura;
    //private Strutture_Pianeta strutturePianeta = new Strutture_Pianeta();
    //private ArrayList<Miniera> miniere = new ArrayList<Miniera>();
    //private Centrale_Solare centraleSolare = new Centrale_Solare();
    //private ArrayList<Deposito> depositi = new ArrayList<Deposito>();
    private ArrayList<Struttura> strutture = new ArrayList<Struttura>();
    private ArrayList<Difesa> difese = new ArrayList<Difesa>();
    private ArrayList<Nave> navi = new ArrayList<Nave>();
    //private int abitanti;
    private double riservaMetallo;//attuale 
    private double riservaCristallo;
    private double riservaIdrogeno;
    private double depositoMetallo;//max
    private double depositoCristallo;
    private double depositoIdrogeno;
    private double energiaProdotta;
    //private int crediti;

    public Pianeta(String nome, int dimensione, int spazioDisponibile, int posizione, int riservaMetallo, int riservaCristallo, int riservaIdrogeno) {
        this.nome = nome;
        //this.dimensione = dimensione;
        this.spazioDisponibile = spazioDisponibile;
        this.posizione = posizione;        
        this.riservaMetallo = 10000;
        this.riservaCristallo = 10000;
        this.riservaIdrogeno = 10000;
        
    }
    
    public void energiaProdotta(Pianeta p) {
        //somma energia prodotta centrale  solare, satelliti e centrale a fusione
        for (Struttura s : p.getStrutture()) {
        if (s.getNomeStruttura().equals("Centrale Solare")) {
            Centrale_Solare cs = (Centrale_Solare) s;
            this.energiaProdotta = cs.getProdottoTotale();
            break;            
        }        
    }
    }
    
    public void riempiRiserva(double valore, String nome) {
        if (nome.equals("Miniera di Ferro")) {
            riservaMetallo += valore;
            if (riservaMetallo > depositoMetallo) {
                riservaMetallo = depositoMetallo;
            }
        }
        
        if (nome.equals("Miniera di Cristallo")) {
            riservaCristallo += valore;
            if (riservaCristallo > depositoCristallo) {
                riservaCristallo = depositoCristallo;
            }
        }
        
        if (nome.equals("Fabbrica di Idrogeno")) {
            riservaIdrogeno += valore;
            if (riservaIdrogeno > depositoIdrogeno) {
                riservaIdrogeno = depositoIdrogeno;
            }
        }
    }
    
    public void aggiornaDepositi(Pianeta p) {
        for (Struttura s : p.getStrutture()) {
        if (s.getNomeStruttura().equals("Deposito di Ferro")) {
            Deposito d = (Deposito) s;
            depositoMetallo = d.getCapienzaDepositofinale();            
        }
        
        if (nome.equals("Deposito di Cristallo")) {
            Deposito d = (Deposito) s;
            depositoCristallo = d.getCapienzaDepositofinale();    
        }
        
        if (nome.equals("Deposito di Idrogeno")) {
            Deposito d = (Deposito) s;
            depositoIdrogeno = d.getCapienzaDepositofinale(); 
        }
        }
    }
    
    public void creaMinieraMetallo() {
        Miniera m = new Miniera();        
        m.setNomeStruttura("Miniera di Metallo");
        m.setFattoreProduzione(165 + 30 + (5 * m.getLivelloStruttura()));//aggiungi
        m.setProduzioneBase(165);
        m.setFattoreconsumo(2.27);
        m.setConsumo(11);
        m.setCostoCristallo(posizione);
        m.setCostoIdrogeno(posizione);
        m.setCostoMetallo(posizione);
        
        strutture.add(m);
    }
    
    public void creaMinieraCristallo() {
        Miniera m = new Miniera();        
        m.setNomeStruttura("Miniera di Cristallo");
        m.setFattoreProduzione(110 + 20 + (5 * m.getLivelloStruttura()));
        m.setProduzioneBase(110);
        m.setFattoreconsumo(2.27);
        m.setConsumo(11);
        m.setCostoCristallo(48);
        m.setCostoIdrogeno(24);
        m.setCostoMetallo(0);
        
        strutture.add(m);
    }
    
    public void creaFabbricaIdrogeno() {
        Miniera m = new Miniera();        
        m.setNomeStruttura("Fabbrica di Idrogeno");
        m.setFattoreProduzione(65 + 10 + (5 * m.getLivelloStruttura()));
        m.setProduzioneBase(65);
        m.setFattoreconsumo(2.27);
        m.setConsumo(22);
        m.setCostoCristallo(48);
        m.setCostoIdrogeno(24);
        m.setCostoMetallo(0);
        
        strutture.add(m);
    }
    
    public void creaCentraleSolare() {
        Miniera m = new Miniera();        
        m.setNomeStruttura("Centrale Solare");
        m.setFattoreProduzione(22 + 4 + m.getLivelloStruttura());
        m.setProduzioneBase(22);        
        strutture.add(m);
    }
    
    public void creaDepositoMetallo() {
        Deposito d = new Deposito();
        strutture.add(d);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    /*public int getDimensione() {
        return dimensione;
    }

    public void setDimensione(int dimensione) {
        this.dimensione = dimensione;
    }*/
    public int getSpazioDisponibile() {
        return spazioDisponibile;
    }
    
    public void setSpazioDisponibile(int spazioDisponibile) {
        this.spazioDisponibile = spazioDisponibile;
    }
    
    public int getSpazioUtilizzato() {
        return spazioUtilizzato;
    }
    
    public void setSpazioUtilizzato(int spazioUtilizzato) {
        this.spazioUtilizzato = spazioUtilizzato;
    }    
    
    public int getPosizione() {
        return posizione;
    }
    
    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }
    
    public int getTemperatura() {
        return temperatura;
    }
    
    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }    
    
    public double getRiservaMetallo() {
        return riservaMetallo;
    }
    
    public void setRiservaMetallo(int riservaMetallo) {
        this.riservaMetallo = riservaMetallo;
    }
    
    public double getRiservaCristallo() {
        return riservaCristallo;
    }
    
    public void setRiservaCristallo(int riservaCristallo) {
        this.riservaCristallo = riservaCristallo;
    }
    
    public double getRiservaIdrogeno() {
        return riservaIdrogeno;
    }
    
    public void setRiservaIdrogeno(int riservaIdrogeno) {
        this.riservaIdrogeno = riservaIdrogeno;
    }
    
    public double getDepositoMetallo() {
        return depositoMetallo;
    }
    
    public void setDepositoMetallo(int depositoMetallo) {
        this.depositoMetallo = depositoMetallo;
    }
    
    public double getDepositoCristallo() {
        return depositoCristallo;
    }
    
    public void setDepositoCristallo(int depositoCristallo) {
        this.depositoCristallo = depositoCristallo;
    }
    
    public double getDepositoIdrogeno() {
        return depositoIdrogeno;
    }
    
    public void setDepositoIdrogeno(int depositoIdrogeno) {
        this.depositoIdrogeno = depositoIdrogeno;
    }

    public ArrayList<Struttura> getStrutture() {
        return strutture;
    }

    public void setStrutture(ArrayList<Struttura> strutture) {
        this.strutture = strutture;
    }

    public double getEnergiaProdotta() {
        return energiaProdotta;
    }

    public void setEnergiaProdotta(double energiaProdotta) {
        this.energiaProdotta = energiaProdotta;
    }
    
    
    
}
