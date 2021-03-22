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
 * Ejercicio 4.8, variación patatil
 */
public class AlmacenPatatas {

    private String nombre;
    private String patataEnAlmacen;
    private boolean patatasDisponibles = false;

    public AlmacenPatatas(String nombre) {
        this.nombre = nombre;
    }

    public synchronized void producirPatata(String patata) {
        while(patatasDisponibles) {    
            try {
                wait();     // Si hay patata disponible, el productor espera. 
            } catch (InterruptedException ex) {
                System.out.println(Thread.currentThread().getName() + " no puede producir, el almacén está ocupado.");
            }
        }
        // Si no hay patata en el almacen, el productor la almacena.
        patataEnAlmacen = patata;
        System.out.println(patata + " almacenada por " + Thread.currentThread().getName());
        patatasDisponibles = true;
        notifyAll();    // Aviso a los hilos que están esperando para que reanuden la ejecución.
    }

    public synchronized void consumirPatata() {
        while(!patatasDisponibles) {     
            try {
                wait();     // Si no hay patatas disponibles, el consumidor espera.
            } catch (InterruptedException ex) {
                System.out.println(Thread.currentThread().getName() + " no puede consumir, no hay patatas en el almacén.");
            }
        }
        System.out.println(patataEnAlmacen + " consumida por " + Thread.currentThread().getName());
        patataEnAlmacen = "";
        patatasDisponibles = false;
        notifyAll();    // Aviso a los hilos que están esperando para que reanuden la ejecución.
    }

}
