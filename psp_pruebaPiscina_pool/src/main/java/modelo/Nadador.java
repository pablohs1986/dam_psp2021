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
public class Nadador extends Thread {
    
    private String nombre;
    private int tiempoLargo;

    public Nadador(String nombre, int tiempoLargo) {
        this.nombre = nombre;
        this.tiempoLargo = tiempoLargo;
    }
    
        @Override
    public void run() {
        try {
            System.out.println(this.nombre + " ENTRA y va a hacer su largo.");
            Thread.sleep(tiempoLargo);
            System.out.println(this.nombre + " SALE con un tiempo de " + tiempoLargo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Nadador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
