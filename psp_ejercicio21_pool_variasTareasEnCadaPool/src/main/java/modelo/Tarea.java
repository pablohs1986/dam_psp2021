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
public class Tarea extends Thread {
    private String nombre;
    private int tiempoDormido;

    public Tarea(String nombre, int tiempoDormido) {
        this.nombre = nombre;
        this.tiempoDormido = tiempoDormido;
    }

    @Override
    public void run() {
        try {
            System.out.println("El hilo de la tarea " + this.nombre + " va a dormir durante " + tiempoDormido + " milisegundos.");
            Thread.sleep(tiempoDormido);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("El hilo de la tarea " + this.nombre + " ya ha dormido bastante, se despierta para finalizar.");
    }
    
    
}
