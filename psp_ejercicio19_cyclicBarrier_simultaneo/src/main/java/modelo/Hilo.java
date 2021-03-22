/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Hilo extends Thread {
    private String nombre;
    CyclicBarrier barreraInicio;
    CyclicBarrier barreraFin;

    public Hilo(String nombre, CyclicBarrier barreraInicio, CyclicBarrier barreraFin) {
        this.nombre = nombre;
        this.barreraInicio = barreraInicio;
        this.barreraFin = barreraFin;
    }

    @Override
    public void run() {
        try {
            System.out.println("Iniciando el hilo " + nombre);
            barreraInicio.await();
            // Cuando se generan 10 hilos, se ejecutan
            System.out.println("Hilo " + nombre + " ejecutándose");
            barreraFin.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
