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
public class HiloPuertaEntrada extends Thread {
    private String nombre;
    private Jardin jardin;

    public HiloPuertaEntrada(String nombre, Jardin jardin) {
        this.nombre = nombre;
        this.jardin = jardin;
        this.setName(nombre);
    }

    @Override
    public void run() {
        synchronized(jardin) {
            jardin.incrementarPersonas();
        }
    }
    
}
