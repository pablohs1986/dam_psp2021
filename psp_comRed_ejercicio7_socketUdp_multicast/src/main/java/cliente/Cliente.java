/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Cliente esperando mensajes...");
        
        try {
            MulticastSocket socket = new MulticastSocket(10000);
            InetAddress group = InetAddress.getByName("231.0.0.1");
            // Uno al cliente al grupo
            socket.joinGroup(group);
            // Leo los paquetes enviados por el servidor
            String salida = new String();
            while (!salida.equals("salir")) {
                byte[] buffer = new byte[256];
                DatagramPacket datos = new DatagramPacket(buffer, buffer.length);
                socket.receive(datos);
                
                salida = (new String(buffer)).trim();
                System.out.println("Cadena recibida: " + salida + " ");
            }
            
            // Salgo del grupo
            socket.leaveGroup(group);
            socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
