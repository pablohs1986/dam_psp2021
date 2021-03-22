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
public class HiloColor extends Thread {
    private String color;

    public HiloColor(String color) {
        this.color = color;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(color + "_" + i);
            this.yield();   // Tras una iteración, el hilo pasa a preparado, dejando paso al siguiente hilo.
        }
    }
    
    
}
