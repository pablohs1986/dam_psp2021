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
public class Hilo implements Runnable {
    public Thread hilo;
    private int contador;
    private volatile boolean flag = true;

    public Hilo(int prioridad, String nombre) {
        hilo = new Thread(this);
        hilo.setPriority(prioridad);
        hilo.setName(nombre);
    }
    
    public void start(){
        hilo.start();
    }
    
    public void stop() {
        this.flag = false;
    }
    
    @Override
    public void run() {
        while(flag) {
            contador++;
        }
        System.out.println(hilo.getName() + contador);
    }
    
}
