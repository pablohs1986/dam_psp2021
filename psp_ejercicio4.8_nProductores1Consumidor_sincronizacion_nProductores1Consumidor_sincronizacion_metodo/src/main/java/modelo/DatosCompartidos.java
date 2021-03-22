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
public class DatosCompartidos {

    private String nombre;
    private boolean parar = false;
    private String dato;
    private int totalDatos = 3;
    private boolean datoDisponible = false;

    public DatosCompartidos(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isParar() {
        return parar;
    }

    public void setParar(boolean parar) {
        this.parar = parar;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public boolean isDatoDisponible() {
        return datoDisponible;
    }

    public void setDatoDisponible(boolean datoDisponible) {
        this.datoDisponible = datoDisponible;
    }

    public int getTotalDatos() {
        return totalDatos;
    }

    public void setTotalDatos(int totalDatos) {
        this.totalDatos = totalDatos;
    }
    
    public synchronized void almacenarDato(Productor productor, String dato) {
        while(datoDisponible) { try {
            // Ya hay un dato
            wait();
            } catch (InterruptedException ex) {
                System.out.println(productor.getNombre() + " esperando...");
            }
        }
        this.dato = dato;
        datoDisponible = true;
        System.out.println(productor.getNombre()+ " ha almacenado el dato " + dato);
        notifyAll();
    }
    
    public synchronized void consumirDato(Consumidor consumidor) {
        if(totalDatos > 0) {
            while(!datoDisponible) {
                try {
                    System.out.println(consumidor.getNombre()+ " esperando..");
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(consumidor.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(dato!=null) {
                System.out.println(consumidor.getNombre()+ " ha consumido el dato " + this.dato);
                dato = null;
                totalDatos--;
                datoDisponible = false;
                notifyAll();
            } 
        } else {
            dato = null;
            datoDisponible = true;
            parar = true;
            System.out.println("FIN");
            notifyAll();
        }
    }

}
