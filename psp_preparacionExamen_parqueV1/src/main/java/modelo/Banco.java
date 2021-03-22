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
    
    private int numPlazasBanco, plazasOcupadas;
    private Persona persona;
    private boolean bancoCompleto;

    public Banco(int numPlazasBanco) {
        this.numPlazasBanco = numPlazasBanco;
        this.plazasOcupadas = 0;
        this.persona = persona;
        this.bancoCompleto = false;
    }
    
    private boolean estaCompleto() {
        if(numPlazasBanco==plazasOcupadas) {
            return true;
        } else {
            return false;
        }
    }
    
    public synchronized void sentarPersona(Persona persona) {
        while(estaCompleto()) {
            try {
                System.out.println("Banco completo, " + persona.getNombre() + " espera un poco");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(persona.getNombre() + " se sienta.");
        plazasOcupadas++;
        notifyAll();
    }
    
    public synchronized void levantarPersona(Persona persona) {
        plazasOcupadas--;
        System.out.println(persona.getNombre() + " se levanta y se va.");
        notifyAll();
    }
}
