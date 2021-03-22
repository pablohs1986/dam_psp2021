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

    public DatosCompartidos getAlmacen() {
        return almacen;
    }

    public void setAlmacen(DatosCompartidos almacen) {
        this.almacen = almacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while(!almacen.isParar()) {
            almacen.consumirDato(this);
        }
        System.out.println(this.nombre + " ha terminado de consumir.");
    }
    
    
  
    
    
}
