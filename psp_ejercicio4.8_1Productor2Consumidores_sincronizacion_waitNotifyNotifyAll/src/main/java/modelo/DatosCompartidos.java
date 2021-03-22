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
public class DatosCompartidos {

    private String dato;
    private boolean datoDisponible;
    private int totalDatosACrear;
    private boolean parar = false;

    public void datosACrear(int datosACrear) {
        totalDatosACrear = datosACrear;
        System.out.println("Total datos a crear: " + totalDatosACrear);
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public boolean isDatoDisponible() {
        return datoDisponible;
    }

    public void setDatoDisponible(boolean datoDisponible) {
        this.datoDisponible = datoDisponible;
    }

    public int getTotalDatos() {
        return totalDatosACrear;
    }

    public void setTotalDatos(int totalDatos) {
        this.totalDatosACrear = totalDatos;
    }

    public boolean isParar() {
        return parar;
    }

    public void setParar(boolean parar) {
        this.parar = parar;
    }

    public void almacenarDato(String dato, String nombreHilo) {
        while (datoDisponible) {
            try {
                System.out.println(nombreHilo + " esperando par almacenar dato " + dato);
                Thread.yield();
                wait();
            } catch (InterruptedException ex) {
                System.out.println(Thread.currentThread().getName() + " esperando...");
            }
        }
        this.dato = dato;
        datoDisponible = true;
        System.out.println("Almacenado: " + this.dato);
        Thread.yield();
        notifyAll();
    }
    
    public String consumirDato(String nombreHilo) {
        if(totalDatosACrear > 0) {
            while (totalDatosACrear > 0 && !datoDisponible) {
                try {
                    System.out.println(nombreHilo + " esperando para consumir");
                    Thread.yield();
                    wait();
                } catch (InterruptedException ex) {
                    System.out.println(Thread.currentThread().getName() + " esperando...");
                }
            }
            datoDisponible = false;
            totalDatosACrear--;
            notifyAll();
        } else {
            dato = null;
            datoDisponible = true;
            parar = true;
            notifyAll();
        }
        return dato;
    }
}
