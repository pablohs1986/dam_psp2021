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
public class Hilo implements Runnable {
    public Thread hilo;
    int contador = 0;
    private volatile boolean corriendo = true;

    public Hilo(int prioridad, String nombre) {
        hilo = new Thread(this);
        hilo.setPriority(prioridad);
        hilo.setName(nombre);
    }
    
    public void start() {
        hilo.start();
    }
    
     public void stop() {
        this.corriendo = false;
    }
    
    @Override
    public void run() {
        while (corriendo == true) {
            contador++;
        }
        System.out.println("Hilo " + hilo.getName() + " | Contador= " + contador);
    }
    
   
}
