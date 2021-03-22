/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.concurrent.Semaphore;
import modelo.PingPong;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore pelota = new Semaphore(1);
        
        PingPong j1 = new PingPong("PING", pelota);
        PingPong j2 = new PingPong("PONG", pelota);
        
        j1.start();
        j2.start();
    }
    
}
