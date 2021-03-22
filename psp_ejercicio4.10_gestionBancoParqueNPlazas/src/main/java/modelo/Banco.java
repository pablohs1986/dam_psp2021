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
public class Banco {
    private String idBanco;
    private int capacidadBanco;
    private int totalPersonasSentadas;
    private boolean plazasDisponibles;

    public Banco(String idBanco, int capacidadBanco) {
        this.idBanco = idBanco;
        this.capacidadBanco = capacidadBanco;
        plazasDisponibles = true;
        totalPersonasSentadas = 0;
    }
    
    public synchronized void sentarPersona(Persona persona) {
        while(!plazasDisponibles) {
            try {
                System.out.println(persona.getNombre() + " tiene que esperar, no hay plazas disponibles en el banco " + this.idBanco);
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println(persona.getNombre() + " se ha sentado en el banco " + this.idBanco);
        totalPersonasSentadas++;
        
        if (capacidadBanco == totalPersonasSentadas) {
            plazasDisponibles = false;
            System.out.println("El banco está lleno");
        }
        notifyAll();
    }
    
    public synchronized void levantarPersona(Persona persona) {
        System.out.println(persona.getNombre() + " se ha levantado.");
        totalPersonasSentadas--;
        plazasDisponibles = true;
        System.out.println("Quedan " + (capacidadBanco-totalPersonasSentadas) + " plazas disponibles.");
        notifyAll();
    }
}
