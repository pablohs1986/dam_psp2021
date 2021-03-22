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
public class HiloRunnable  implements Runnable{
    private String nombreHilo;
    private int tiempo;

    public HiloRunnable(String nombreHilo, int tiempo) {
        this.nombreHilo = nombreHilo;
        this.tiempo = tiempo;
    }
    
    @Override
    public void run() {
        System.out.println(nombreHilo + " runneable se va a dormir un ratín de... " + tiempo + "mseg");
        try {
            Thread.sleep(tiempo);   // Referencio a Thread
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombreHilo + " runneable se ha despertado de la siesta ¬¬");
    }
    
}
