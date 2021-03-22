/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.concurrent.CyclicBarrier;
import modelo.Hilo;
import modelo.HiloFinal;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HiloFinal hiloFinal = new HiloFinal("Hilo final");
        CyclicBarrier barrera = new CyclicBarrier(3, hiloFinal);
        
        for (int i = 0; i < 3; i++) {
            Hilo hilo = new Hilo("Hilo_"+i, barrera);
            hilo.start();
        }
    }
    
}
