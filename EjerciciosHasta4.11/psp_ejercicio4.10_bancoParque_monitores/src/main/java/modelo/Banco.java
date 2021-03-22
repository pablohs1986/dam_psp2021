/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Pablo Herrero
 */
public class Banco {
    private String nombre;
    private int numeroPlazas;
    private int personasSentadas;
    private boolean plazasDisponibles;
    

    public Banco(String nombre, int numeroPlazas) {
        this.nombre = nombre;
        this.numeroPlazas = numeroPlazas;
        this.plazasDisponibles = true;
    }
    
    public synchronized void sentarse(Persona persona) throws InterruptedException {
        while(!plazasDisponibles){
            Thread.yield();
            wait();
        }
        personasSentadas++;
        System.out.println(persona.getNombre() + " se ha sentado en el banco " + this.nombre + ".");
        if (personasSentadas == numeroPlazas) {
            plazasDisponibles = false;
            System.out.println("Banco lleno.");
        }
        Thread.yield();
        notifyAll();
    }
    
    public synchronized void levantarse(Persona persona) {
        System.out.println(persona.getNombre() + " se ha levantado del banco " + this.nombre + ".");
        personasSentadas--;
        plazasDisponibles = true;
        System.out.println("En el banco " + this.nombre + " hay " + (numeroPlazas-personasSentadas) + " plazas disponibles.");
        notifyAll();
    }
}
