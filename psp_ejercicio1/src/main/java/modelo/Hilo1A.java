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
public class Hilo1A extends Thread {
    String id;
    int tiempo;

    public Hilo1A(String id, int tiempo) {
        super(id);
        this.id = id;
        this.tiempo = tiempo;
    }
    
    public void run() {
        System.out.println("Hola, soy el hilo " + id);
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo1A.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Hilo " + id + " se ha despertado.");
    }
}
