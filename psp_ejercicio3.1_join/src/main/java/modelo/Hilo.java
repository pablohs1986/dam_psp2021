/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Hilo implements Runnable{
    private String nombre;

    public Hilo(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(nombre.equalsIgnoreCase("Mi hilo uno")) {
                System.out.println(nombre + i + "--->");
            } else {
                System.out.println(nombre + i + "<---");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(nombre + " finalizado");
    }
    
}
