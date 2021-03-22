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
public class Peluqueria {
   private String nombre;
   private int capacidadSillas;
   private int sillasOcupadas;
   private boolean sillasDisponibles = true;
   private boolean disponibleSillonCorte = true;
   private boolean peluqueroDurmiendo = true;
   private boolean finCorte = false;

    public Peluqueria(String nombre, int capacidadSillas) {
        this.nombre = nombre;
        this.capacidadSillas = capacidadSillas;
    }

    public int getSillasOcupadas() {
        return sillasOcupadas;
    }
   
    public synchronized void entraCliente(Cliente cliente) {
        if(sillasOcupadas == capacidadSillas) {
            sillasDisponibles = false;
            System.out.println("La peluquería está llena, " + cliente.getNombre() + " se va.");
        } else {
            sillasOcupadas++;
            System.out.println(cliente.getNombre() + " se sienta...");
            
            while (!disponibleSillonCorte) {
                try {
                    System.out.println(cliente.getNombre() + " está esperando...");
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Peluqueria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (peluqueroDurmiendo) {
                System.out.println(cliente.getNombre() + " despierta al peluquero");
                peluqueroDurmiendo = false;
                notifyAll();
            }
            
            sillasOcupadas--;
            disponibleSillonCorte = false;
            System.out.println(cliente.getNombre() + " se está cortando el pelo.");
            finCorte=false;
            while(!finCorte) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Peluqueria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            disponibleSillonCorte = true;
            System.out.println(cliente.getNombre() + " terminó el corte y se va.");
            notify();
        }
    }
    
    public synchronized void atenderCliente(Peluquero peluquero) {
        while(disponibleSillonCorte) {
            try {
                peluqueroDurmiendo = true;
                System.out.println("zzzZZZzzzZZZzzzz");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Peluqueria.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Cortando el pelo");
        }
    }
    
    public synchronized void terminarCorte(){
        this.finCorte = true;
        System.out.println("EL SIGUIENTE!");
        notifyAll();
    }
}
