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
public class PingPong extends Thread {
    private String sonido;
    private Semaphore semaforo;

    public PingPong(String sonido, Semaphore semaforo) {
        this.sonido = sonido;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                semaforo.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(PingPong.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(sonido);
            semaforo.release();
            yield();
        }
    }
    
    
}
