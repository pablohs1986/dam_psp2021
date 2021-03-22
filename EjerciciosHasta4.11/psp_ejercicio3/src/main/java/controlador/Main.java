/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.HiloEjemploJoin;

/**
 *
 * @author pablo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        HiloEjemploJoin hilo1 = new HiloEjemploJoin("HILO 1");
        Thread h1 = new Thread(hilo1);
        
        HiloEjemploJoin hilo2 = new HiloEjemploJoin("HILO 2");
        Thread h2 = new Thread(hilo2);
        
        h1.start();
        h1.join();
        h2.start();
        h2.join();
        
        // Al aplicar el Join sobre los hilos se ejecuta h1, luego h2 y luego el principal
        
        System.out.println("Finaliza el proceso principal.");
    }
    
}
