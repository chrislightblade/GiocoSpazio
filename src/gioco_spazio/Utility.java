/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_spazio;

import gioco_spazio.Sistemi.Pianeta;
import gioco_spazio.Strutture.Struttura;
import java.util.ArrayList;
import java.util.Date;
import util.DateFunction;

/**
 *
 * @author tss
 */
public class Utility {

    public class Box<T> implements Comparable<T> {

        private T object;

        public Box(T object) {
            this.object = object;
        }

        public T getObject() {
            return object;
        }

        public void setObject(T object) {
            this.object = object;
        }

        @Override
        public String toString() {
            return object.toString();
        }

        @Override
        public int compareTo(T o) {
            return this.object.getClass().toString().compareTo(o.getClass().toString());
        }

    }

    public static boolean checkCosto(Pianeta p, String nome) {//--------> consegue aggiornamento struttura dopo x tempo
        //controlla se si ha abbastanza risorse per costruire una struttura
        for (Struttura s : p.getStrutture()) {
            if (nome.equals(s.getNomeStruttura())) {
                if (p.getRiservaMetallo() >= s.getCostoMetallo() && p.getRiservaCristallo() >= s.getCostoCristallo() && p.getRiservaIdrogeno() >= s.getCostoIdrogeno()) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int cambioInSecondi(Date data1, Date data2) {
        int secondiTot = 0;
        secondiTot += (data2.getDay() - data1.getDay()) * 84600;
        secondiTot += (DateFunction.giorniInMese(data2.getMonth()) - DateFunction.giorniInMese(data1.getMonth())) * 84600;
        secondiTot += data2.getSeconds() - data1.getSeconds();
        secondiTot += (data2.getMinutes() - data1.getMinutes()) * 60;
        secondiTot += (data2.getHours() - data1.getHours()) * 3600;

        return secondiTot;
    }

    /*public static int cercaInArrayList(ArrayList<Object> list, String nome) {
        int index = 0;
        for (Object object : list) {
            if(object.toString().equals(nome)){
                return index;
            }
            index++;
        }
        return -1;
    }*/
}
