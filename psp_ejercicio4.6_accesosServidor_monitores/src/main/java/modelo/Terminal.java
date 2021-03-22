/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
            servidor.aniadirAcceso();   // Hago un acceso
        }
    }
    
    
    
    
    
}
