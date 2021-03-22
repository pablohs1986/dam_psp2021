/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.concurrent.CountDownLatch;
import modelo.Trabajador;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CountDownLatch puntoDeEspera = new CountDownLatch(1); // 1 hilo por turno
        
        for (int i = 0; i < 49; i++) {
            System.out.println("Creando hilo " + i);
            Trabajador trabajador = new Trabajador("Hilo_"+i, puntoDeEspera);
            trabajador.start();
        }
        puntoDeEspera.countDown(); // Se ejecutan todos los hilos a la vez desde el punto de espera.
    }
    
}
