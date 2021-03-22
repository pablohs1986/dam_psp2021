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
public class Productor extends Thread {

    private DatosCompartidos almacen;
    private String nombre;
    private int totalDatosAProducir;

    public Productor(DatosCompartidos almacen, String nombre, int totalDatosAProducir) {
        this.almacen = almacen;
        this.nombre = nombre;
        this.totalDatosAProducir = totalDatosAProducir;
        almacen.setTotalDatos(totalDatosAProducir);
    }

    public void run() {
        for (int i = 0; i < totalDatosAProducir; i++) {
            synchronized (almacen) {
                try {
                    almacen.almacenarDato(nombre + "_dato" + i);
                    Thread.yield();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
