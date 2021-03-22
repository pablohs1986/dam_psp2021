/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.concurrent.Semaphore;
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
        Semaphore semaforo = new Semaphore(1);

        Banco banco = new Banco(2);
        for (int i = 0; i < 10; i++) {
            new PersonaEnElParque("hilo"+i, (new Persona("Persona_"+i)), banco, semaforo);
        }
    }
    
}
