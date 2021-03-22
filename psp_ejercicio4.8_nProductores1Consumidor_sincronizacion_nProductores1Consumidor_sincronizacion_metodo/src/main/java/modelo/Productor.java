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
    private String datoAAlmacenar;

    public Productor(DatosCompartidos almacen, String nombre, String datoAAlmacenar) {
        this.almacen = almacen;
        this.nombre = nombre;
        this.datoAAlmacenar = datoAAlmacenar;
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
        almacen.almacenarDato(this, this.datoAAlmacenar);
    }

    
    
}
