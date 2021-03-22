/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
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
        
        byte[] buffer = new byte[256];
        try {
            // Conexión a servidor
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");
            System.out.println("Cliente solicitando conexion...");
            String mensaje = "Cliente conectado";
            buffer = mensaje.getBytes();
            
            // Envío de mensaje
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 9090);
            socket.send(packet);
            // Recepción de mensaje
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData()));
            
        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
