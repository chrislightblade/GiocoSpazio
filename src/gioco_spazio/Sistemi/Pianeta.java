/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio.Sistemi;

import gioco_spazio.Account_giocatore.Account_giocatore;
import gioco_spazio.Navi.Nave;
import gioco_spazio.Difese.Difesa;
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

    public void creaMinieraMetallo() {
        Miniera m = new Miniera();
        m.setNomeStruttura("Miniera di Metallo");
        m.setFattoreProduzione(1.18);//aggiungi
        m.setProduzioneBase(165);
        m.setFattoreconsumo(1.3);
        m.setConsumo(11);
        m.setCostoMetallo(60);
        m.setCostoCristallo(15);
        m.setCostoIdrogeno(0);        
        m.setProdottoAlSecondo(165);        
        m.setTempoLevelUp(00.21);
        m.setParametroTempoLevelUp(1.5);
        m.setParametroAumentoCostoMetallo(1.5);
        m.setParametroAumentoCostoCristallo(1.5);
        m.setParametroAumentoCostoIdrogeno(0);
        
        strutture.add(m);
    }

    public void creaMinieraCristallo() {
        Miniera m = new Miniera();
        m.setNomeStruttura("Miniera di Cristallo");
        m.setFattoreProduzione(1.16);//0.47
        m.setProduzioneBase(110);
        m.setFattoreconsumo(1.3);
        m.setConsumo(11);
        m.setCostoMetallo(48);
        m.setCostoCristallo(24);
        m.setCostoIdrogeno(0);        
        m.setProdottoAlSecondo(110);
        m.setAttivo(true);
        m.setTempoLevelUp(00.20);
        m.setParametroTempoLevelUp(1.5);
        m.setParametroAumentoCostoMetallo(0.62);
        m.setParametroAumentoCostoCristallo(0.62);
        m.setParametroAumentoCostoIdrogeno(0);
        strutture.add(m);
    }

    public void creaFabbricaIdrogeno() {
        Miniera m = new Miniera();
        m.setNomeStruttura("Fabbrica di Idrogeno");
        m.setFattoreProduzione(1.14);
        m.setProduzioneBase(65);
        m.setFattoreconsumo(1.3);
        m.setConsumo(22);
        m.setCostoMetallo(0);
        m.setCostoCristallo(48);
        m.setCostoIdrogeno(24);        
        m.setProdottoAlSecondo(65);
        m.setAttivo(true);
        m.setTempoLevelUp(1.26);
        m.setParametroTempoLevelUp(1.5);
        m.setParametroAumentoCostoMetallo(1.5);
        m.setParametroAumentoCostoCristallo(1.5);
        m.setParametroAumentoCostoIdrogeno(0);
        strutture.add(m);
    }

    public void creaCentraleSolare() {
        Miniera m = new Miniera();
        m.setNomeStruttura("Centrale Solare");
        m.setFattoreProduzione(22 + 4 + m.getLivelloStruttura());
        m.setProduzioneBase(22);
        m.setCostoMetallo(00);
        m.setCostoCristallo(00);
        m.setCostoIdrogeno(00);
        m.setTempoLevelUp();
        m.setParametroTempoLevelUp();
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);
        strutture.add(m);
    }

    public void creaDepositoMetallo() {
        Deposito d = new Deposito();
        d.setNomeStruttura("Deposito di Metallo");
        d.setCostoMetallo(1000);
        d.setCostoCristallo(0);
        d.setCostoIdrogeno(0);
        d.setTempoLevelUp(05.50);
        d.setParametroTempoLevelUp(2);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);
        strutture.add(d);
    }
    
    public void creaDepositoCristallo() {
        Deposito d = new Deposito();
        d.setNomeStruttura("Deposito di Cristallo");
        d.setCostoMetallo(1000);
        d.setCostoCristallo(500);
        d.setCostoIdrogeno(0);
        d.setTempoLevelUp(07.10);
        d.setParametroTempoLevelUp(2);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);
        strutture.add(d);
    }
    
    public void creaDepositoIdrogeno() {
        Deposito d = new Deposito();
        d.setNomeStruttura("Deposito di Idrogeno");
        d.setCostoMetallo(1000);
        d.setCostoCristallo(1000);
        d.setCostoIdrogeno(0);
        d.setTempoLevelUp(09.40);
        d.setParametroTempoLevelUp(2);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);
        strutture.add(d);
    }
    
        /*"Fabbrica di Robot";
        m.setTempoLevelUp(02.30);
        m.setParametroTempoLevelUp();
        m.setCostoMetallo(400);
        m.setCostoCristallo(120);
        m.setCostoIdrogeno(200);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);
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
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);
        "Centrale Solare";
        m.setTempoLevelUp(30);
        m.setParametroTempoLevelUp();
        m.setCostoMetallo(75);
        m.setCostoCristallo(30);
        m.setCostoIdrogeno(0);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);
        "Centrale a Fusione";
        m.setTempoLevelUp(06.00);
        m.setParametroTempoLevelUp();
        m.setCostoMetallo(900);
        m.setCostoCristallo(360);
        m.setCostoIdrogeno(180);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);
        "Satellite Solare";
        m.setTempoLevelUp();
        m.setParametroTempoLevelUp();
        m.setCostoMetallo(00);
        m.setCostoCristallo(00);
        m.setCostoIdrogeno(00);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);
        "Centro di Ricerca";
        m.setTempoLevelUp(02.50);
        m.setParametroTempoLevelUp();
        m.setCostoMetallo(200);
        m.setCostoCristallo(400);
        m.setCostoIdrogeno(200);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);
        "SpazioPorto";
        m.setTempoLevelUp();
        m.setParametroTempoLevelUp();
        m.setCostoMetallo(00);
        m.setCostoCristallo(00);
        m.setCostoIdrogeno(00);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);
        "Portale Spaziale";
        m.setTempoLevelUp(02.50);
        m.setParametroTempoLevelUp();
        m.setCostoMetallo(400);
        m.setCostoCristallo(200);
        m.setCostoIdrogeno(100);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);
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
        m.setTempoLevelUp();
        m.setParametroTempoLevelUp();
        m.setCostoMetallo(0);
        devi avere 1000 di energia
        m.setCostoCristallo(50000);
        m.setCostoIdrogeno(100000);
        m.setParametroAumentoCostoMetallo(0);
        m.setParametroAumentoCostoCristallo(0);
        m.setParametroAumentoCostoIdrogeno(0);*/
    

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
