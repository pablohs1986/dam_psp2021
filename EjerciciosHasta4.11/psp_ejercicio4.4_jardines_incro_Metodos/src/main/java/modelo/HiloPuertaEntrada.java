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
public class HiloPuertaEntrada extends Thread {
    private Jardin jardin;
    private Thread t;

    public HiloPuertaEntrada(String nombreHilo, Jardin jardin) {
        this.jardin = jardin;
        this.setName(nombreHilo);
    }
    
    @Override
    public void run() {
        jardin.entraPersona();
    }
}
