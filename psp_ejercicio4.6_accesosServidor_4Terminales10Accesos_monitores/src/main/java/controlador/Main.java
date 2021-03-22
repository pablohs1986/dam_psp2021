/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        // 4 terminales
        Terminal terminal1 = new Terminal("Terminal_1", servidor);
        Terminal terminal2 = new Terminal("Terminal_2", servidor);
        Terminal terminal3 = new Terminal("Terminal_3", servidor);
        Terminal terminal4 = new Terminal("Terminal_4", servidor);
            
        terminal1.start();
        terminal2.start();
        terminal3.start();
        terminal4.start();

    }
    
}
