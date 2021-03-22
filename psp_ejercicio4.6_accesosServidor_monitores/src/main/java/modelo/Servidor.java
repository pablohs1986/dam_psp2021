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
    private String nombre;
    private int totalAccesos;

    public Servidor(String nombre) {
        this.nombre = nombre;
    }
    
    public void aniadirAcceso() {  
        System.out.println(Thread.currentThread().getName() + "--> Accediendo");
        totalAccesos++;
        System.out.println("Accesos totales a " + this.nombre + ": " + totalAccesos);
    }
}
