/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import modelo.Tarea;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10); // Executor de 10 tareas/hilos
        Tarea tarea;
        
        for (int i = 0; i < 199; i++) {
            int tiempo = (int)(Math.random()*5000)+5000;
            tarea = new Tarea("Tarea_"+i, tiempo);
            executor.execute(tarea);
        }
        
        executor.shutdown();
    }
    
}
