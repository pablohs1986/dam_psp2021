/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Terminal extends Thread {
    private String nombre;
    private Servidor servidor;

    public Terminal(String nombre, Servidor servidor) {
        this.nombre = nombre;
        this.servidor = servidor;
        this.setName(nombre);
    }

    @Override
    public void run() {
        synchronized (servidor) {   // Sincronización por segmento del objeto e inicio el método correspondiente a la sección crítica.
            for (int i = 0; i < 10; i++) {  // Hago 10 accesos
                System.out.println("________" + nombre + "_idAcceso_" + i + "________");
                servidor.accederAlServidor(); 
                this.yield();   // Yield para dejar paso después de acceder. 
            }
        }
    }
}
