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
        Productor productor1 = new Productor(datos, "Productor1", 100);
        Consumidor consumidor1 = new Consumidor(datos, "Consumidor1");
        Consumidor consumidor2 = new Consumidor(datos, "Consumidor2");

        productor1.start();
        consumidor1.start();
        consumidor2.start();
    }
}
