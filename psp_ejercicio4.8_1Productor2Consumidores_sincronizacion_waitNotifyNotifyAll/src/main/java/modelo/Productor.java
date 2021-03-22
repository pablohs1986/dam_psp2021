/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pablo Herrero
 */
public class Productor extends Thread {

    private DatosCompartidos almacen;
    private String nombre;
    private int totalDatosProducidos;

    public Productor(DatosCompartidos almacen, String nombre, int totalDatosProducidos) {
        this.almacen = almacen;
        this.nombre = nombre;
        this.totalDatosProducidos = totalDatosProducidos;
        
        almacen.setTotalDatos(totalDatosProducidos);
    }

    @Override
    public void run() {
        for (int i = 0; i < totalDatosProducidos; i++) {
            synchronized(almacen) {
                almacen.almacenarDato(nombre+i, nombre);
                Thread.yield();
            }
        }
        System.out.println("Productor " + nombre + " ha terminado");
    }
    
    
    
    
}
