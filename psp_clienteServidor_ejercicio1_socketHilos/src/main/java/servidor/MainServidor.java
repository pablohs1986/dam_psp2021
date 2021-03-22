/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class MainServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int contador = 0;
        final int PUERTO = 2000;
        
        try {
            
            // Inicio el servidor en el puerto
            ServerSocket socketServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho en el puerto " + PUERTO);
            
            while(true) {
                contador++;
                // Acepto la conexión de un cliente
                Socket socketCliente = socketServidor.accept();
                System.out.println("Cliente conectado");
                // Se atiende al cliente mediante un hilo
                new Servidor(socketCliente).start();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(MainServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
