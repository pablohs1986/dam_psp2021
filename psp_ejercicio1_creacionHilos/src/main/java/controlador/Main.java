/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import modelo.Hilo;
import modelo.HiloRunnable;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tiempo;
        
        // Con clase Thread
        for (int i = 0; i < 3; i++) {
            tiempo = (int) (Math.random() * 5000) + 1000;
            Hilo hiloThread = new Hilo("hilo"+i, tiempo);
            hiloThread.start();
        }
        
        // Con Runnable
        for (int i = 0; i < 3; i++) {
            tiempo = (int) (Math.random() * 5000) + 1000;
            HiloRunnable objetoRunnable = new HiloRunnable("nombre"+i, tiempo);     // Instancio objeto runnable
            Thread hiloRunnable = new Thread(objetoRunnable);   // Instancio hilo a partir de objeto runnable
            hiloRunnable.start();
        }
    }
    
}
