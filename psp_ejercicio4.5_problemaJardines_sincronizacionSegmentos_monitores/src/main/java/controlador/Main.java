/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.HiloPuertaEntrada;
import modelo.HiloPuertaSalida;
import modelo.Jardin;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jardin jardin = new Jardin(100);
        
        // Entradas
        for (int i = 0; i < 10; i++) {
            HiloPuertaEntrada hiloEntrada = new HiloPuertaEntrada("Entra_"+i, jardin);
            hiloEntrada.start();
        }
        
        // Salidas
        for (int i = 0; i < 15; i++) {
            HiloPuertaSalida hiloSalida = new HiloPuertaSalida("Sale_"+i, jardin);
            hiloSalida.start();
        }
    }
    
}
