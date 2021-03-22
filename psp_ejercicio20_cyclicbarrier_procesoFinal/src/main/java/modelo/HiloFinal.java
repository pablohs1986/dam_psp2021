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
public class HiloFinal extends Thread {
    private String nombre;

    public HiloFinal(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("Hola, soy el hilo final y me ejecuto al final :SSSS");
    }
    
    
}
