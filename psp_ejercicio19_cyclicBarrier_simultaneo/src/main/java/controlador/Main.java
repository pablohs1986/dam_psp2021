/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static java.lang.Thread.sleep;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Hilo;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final CyclicBarrier barreraInicio = new CyclicBarrier(10+1); // los 10 hilos pa 1 del main
            final CyclicBarrier barreraFin = new CyclicBarrier(10+1);
            
            for (int i = 0; i < 10; i++) {
                Hilo hilo = new Hilo("Hilo "+i, barreraInicio, barreraFin);
                try {
                    hilo.start();
                    hilo.sleep(500); // Entre crear un hilo y otro, espera 500
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            // En este punto los hilos están creados, pero frenados
            System.out.println("Levantando barrera de inicio...");
            barreraInicio.await();
            sleep(500);
            System.out.println("Bajando barrera");
            barreraFin.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
