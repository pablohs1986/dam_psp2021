/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.concurrent.Semaphore;
import modelo.Servidor;
import modelo.Terminal;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(1);
        Servidor servidor = new Servidor();
        Terminal terminal1 = new Terminal("T1", servidor, semaforo);
        Terminal terminal2 = new Terminal("T2", servidor, semaforo);
        Terminal terminal3 = new Terminal("T3", servidor, semaforo);
        Terminal terminal4 = new Terminal("T4", servidor, semaforo);
        
        terminal1.start();
        terminal2.start();
        terminal3.start();
        terminal4.start();
    }
    
}
