/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread hiloPrincipal = Thread.currentThread();
        hiloPrincipal.setPriority(Thread.MAX_PRIORITY);
        
        Hilo hiloLOW = new Hilo(Thread.NORM_PRIORITY - 2, "hiloLOW");
        Hilo hiloHIGH = new Hilo(Thread.NORM_PRIORITY + 2, "hiloHIGH");
        
        hiloLOW.start();
        hiloHIGH.start();
        
        try {
            hiloPrincipal.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        hiloLOW.stop();
        hiloHIGH.stop();
        System.out.println("hiloLOW: " + hiloLOW.hilo.isAlive() + " " + hiloLOW.hilo.getState());
        System.out.println("hiloHIGH: " + hiloHIGH.hilo.isAlive() + " " + hiloHIGH.hilo.getState());

        try {
            hiloLOW.hilo.join();
            hiloHIGH.hilo.join();
            System.out.println("hiloLOW: " + hiloLOW.hilo.isAlive() + " " + hiloLOW.hilo.getState());
            System.out.println("hiloHIGH: " + hiloHIGH.hilo.isAlive() + " " + hiloHIGH.hilo.getState());
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
