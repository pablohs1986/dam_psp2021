/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Banco;
import modelo.Persona;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Banco banco1 = new Banco("B1", 2);
        Persona persona1 = new Persona("Pepe", banco1);
        Persona persona2 = new Persona("Josefa", banco1);
        Persona persona3 = new Persona("Gorka", banco1);
        Persona persona4 = new Persona("Larraitz", banco1);
        
        persona1.start();
        persona2.start();
        persona3.start();
        persona4.start();
    }
    
}
