/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
        ExecutorService executor = Executors.newFixedThreadPool(8); // Executor de 10 tareas/hilos
        Nadador nadador;

        for (int i = 1; i <= 20; i++) {
            int tiempo = (int) (Math.random() * 80) + 50;
            nadador = new Nadador("Nadador_" + i, tiempo);
            executor.execute(nadador);
        }

        executor.shutdown();
    }
    
}
