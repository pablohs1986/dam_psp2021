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
public class Consumidor extends Thread{
    private DatosCompartidos dato;
    private String nombre;
    private int numeroValores;

    public Consumidor(DatosCompartidos datos, String nombre, int numeroValoresACrear) {
        this.dato = datos;
        this.nombre = nombre;
        this.numeroValores = numeroValoresACrear;
    }

    @Override
    public void run() {
        for (int i = 0; i < numeroValores; i++) {
            try {
                String cadena = dato.getDato();
                System.out.println(nombre + " CONSUME " + cadena);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
