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
public class Consumidor extends Thread {

    private DatosCompartidos almacen;
    private String nombre;

    public Consumidor(DatosCompartidos almacen, String nombre) {
        this.almacen = almacen;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        String datoAux;
        int totalDatosConsumidor = 0;
        synchronized(almacen) {
            while(!almacen.isParar()) {
                datoAux = almacen.consumirDato(nombre);
                
                if(almacen.getTotalDatos() >= 0 && datoAux != null) {
                    totalDatosConsumidor++;
                    System.out.println(nombre + " consumiendo " + datoAux + " ||| Total datos consumidos: " + totalDatosConsumidor);
                    Thread.yield();
                }
            }
        }
        System.out.println(nombre + " ha terminado de consumir.");
    }
    
    
}
