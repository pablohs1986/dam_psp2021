/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.HiloTerminal;
import modelo.Servidor;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        
        for (int i = 0; i < 20; i++) {
            HiloTerminal terminal = new HiloTerminal("Terminal_1 - Usuario_"+i, servidor);
            terminal.start();
        }
    }
    
}
