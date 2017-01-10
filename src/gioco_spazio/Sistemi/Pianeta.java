/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio.Sistemi;

import gioco_spazio.Account_giocatore.Account_giocatore;
import gioco_spazio.Navi.Nave;
import gioco_spazio.Difese.Difesa;
import gioco_spazio.Strutture.Centrale_Fusione;
import gioco_spazio.Strutture.Centrale_Solare;
import gioco_spazio.Strutture.Deposito;
import gioco_spazio.Strutture.Miniera;
import gioco_spazio.Strutture.Struttura;

import gioco_spazio.Strutture.Strutture_Pianeta;
import gioco_spazio.Tecnologie.Ricerca;
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
    private String[] struttureCostruibili;
    //private int crediti;

    public Pianeta(String nome, int spazioDisponibile, int posizione) {
        this.nome = nome;
        //this.dimensione = dimensione;
        this.spazioDisponibile = spazioDisponibile;
        this.posizione = posizione;
        this.depositoMetallo = 10000;
        this.depositoCristallo = 10000;
        this.depositoIdrogeno = 10000;
        this.riservaMetallo = 5000;//attuale 
        this.riservaCristallo = 5000;
        this.riservaIdrogeno = 0;
        arrayString();

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
        if (nome.equals("Miniera di Metallo")) {
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

            if (s.getNomeStruttura().equals("Deposito di Cristallo")) {
                Deposito d = (Deposito) s;
                depositoCristallo = d.getCapienzaDepositofinale();
            }

            if (s.getNomeStruttura().equals("Deposito di Idrogeno")) {
                Deposito d = (Deposito) s;
                depositoIdrogeno = d.getCapienzaDepositofinale();
            }
        }
    }

    public boolean checkPrerequisiti(Struttura s, Account_giocatore ag) {
        int ok = 0;
        String nome[] = s.getRequisitiPerCostruirlo();
        int livello[] = s.getLivelloRequisitiPerCostruirlo();
        for (int i = 0; i < s.getRequisitiPerCostruirlo().length; i++) {
            for (Ricerca r : ag.getRicercheAttive()) {                
                if (r.getNome().equalsIgnoreCase(nome[i])) {
                    if(livello[i] == r.getLivello()){
                        ok++;
                    }
                }
            }
        }
        if(ok == nome.length){
            return true;
        }     
        return false;
    }

    public void creaMinieraMetallo(Account_giocatore ac) {
        Miniera m = new Miniera();
        m.setNomeStruttura("Miniera di Metallo");//(int) ((30 * level * Math.pow(1.1, level))) * (1 + 0.01* level plasmi)) * vel economia
        
        m.setConsumo((int) (10 * Math.pow(1.1, 1)));//
        m.setCostoMetallo((int) (60*Math.pow(1.5, 1 - 1)));
        m.setCostoCristallo((int) (15*Math.pow(1.5, 1 - 1)));
        m.setCostoIdrogeno(0);        
        m.setProdottoAllOra((30 * Math.pow(1.1, 1))/* * (1 + 0.01 * livelloplasmi)*/ * ac.getVelEconomia());        
        m.setTempoLevelUp((int)((60*Math.pow(1.5, 1 - 1)) + (15*Math.pow(1.5, 1 - 1))) / (2500 * Math.max(4 - 1 / 2, 1) /** (1 + (livello Fabbrica dei robot)) * (2 ^ (livello Fabbrica di naniti))*/));
        
        strutture.add(m);
    }
    
    

    public void creaMinieraCristallo(Account_giocatore ac) {
        Miniera m = new Miniera();
        m.setNomeStruttura("Miniera di Cristallo");////(int) ((20 * level * Math.pow(1.1, level))) * (1 + 0.0066* level plasmi)) * vel economia
        
        
       
        m.setConsumo((int) (10 * Math.pow(1.1, 1)));
        m.setCostoMetallo((int) (48*Math.pow(1.6, 1 - 1)));
        m.setCostoCristallo((int) (24*Math.pow(1.6, 1 - 1)));
        m.setCostoIdrogeno(0);        
        m.setProdottoAllOra(20 * Math.pow(1.1, 1)/* * (1 + 0.0066 * livelloplasmi)*/ * ac.getVelEconomia());
        m.setAttivo(true);
        m.setTempoLevelUp((int)((48*Math.pow(1.6, 1 - 1)) + (24*Math.pow(1.6, 1 - 1))) / (2500 * Math.max(4 - 1 / 2, 1) /** (1 + (livello Fabbrica dei robot)) * (2 ^ (livello Fabbrica di naniti))*/));
        
        strutture.add(m);
    }
    

    public void creaFabbricaIdrogeno(Account_giocatore ac) {
        Miniera m = new Miniera();
        m.setNomeStruttura("Fabbrica di Idrogeno");//(int) ((10 * level * Math.pow(1.1, level))) *(-0.004*temperatura + 1.44) * (1 + 0.01* level plasmi)) * vel economia
        
        m.setConsumo((int) (20 * Math.pow(1.1, 1)));
        m.setCostoMetallo((int) (225*Math.pow(1.5, 1 - 1)));
        m.setCostoCristallo((int) (75*Math.pow(1.5, 1 - 1)));
        m.setCostoIdrogeno(0);        
        m.setProdottoAllOra(10 * Math.pow(1.1, 1)/* * (1 + 0.0066 * livelloplasmi)*/ * ac.getVelEconomia());
        m.setAttivo(true);
        m.setTempoLevelUp((int)((225*Math.pow(1.5, 1 - 1)) + (75*Math.pow(1.5, 1 - 1))) / (2500 * Math.max(4 - 1 / 2, 1) /** (1 + (livello Fabbrica dei robot)) * (2 ^ (livello Fabbrica di naniti))*/));        
        
        strutture.add(m);
    }
    

    public void creaCentraleSolare() {
        Centrale_Solare cs = new Centrale_Solare();
        cs.setNomeStruttura("Centrale Solare");//20*level*Math.pow(1.1, level)
        
        cs.setProdotto((20*Math.pow(1.1, 1 - 1)));
        cs.setCostoMetallo((int) (75*Math.pow(1.5, 1 - 1)));
        cs.setCostoCristallo((int) (30*Math.pow(1.5, 1 - 1)));
        cs.setCostoIdrogeno(00);
        cs.setTempoLevelUp((int)((75*Math.pow(1.5, 1 - 1)) + (30*Math.pow(1.5, 1 - 1))) / (2500 * Math.max(4 - 1 / 2, 1) /** (1 + (livello Fabbrica dei robot)) * (2 ^ (livello Fabbrica di naniti))*/));
        cs.setParametroTempoLevelUp(1.5);
        
        strutture.add(cs);
    }

    public void creaDepositoMetallo() {
        Deposito d = new Deposito();
        d.setNomeStruttura("Deposito di Metallo");
        d.setCostoMetallo(((int)1000*Math.pow(2, 1 - 1)));
        d.setCostoCristallo(0);
        d.setCostoIdrogeno(0);
        d.setTempoLevelUp((int)(1000*Math.pow(2, 1 - 1)) / (2500 * Math.max(4 - 1 / 2, 1) /** (1 + (livello Fabbrica dei robot)) * (2 ^ (livello Fabbrica di naniti))*/));
                
        strutture.add(d);
    }
    
    public void creaDepositoCristallo() {
        Deposito d = new Deposito();
        d.setNomeStruttura("Deposito di Cristallo");
        d.setCostoMetallo(((int)1000*Math.pow(2, 1 - 1)));
        d.setCostoCristallo(((int)500*Math.pow(2, 1 - 1)));
        d.setCostoIdrogeno(0);
        d.setTempoLevelUp((int)((1000*Math.pow(2, 1 - 1)) + (500*Math.pow(2, 1 - 1))) / (2500 * Math.max(4 - 1 / 2, 1) /** (1 + (livello Fabbrica dei robot)) * (2 ^ (livello Fabbrica di naniti))*/));
                
        strutture.add(d);
    }
    
    public void creaDepositoIdrogeno() {
        Deposito d = new Deposito();
        d.setNomeStruttura("Deposito di Idrogeno");
        d.setCostoMetallo(((int)1000*Math.pow(1.5, 1 - 1)));
        d.setCostoCristallo(((int)1000*Math.pow(1.5, 1 - 1)));
        d.setCostoIdrogeno(0);
        d.setTempoLevelUp((int)((1000*Math.pow(2, 1 - 1)) + (1000*Math.pow(2, 1 - 1))) / (2500 * Math.max(4 - 1 / 2, 1) /** (1 + (livello Fabbrica dei robot)) * (2 ^ (livello Fabbrica di naniti))*/));
        
        strutture.add(d);
    }
    
    public void creaCentraleFusione() {
        Centrale_Fusione cf = new Centrale_Fusione();
        cf.setNomeStruttura("Centrale a Fusione");
        cf.setTempoLevelUp((int)((900*Math.pow(1.8, 1 - 1)) + (360*Math.pow(1.8, 1 - 1))) / (2500 * Math.max(4 - 1 / 2, 1) /** (1 + (livello Fabbrica dei robot)) * (2 ^ (livello Fabbrica di naniti))*/));
        cf.setCostoMetallo((int) (900 * Math.pow(1.8, 1 - 1)));
        cf.setCostoCristallo((int) (360 * Math.pow(1.8, 1 - 1)));
        cf.setCostoIdrogeno((int) (180 * Math.pow(1.8, 1 - 1)));        
        cf.setConsumoDeuterio(((10*livello*1,1(livello))*velocità economia);
        strutture.add(cf);
    }
    
    
    
    
        /*
        "Deposito segreto"; nasconde un tot di risoerse alle razzie nemiche
        m.setTempoLevelUp(4 ore);
        m.setParametroTempoLevelUp(2);
        m.setCostoMetallo(0);
        devi avere 1000 di energia
        m.setCostoCristallo(50000);
        m.setCostoIdrogeno(100000);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(2);
        m.setParametroAumentoCostoIdrogeno(2);
    
        "Centro Spedizioni"; ?  ?  ?  struttura atta alla spedizione di navi nello spazio profondo e inesplorato
        m.setTempoLevelUp(4 ore);
        m.setParametroTempoLevelUp(2);
        m.setCostoMetallo(0);
        devi avere 1000 di energia
        m.setCostoCristallo(50000);
        m.setCostoIdrogeno(100000);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(2);
        m.setParametroAumentoCostoIdrogeno(2);
    
    
        "Fabbrica di Robot";
        m.setTempoLevelUp(02.30);
        m.setParametroTempoLevelUp(2);
        m.setCostoMetallo(400);
        m.setCostoCristallo(120);
        m.setCostoIdrogeno(200);
        m.setParametroAumentoCostoMetallo(2);
        m.setParametroAumentoCostoCristallo(2);
        m.setParametroAumentoCostoIdrogeno(2);
    
        "Fabbrica di Microbot";
        m.setTempoLevelUp();
        m.setParametroTempoLevelUp();
        m.setCostoMetallo(00);
        m.setCostoCristallo(00);
        m.setCostoIdrogeno(00);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);
    
        "Fabbrica di Nanobot";
        m.setTempoLevelUp(5 giorni);
        m.setParametroTempoLevelUp();
        m.setCostoMetallo(1000000);
        m.setCostoCristallo(500000);
        m.setCostoIdrogeno(100000);
        m.setParametroAumentoCostoMetallo(2);
        m.setParametroAumentoCostoCristallo(2);
        m.setParametroAumentoCostoIdrogeno(2);
        
        
    
        "Satellite Solare";
        m.setTempoLevelUp(09.36);
        m.setParametroTempoLevelUp();
        m.setCostoMetallo(0);
        m.setCostoCristallo(2000);
        m.setCostoIdrogeno(500);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);
    
        "Centro di Ricerca";
        m.setTempoLevelUp(02.52);
        m.setParametroTempoLevelUp(2);
        m.setCostoMetallo(200);
        m.setCostoCristallo(400);
        m.setCostoIdrogeno(200);
        m.setParametroAumentoCostoMetallo(2);
        m.setParametroAumentoCostoCristallo(2);
        m.setParametroAumentoCostoIdrogeno(2);
    
        "SpazioPorto";
        m.setTempoLevelUp(02.52);
        m.setParametroTempoLevelUp(2);
        m.setCostoMetallo(400);
        m.setCostoCristallo(120);
        m.setCostoIdrogeno(200);
        m.setParametroAumentoCostoMetallo(2);
        m.setParametroAumentoCostoCristallo(2);
        m.setParametroAumentoCostoIdrogeno(2);
    
        "Portale Spaziale";
        m.setTempoLevelUp(20 giorni);
        m.setParametroTempoLevelUp(2);
        m.setCostoMetallo(2000000);
        m.setCostoCristallo(4000000);
        m.setCostoIdrogeno(2000000);
        m.setParametroAumentoCostoMetallo(2);
        m.setParametroAumentoCostoCristallo(2);
        m.setParametroAumentoCostoIdrogeno(2);
    
        "Luna";
        m.setTempoLevelUp();
        m.setParametroTempoLevelUp();
        m.setCostoMetallo(00);
        m.setCostoCristallo(00);
        m.setCostoIdrogeno(00);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);
    
        "TerraFormer";
        m.setTempoLevelUp(4 ore);
        m.setParametroTempoLevelUp(2);
        m.setCostoMetallo(0);
        devi avere 1000 di energia
        m.setCostoCristallo(50000);
        m.setCostoIdrogeno(100000);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(2);
        m.setParametroAumentoCostoIdrogeno(2);
    
        "MegaHangar"; protegge la flotta da attacchi nemici, esponendo solo le risorse planetarie
        m.setTempoLevelUp(4 ore);
        m.setParametroTempoLevelUp(2);
        m.setCostoMetallo(0);
        devi avere 1000 di energia
        m.setCostoCristallo(50000);
        m.setCostoIdrogeno(100000);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(2);
        m.setParametroAumentoCostoIdrogeno(2);
    
        "Riparatore"; estensione dello spazio porto, consente di riparare le unità danneggiate
        m.setTempoLevelUp(4 ore);
        m.setParametroTempoLevelUp(2);
        m.setCostoMetallo(0);
        devi avere 1000 di energia
        m.setCostoCristallo(50000);
        m.setCostoIdrogeno(100000);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(2);
        m.setParametroAumentoCostoIdrogeno(2);*/
    

    private void arrayString() {
        this.struttureCostruibili = new String[20];
        struttureCostruibili[0] = "Miniera di Metallo";
        struttureCostruibili[1] = "Miniera di Cristallo";
        struttureCostruibili[2] = "Fabbrica di Idrogeno";
        struttureCostruibili[3] = "Deposito di Metallo";
        struttureCostruibili[4] = "Deposito di Cristallo";
        struttureCostruibili[5] = "Deposito di Idrogeno";
        struttureCostruibili[6] = "Centrale Solare";
        struttureCostruibili[7] = "Fabbrica di Robot";
        struttureCostruibili[8] = "Fabbrica di Microbot";
        struttureCostruibili[9] = "Fabbrica di Nanobot";
        struttureCostruibili[10] = "Centrale Solare";
        struttureCostruibili[11] = "Centrale a Fusione";
        struttureCostruibili[12] = "Satellite Solare";
        struttureCostruibili[13] = "Centro di Ricerca";
        struttureCostruibili[14] = "SpazioPorto";
        struttureCostruibili[15] = "Portale Spaziale";
        struttureCostruibili[16] = "Luna";
        struttureCostruibili[17] = "TerraFormer";
        struttureCostruibili[18] = "";
        struttureCostruibili[19] = "";
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public ArrayList<Struttura> getStrutture() {
        return strutture;
    }

    public void setStrutture(ArrayList<Struttura> strutture) {
        this.strutture = strutture;
    }

    public ArrayList<Difesa> getDifese() {
        return difese;
    }

    public void setDifese(ArrayList<Difesa> difese) {
        this.difese = difese;
    }

    public ArrayList<Nave> getNavi() {
        return navi;
    }

    public void setNavi(ArrayList<Nave> navi) {
        this.navi = navi;
    }

    public double getRiservaMetallo() {
        return riservaMetallo;
    }

    public void setRiservaMetallo(double riservaMetallo) {
        this.riservaMetallo = riservaMetallo;
    }

    public double getRiservaCristallo() {
        return riservaCristallo;
    }

    public void setRiservaCristallo(double riservaCristallo) {
        this.riservaCristallo = riservaCristallo;
    }

    public double getRiservaIdrogeno() {
        return riservaIdrogeno;
    }

    public void setRiservaIdrogeno(double riservaIdrogeno) {
        this.riservaIdrogeno = riservaIdrogeno;
    }

    public double getDepositoMetallo() {
        return depositoMetallo;
    }

    public void setDepositoMetallo(double depositoMetallo) {
        this.depositoMetallo = depositoMetallo;
    }

    public double getDepositoCristallo() {
        return depositoCristallo;
    }

    public void setDepositoCristallo(double depositoCristallo) {
        this.depositoCristallo = depositoCristallo;
    }

    public double getDepositoIdrogeno() {
        return depositoIdrogeno;
    }

    public void setDepositoIdrogeno(double depositoIdrogeno) {
        this.depositoIdrogeno = depositoIdrogeno;
    }

    public double getEnergiaProdotta() {
        return energiaProdotta;
    }

    public void setEnergiaProdotta(double energiaProdotta) {
        this.energiaProdotta = energiaProdotta;
    }
    
    

}
