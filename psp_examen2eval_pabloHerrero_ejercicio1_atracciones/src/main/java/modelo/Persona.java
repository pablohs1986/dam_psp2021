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
public class Persona extends Thread {
    
    private String nombre;
    private Atraccion atraccion;
    private CyclicBarrier barrera;

    public Persona(String nombre, Atraccion atraccion, CyclicBarrier barrera) {
        this.nombre = nombre;
        this.atraccion = atraccion;
        this.barrera = barrera;
    }
    
        /**
     * Genera un tiempo aleatorio en ms, de 50 a 150ms.
     *
     * @return Long con el tiempo en ms
     */
    private long generarTiempo() {
        return (long) (Math.random() * 100)+50;
    }

     @Override
    public void run() {
        try {
            System.out.println("Hola, soy " + nombre + " quiero montar en una atraccion...");
            barrera.await();
            System.out.println(this.nombre + " ENTRA en el parque y va hacia la atracción...");
            long tiempo = generarTiempo();
            Thread.sleep(tiempo);
            System.out.println(this.nombre + " LLEGA a su atracción");
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
