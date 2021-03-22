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
public class HiloColor implements Runnable {
    Thread t;
    String nombreColor;

    public HiloColor(String nombreColor) {
        this.nombreColor = nombreColor;
        t = new Thread(this);
    }
    
    public void start() {
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(nombreColor + i);
            t.yield();
        }
    }
}
