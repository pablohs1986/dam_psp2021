/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class PersonaEnElParque extends Thread {
    private Persona persona;
    private Banco banco;

    public PersonaEnElParque(String nombre, Persona persona, Banco banco) {
        this.persona = persona;
        this.banco = banco;
        this.setName(nombre);
    }
    
    public int tiempoSetado(){
        return (int) Math.random()*1000;
    }

    @Override
    public void run() {
        try {
            banco.sentarPersona(persona);
            System.out.println("Sentadín!");
            Thread.sleep(tiempoSetado());
            System.out.println(persona.getNombre() + " se levanta.");
            banco.levantarPersona(persona);
        } catch (InterruptedException ex) {
            Logger.getLogger(PersonaEnElParque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
