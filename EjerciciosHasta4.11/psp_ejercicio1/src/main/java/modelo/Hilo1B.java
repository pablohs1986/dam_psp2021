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
 * @author pablo
 */
public class Hilo1B implements Runnable {
    String id;
    int tiempo;
    Thread t;

    public Hilo1B(String id, int tiempo, Thread t) {
        this.id = id;
        this.tiempo = tiempo;
        this.t = t; // Ojo
    }
    
    
    @Override
    public void run() {
        System.out.println("Hola, soy el hilo " + id);
        t = new Thread(this); // Ojo
        
        try {
            t.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo1B.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("El hilo " + id + " se ha despertado.");
    }
    
}
