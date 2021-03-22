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

    private String nombre;
    private int patatasAProducir;
    private AlmacenPatatas almacen;

    public Productor(String nombre, int patatasAProducir, AlmacenPatatas almacen) {
        this.nombre = nombre;
        this.patatasAProducir = patatasAProducir;
        this.almacen = almacen;
        this.setName(nombre);
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < patatasAProducir; i++) {
            almacen.producirPatata("patata_" + i);
        }
        System.out.println(nombre + " se jubila, no producirá más.");
    }
}
