/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Nadador extends Thread {
    
    private String nombre;
    private CountDownLatch puntoEspera;
    private long tiempo;

    public Nadador(String nombre, CountDownLatch puntoEspera) {
        this.nombre = nombre;
        this.puntoEspera = puntoEspera;
    }

    @Override
    public void run() {
        try {
            this.puntoEspera.await();
            System.out.println(this.nombre + " ESPERANDO...");
            System.out.println(this.nombre + " ENTRA en la piscina y comienza su largo");
            this.tiempo = generarTiempoLargo();
            Thread.sleep(tiempo);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Nadador.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(this.nombre + " termina su largo en un tiempo de " + tiempo + " y se va.");
    }
    
        /**
     * Genera un tiempo aleatorio en ms, de 0 a 80ms.
     *
     * @return Long con el tiempo en ms
     */
    private long generarTiempoLargo() {
        return (long) (Math.random() * 80);
    }
    
    
    
    
    
    
}
