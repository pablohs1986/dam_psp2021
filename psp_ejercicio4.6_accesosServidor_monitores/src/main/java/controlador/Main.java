/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
        Servidor servidor = new Servidor("Servidor_1");
        
        // Accesos
        for (int i = 0; i < 20; i++) {
            Terminal terminal = new Terminal("Terminal_" + i, servidor);
            terminal.start();
        }
    }
    
}
