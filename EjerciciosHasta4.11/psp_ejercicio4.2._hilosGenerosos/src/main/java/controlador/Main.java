/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.HiloColor;

/**
 *
 * @author pablo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HiloColor hiloRojo = new HiloColor("Rojo");
        HiloColor hiloAzul = new HiloColor("Azul");
        HiloColor hiloVerde = new HiloColor("Verde");

        hiloRojo.start();
        hiloAzul.start();
        hiloVerde.start();
    }
    
}
