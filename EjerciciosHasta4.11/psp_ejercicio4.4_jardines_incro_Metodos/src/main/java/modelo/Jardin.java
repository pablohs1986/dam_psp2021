/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author pablo
 */
public class Jardin {
    int  contadorPersonas;

    public Jardin(int contadorPersonas) {
        this.contadorPersonas = contadorPersonas;
    }
    
    public synchronized void entraPersona() {
        System.out.println("Hilo " + Thread.currentThread().getName() + " entra en el jardín.");
        contadorPersonas++;
        System.out.println("Personas en el jardín: " + contadorPersonas);
    }
    
    public synchronized void salePersona() {
        System.out.println("Hilo " + Thread.currentThread().getName() + " sale del jardín.");
        contadorPersonas--;
        System.out.println("Personas en el jardín: " + contadorPersonas);
    }
}
