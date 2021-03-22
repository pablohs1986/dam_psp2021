/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Nadador extends Thread {
    private String nombre;
    CyclicBarrier barreraInicio;
    CyclicBarrier barreraFin;
    private long tiempo;

    public Nadador(String nombre, CyclicBarrier barreraInicio, CyclicBarrier barreraFin) {
        this.nombre = nombre;
        this.barreraInicio = barreraInicio;
        this.barreraFin = barreraFin;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.nombre + " LLEGA a la piscina");
            System.out.println(this.nombre + " ESPERANDO...");
            barreraInicio.await();
            System.out.println(this.nombre + " ENTRA en la piscina y comienza su largo");
            this.tiempo = generarTiempoLargo();
            Thread.sleep(tiempo);
            barreraFin.await();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Nadador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Nadador.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(this.nombre + " termina su largo en un tiempo de " + tiempo + " y se va.");
    }
    
        /**
     * Genera un tiempo aleatorio en ms, de 0 a 80ms.
     *
     * @return Long con el tiempo en ms
     */
    private long generarTiempoLargo() {
        return (long) (Math.random() * 80);
    }
}
