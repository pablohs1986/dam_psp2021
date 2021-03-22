/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
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
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("Escucho al puerto " + PUERTO);
            
            for (int i = 0; i < 3; i++) {
                System.out.println("Servidor esperando al mensaje que tiene que mostrar procedente desde el cliente que se conecta...");
                
                Socket socketCliente = serverSocket.accept(); // acepta la conexión
                
                // peticiones
                System.out.println("Sirvo al cliente " + i);
                InputStream is = socketCliente.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                
                // Muestro lo que recibo del cliente
                System.out.println(dis.readUTF());
                
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
