/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.HiloColor;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HiloColor hiloAzul = new HiloColor("Azul");
        HiloColor hiloRojo = new HiloColor("Rojo");
        HiloColor hiloAmarillo = new HiloColor("Amarillo");
        
        hiloAzul.start();
        hiloRojo.start();
        hiloAmarillo.start();
        try {
            hiloAmarillo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
