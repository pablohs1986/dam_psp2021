/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.concurrent.CountDownLatch;
import modelo.Nadador;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CountDownLatch cuentaAtras = new CountDownLatch(10); // 1 hilo por turno
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Nadador " + i + " LLEGA a la piscina");
            Nadador nadador = new Nadador("Nadador_"+i, cuentaAtras);
            nadador.start();
            cuentaAtras.countDown();
        }
//        puntoDeEspera.countDown(); // Se ejecutan todos los hilos a la vez desde el punto de espera.
    }
}
