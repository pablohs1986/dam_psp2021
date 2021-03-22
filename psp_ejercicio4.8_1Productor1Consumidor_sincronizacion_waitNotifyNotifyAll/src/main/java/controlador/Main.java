/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.AlmacenPatatas;
import modelo.Consumidor;
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
        AlmacenPatatas almacen1 = new AlmacenPatatas("Almacen_1");
        Productor productor1 = new Productor("Productor_1", 5, almacen1);
        Consumidor consumidor1 = new Consumidor("Consumidor_1", 5, almacen1);
        
        productor1.start();
        consumidor1.start();
    }
    
}
