/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static java.lang.Thread.yield;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Banco {
    
    private int numPlazasBanco, plazasOcupadas;
    private Persona persona;

    public Banco(int numPlazasBanco) {
        this.numPlazasBanco = numPlazasBanco;
        this.plazasOcupadas = 0;
        this.persona = persona;
    }
    
    public boolean estaCompleto() {
        if(numPlazasBanco==plazasOcupadas) {
            return true;
        } else {
            return false;
        }
    }
    
    public void sentarPersona(Persona persona) {
        while(this.estaCompleto()) {
            System.out.println("Banco completo, " + persona.getNombre() + " espera un poco");
        }
        System.out.println(persona.getNombre() + " se sienta.");
        plazasOcupadas++;
        System.out.println(plazasOcupadas);
    }
    
    public void levantarPersona(Persona persona) {
        plazasOcupadas--;
        System.out.println(plazasOcupadas);
        System.out.println(persona.getNombre() + " se levanta y se va.");
    }
}
