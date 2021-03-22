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
public class Parque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Banco banco1 = new Banco("Banco1", 2);
        Persona persona1 = new Persona("Pepín", banco1);
        Persona persona2 = new Persona("Juani", banco1);
        Persona persona3 = new Persona("Josete", banco1);
        Persona persona4 = new Persona("María", banco1);
        Persona persona5 = new Persona("Tere", banco1);
        
        
        persona1.start();
        persona2.start();
        persona3.start();
        persona4.start();
        persona5.start();
    }
    
}
