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
public class Persona extends Thread {
    private String nombre;
    Banco banco;

    public Persona(String nombre, Banco banco) {
        this.nombre = nombre;
        this.banco = banco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void run() {
        try {
            banco.sentarse(this);
            int tiempoSentado = 1000 + (int)(Math.random()*500);
            Thread.sleep(tiempoSentado);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        banco.levantarse(this);
    }
    
    
}
