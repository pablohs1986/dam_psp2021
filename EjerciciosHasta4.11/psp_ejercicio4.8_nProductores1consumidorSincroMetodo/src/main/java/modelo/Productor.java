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
    
    public DatosCompartidos almacen;
    public String nombre;
    public int totalDatosAProducir;

    public Productor(DatosCompartidos dc, String nmbr, int n) {
        almacen = dc;
        nombre = nmbr;
        this.totalDatosAProducir = n;
        System.out.println("Datos a producir Productor " + nombre + " =" + totalDatosAProducir);

        dc.setDatosCrear(n);//indico al almacen cuantos datos voy a crear        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalDatosAProducir() {
        return totalDatosAProducir;
    }

    public void setTotalDatosAProducir(int totalDatosAProducir) {
        this.totalDatosAProducir = totalDatosAProducir;
    }

    public void run() {
        String datoProducido;
        for (int i = 1; i <= totalDatosAProducir; i++) {
            datoProducido = nombre + i;
            almacen.newDato(this, datoProducido);
        }
        System.out.println("el productor " + nombre + " ha finalizado de generar datos, cerrando hilo ");
    }
    
    
}
