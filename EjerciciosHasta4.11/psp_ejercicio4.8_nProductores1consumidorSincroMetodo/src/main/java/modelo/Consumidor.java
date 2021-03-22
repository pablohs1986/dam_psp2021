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
    private String nombre;   //podriamos usar el atributo name del Thread
    private int totalDatosConsumidor;

    public Consumidor(DatosCompartidos dc, String nmbr) {
        almacen = dc;
        nombre = nmbr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalDatosConsumidor() {
        return totalDatosConsumidor;
    }

    public void setTotalDatosConsumidor(int totalDatosConsumidor) {
        this.totalDatosConsumidor = totalDatosConsumidor;
    }

    public void run() {
        String datoAux; //para recoger el valor mientras no se finaliza la produccion        
        
        while (! almacen.isParar() ) {
            almacen.getDato(this);      
        }
        System.out.println("Cierro Hilo consumidor :" + nombre + " Ha cogido " + totalDatosConsumidor);
    }
}

