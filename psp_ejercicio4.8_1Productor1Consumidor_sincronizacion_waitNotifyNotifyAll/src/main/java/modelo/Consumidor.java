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

    private String nombre;
    private int patatasAConsumir;
    private AlmacenPatatas almacen;

    public Consumidor(String nombre, int patatasAProducir, AlmacenPatatas almacen) {
        this.nombre = nombre;
        this.patatasAConsumir = patatasAProducir;
        this.almacen = almacen;
        this.setName(nombre);
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < patatasAConsumir; i++) {
            almacen.consumirPatata();
        }
        System.out.println(nombre + " se hartó de patatas, no consumirá más.");
    }
}
