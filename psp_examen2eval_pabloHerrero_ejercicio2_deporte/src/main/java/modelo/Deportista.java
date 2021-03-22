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
public class Deportista extends Thread {
    
    private String nombre;
    private long tiempoCaminando = 0;
    private long tiempoDisparando = 0;

    public Deportista(String nombre, long tiempoCaminando) {
        this.nombre = nombre;
        this.tiempoCaminando = tiempoCaminando;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTiempoCaminando() {
        return tiempoCaminando;
    }

    public void setTiempoCaminando(long tiempoCaminando) {
        this.tiempoCaminando = tiempoCaminando;
    }

    public long getTiempoDisparando() {
        return tiempoDisparando;
    }

    public void setTiempoDisparando(long tiempoDisparando) {
        this.tiempoDisparando = tiempoDisparando;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.nombre + " COMIENZA su prueba.");
            tiempoDisparando = generarTiempoDisparando();
            System.out.println(this.nombre + " COMIENZA A DISPARAR");
            Thread.sleep(tiempoDisparando);
            System.out.println(this.nombre + " TERMINA la prueba con un tiempo de disparo de " + tiempoDisparando);
        } catch (InterruptedException ex) {
            Logger.getLogger(Deportista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
    /**
     * Genera un tiempo aleatorio en ms, de 100 a 150ms.
     * Se dispara. Si no se acierta, se penaliza.
     *
     * @return Long con el tiempo en ms
     */
    private long generarTiempoDisparando() {
        long tiempoDeDisparo = (long) ((Math.random() * 100)+50);
        int contadorDeDisparos = 0;
        boolean isDisparoAcertado = false;
        
        while(contadorDeDisparos != 3 || !isDisparoAcertado) {
            isDisparoAcertado = disparar();
            contadorDeDisparos++;
            
            if(isDisparoAcertado == false) {
                tiempoDeDisparo+=10;
            }
        }
        return (long) (Math.random() * 100)+50;
    }
    
    /**
     * Simula un disparo
     *
     * @return boolean confirmando si se acierta en la diana o no.
     */
    private boolean disparar(){
         int isDisparoAcertado = (int) Math.random();
         if(isDisparoAcertado == 1) {
             return true;
         } else {
             return false;
         }
    }

}
