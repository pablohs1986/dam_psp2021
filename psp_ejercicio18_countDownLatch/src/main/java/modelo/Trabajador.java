/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Trabajador extends Thread {
    private String nombre;
    private CountDownLatch puntoDeEspera;

    public Trabajador(String nombre, CountDownLatch puntoDeEspera) {
        this.nombre = nombre;
        this.puntoDeEspera = puntoDeEspera;
    }

    @Override
    public void run() {
        try {
            this.puntoDeEspera.await();
            System.out.println(this.nombre + " esperando...");
        } catch (InterruptedException ex) {
            Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ejecutando " + nombre);
    }
    
    
}
