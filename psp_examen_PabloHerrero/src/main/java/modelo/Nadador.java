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
 * Clase hilo que simula el comportamiento de un nadador.
 */
public class Nadador extends Thread {

    private String id;
    private TipoNadador tipo;
    private Semaphore semaforo;
    private Piscina piscina;

    public Nadador(String id, TipoNadador tipo, Semaphore semaforo, Piscina piscina) {
        this.id = id;
        this.tipo = tipo;
        this.setName(id);
        this.semaforo = semaforo;
        this.piscina = piscina;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoNadador getTipo() {
        return tipo;
    }

    public void setTipo(TipoNadador tipo) {
        this.tipo = tipo;
    }

    /**
     * Genera un tiempo aleatorio en ms, de 0 a 80ms.
     *
     * @return Long con el tiempo en ms
     */
    private long generarTiempoLargo() {
        return (long) (Math.random() * 80);
    }

    /**
     * Override del método run donde se implementan los semáforos.
     *
     */
    @Override
    public void run() {
        try {
            semaforo.acquire();
            piscina.entraNadador(this);
            System.out.println("\tNadador " + this.id + " comienza su largo...");
            long tiempo = generarTiempoLargo();
            Thread.sleep(tiempo);
            semaforo.release();
            System.out.println("\t" + this.id + " termina su largo con un tiempo de " + tiempo + " y se va.");
            piscina.saleNadador(this);
            yield();
        } catch (InterruptedException ex) {
            Logger.getLogger(Nadador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
