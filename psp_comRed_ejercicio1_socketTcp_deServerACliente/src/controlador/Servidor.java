/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Servidor {

    static final int PUERTO = 2000;

    public Servidor() {
        try {
            ServerSocket socketServidor = new ServerSocket(PUERTO);
            System.out.println("Escuchando al puerto " + PUERTO);
            
            for (int i = 0; i < 3; i++) {
                Socket socketCliente = socketServidor.accept(); // acepta la conexión 
                
                // Peticiones
                System.out.println("Sirvo al cliente " + i);
                OutputStream os = socketCliente.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF("Hola, cliente " + i + ", soy tu servidor");
                socketCliente.close();
            }
            System.out.println("Todos los clientes atendidos.");
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args) {
        new Servidor();
    }
    
}
