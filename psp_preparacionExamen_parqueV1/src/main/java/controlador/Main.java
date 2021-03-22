/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Banco;
import modelo.Persona;
import modelo.PersonaEnElParque;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Banco banco = new Banco(2);
        for (int i = 0; i < 10; i++) {
            Persona persona = new Persona("Persona_"+i);
            PersonaEnElParque hilo = new PersonaEnElParque("hilo"+i, persona, banco);
            hilo.start();
        }
    }
    
}
