/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author pablo
 */
public class HiloPuertaSalida extends Thread {
    private Jardin jardin;

    public HiloPuertaSalida(String nombreHilo, Jardin jardin) {
        this.jardin = jardin;
        this.setName(nombreHilo);
    }
    
    @Override
    public void run() {
        synchronized(jardin) {
            jardin.salePersona();
        }
    }
    
    
}
