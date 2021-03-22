/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Terminal extends Thread {
    private String nombre;
    private Servidor servidor;
    private Semaphore semaforo;

    public Terminal(String nombre, Servidor servidor, Semaphore semaforo) {
        this.nombre = nombre;
        this.servidor = servidor;
        this.semaforo = semaforo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                semaforo.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
            }
            servidor.aniadirAcceso(this.nombre);
            semaforo.release();
            yield();
        }
    }
    
    
}
