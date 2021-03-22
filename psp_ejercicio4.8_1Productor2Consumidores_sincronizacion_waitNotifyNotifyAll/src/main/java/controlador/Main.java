/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Consumidor;
import modelo.DatosCompartidos;
import modelo.Productor;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatosCompartidos datos = new DatosCompartidos();
        int numDatos = 10;
        Productor p1 = new Productor(datos, "prod1 ", numDatos);
        Consumidor c1 = new Consumidor(datos, "consumidor1 ");
        Consumidor c2 = new Consumidor(datos, "consumidor2 ");

        p1.start();
        c1.start();
        c2.start();
    }
    
}
