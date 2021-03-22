/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Hilo extends Thread {
    private String nombreHilo;
    private int tiempo;

    public Hilo(String nombreHilo, int tiempo) {
        this.nombreHilo = nombreHilo;
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        System.out.println(nombreHilo + " se va a dormir un ratín de... " + tiempo + "mseg");
        try {
            this.sleep(tiempo); // Referencio a this
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombreHilo + " se ha despertado de la siesta ¬¬");
    }
    
}
