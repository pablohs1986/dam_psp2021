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
    private CyclicBarrier barrera;

    public Hilo(String nombre, CyclicBarrier barrera) {
        this.nombre = nombre;
        this.barrera = barrera;
    }

    @Override
    public void run() {
        try {
            System.out.println("Hola, soy el hilo " + nombre);
            barrera.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
