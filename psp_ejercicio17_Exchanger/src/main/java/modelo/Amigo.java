/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Amigo extends Thread {
    private String nombre;
    private Exchanger<String> cita;

    public Amigo(String nombre, Exchanger<String> cita) {
        this.nombre = nombre;
        this.cita = cita;
    }

    @Override
    public void run() {
        try {
            sleep((int) (10*Math.random()));
            System.out.println(this.nombre + " esperando...");
            String intercambio = cita.exchange("regalo de " + this.nombre); // Espera a un objeto del mismo tipo, en ese momento se hace el intercambio.
            System.out.println(this.nombre + ": " + intercambio);
        } catch (InterruptedException ex) {
            Logger.getLogger(Amigo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
