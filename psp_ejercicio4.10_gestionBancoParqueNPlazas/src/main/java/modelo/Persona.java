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
    private Banco banco;

    public Persona(String nombre, Banco banco) {
        this.nombre = nombre;
        this.banco = banco;
        
        System.out.println(this.nombre + " está en el parque");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        long tiempoSentado = (long) (Math.random()*5000);
        try {
            banco.sentarPersona(this);
            Thread.sleep(tiempoSentado);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        banco.levantarPersona(this);
    }
    
    
    

    
    
    
    
}
