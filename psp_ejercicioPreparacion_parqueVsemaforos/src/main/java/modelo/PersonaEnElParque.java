/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class PersonaEnElParque extends Thread {
    private Persona persona;
    private Banco banco;
    private Semaphore semaforo;

    public PersonaEnElParque(String nombre, Persona persona, Banco banco, Semaphore semaforo) {
        this.persona = persona;
        this.banco = banco;
        this.setName(nombre);
        this.semaforo = semaforo;
        this.start();
    }
    
    public int tiempoSentado(){
        return (int) (500 + Math.random()*500);
    }

    @Override
    public void run() {
        try {
            if(banco.estaCompleto()) {
                System.out.println(this.getName() + " tiene que esperar");
                semaforo.release();
            } else {
                semaforo.acquire(); 
                banco.sentarPersona(persona);
                System.out.println("Sentadín!");
                semaforo.release();
                Thread.sleep(tiempoSentado());
                System.out.println(persona.getNombre() + " se levanta.");
                banco.levantarPersona(persona);
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(PersonaEnElParque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
