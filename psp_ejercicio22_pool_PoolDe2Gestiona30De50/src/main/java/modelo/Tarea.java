/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Random;

/**
 *
 * @author Pablo Herrero
 */
public class Tarea implements Runnable {

    @Override
    public void run() {
        String cadena = "";
        Random random = new Random();
        
        for (int i = 0; i < 9; i++) {
            cadena += random.nextInt(50) + ", ";
            Thread.yield();
        }
        
        System.out.println("Números aleatorios generados por " + 
                Thread.currentThread().getName() + ": " + cadena);
    }

    
    
    
}
