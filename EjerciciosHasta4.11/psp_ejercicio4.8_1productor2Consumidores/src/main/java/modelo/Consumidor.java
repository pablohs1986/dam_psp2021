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
public class Consumidor extends Thread {

    private DatosCompartidos almacen;
    private String nombre;

    public Consumidor(DatosCompartidos almacen, String nombre) {
        this.almacen = almacen;
        this.nombre = nombre;
    }

    public void run() {
        String dato;
        int totalDatosConsumidos = 0;

        synchronized (almacen) {
            while (almacen.parar() == false) {
                try {
                    dato = almacen.consumirDato();
                    if (almacen.getTotalDatos() >= 0 && dato != null) {
                        System.out.println(dato + " CONSUMIDO por " + this.nombre);
                        totalDatosConsumidos++;
                        Thread.yield();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Total datos consumidos por " + this.nombre + ": " + totalDatosConsumidos);
        }
    }
}
