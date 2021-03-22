/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
        Hilo objetoRun1 = new Hilo("hilo1_");
        Hilo objetoRun2 = new Hilo("hilo2_");
        
        Thread hilo1 = new Thread(objetoRun1);
        Thread hilo2 = new Thread(objetoRun2);
        
        
        try {
            hilo1.start();
            hilo1.join(); // Hasta que termina hilo1, no se ejecuta hilo1
            hilo2.start();
            hilo2.join(); // Hasta que termina hilo2, no se ejecuta el main
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Finalizando el hilo principal");
    }
    
}
