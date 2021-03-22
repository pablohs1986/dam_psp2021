/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.Peluqueria;
import modelo.Peluquero;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Peluqueria peluqueria = new Peluqueria("Peluqueria", 5);
        int numeroClientes = 10;
        Peluquero peluquero = new Peluquero(peluqueria);
        
        peluquero.start();
        
        for (int i = 0; i < numeroClientes; i++) {
            try {
                Cliente cliente = new Cliente("Cliente_"+i, peluqueria);
                cliente.start();
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
