/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio.Strutture;

/**
 *
 * @author tss
 */
public class Strutture_Pianeta implements Comparable<Strutture_Pianeta>{
    
    private Strutture_Pianeta object;

    public Strutture_Pianeta(Strutture_Pianeta object) {
        this.object = object;
    }  
    
    public Strutture_Pianeta getObject() {
        return object;
    }

    public void setObject(Strutture_Pianeta object) {
        this.object = object;
    }
    
    @Override
    public String toString(){
        return object.toString();
    }

    @Override
    public int compareTo(Strutture_Pianeta o) {
        return this.object.getClass().toString().compareTo(o.getClass().toString());
    }
    
}