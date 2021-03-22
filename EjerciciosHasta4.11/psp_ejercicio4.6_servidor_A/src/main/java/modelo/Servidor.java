/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pablo Herrero
 */
public class Servidor {
    private int contadorAccesos;

    public Servidor() {
    }
    
    public void anadirAcceso(){
        System.out.println(Thread.currentThread().getName() + " accediendo al servidor.");
        this.contadorAccesos++;
        System.out.println("Accesos totales: " + contadorAccesos);
    }
}
