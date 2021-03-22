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
        DatosCompartidos almacen = new DatosCompartidos("almacen1");
        Productor productor1 = new Productor(almacen, "Productor_1", "AAA");
        Productor productor2 = new Productor(almacen, "Productor_2", "BBB");
        Productor productor3 = new Productor(almacen, "Productor_3", "CCC");
        Consumidor consumidor = new Consumidor(almacen, "Consumidor");
        
        productor1.start();
        productor2.start();
        productor3.start();
        consumidor.start();
    }
    
}
