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
    private int totalAccesos;

    public Servidor() {
        this.totalAccesos = 0;
    }
    
    public void aniadirAcceso(String nombreTerminal) {
        System.out.println(nombreTerminal + " accediendo");
        totalAccesos++;
        System.out.println("Total accesos: " + totalAccesos);
    }
}
