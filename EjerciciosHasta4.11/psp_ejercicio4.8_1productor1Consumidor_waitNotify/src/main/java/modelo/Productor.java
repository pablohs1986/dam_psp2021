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
public class Productor extends Thread{
    private DatosCompartidos dato;
    private String nombre;
    private int numeroValoresACrear;

    public Productor(DatosCompartidos almacen, String nombre, int numeroValoresACrear) {
        this.dato = almacen;
        this.nombre = nombre;
        this.numeroValoresACrear = numeroValoresACrear;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.numeroValoresACrear; i++) {
            try {
//                System.out.println(this.nombre + " PRODUCIENDO ");
                dato.almacenarDato(this.nombre + "_" + i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
