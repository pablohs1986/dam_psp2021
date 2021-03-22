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
public class Peluquero extends Thread {
    private Peluqueria peluqueria;
    private boolean finDeLaJornada = false;

    public Peluquero(Peluqueria peluqueria) {
        this.peluqueria = peluqueria;
    }

    @Override
    public void run() {
        while(!finDeLaJornada) {
            try {
                peluqueria.atenderCliente(this);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Peluquero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        peluqueria.terminarCorte();
        if(peluqueria.getSillasOcupadas() == 0) {
            finDeLaJornada = true;
        }
        System.out.println("El peluquero se ha ido a casa...");
    }
    
    
    
}
