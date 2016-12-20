/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio.Sistemi;

import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class Sistema {
    
    ArrayList<Pianeta> pianeti;
    fascia esterna = meteoriti, nebulosa, 
            trovi= sfera dyson, base aliena ,base pirata

    public Sistema() {
        int valore = (int) Math.floor(Math.random() * 10) + 1;
        this.pianeti = new ArrayList<Pianeta>();
        for (int i = 0; i < 10; i++) {
            
        }
    }
    
    
    
    
    public void creaPianetaCasuale(){
        int spazi = 40 + (20 * posizione) + ((int) Math.floor(Math.random() * 10));
    }
    
    public void creaPianetaConTerraformare(){
        
    }
}
