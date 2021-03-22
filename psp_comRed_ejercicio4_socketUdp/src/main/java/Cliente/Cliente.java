/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
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
        if (args.length != 1) {
            System.out.println("Se necesita 1 argumento en el main");
        } else {
            int port = Integer.parseInt(args[0]);
            final int LONGITUD_MAXIMA = 10;
            try {
                DatagramSocket mySocket = new DatagramSocket(port);
                // Instancia de datagramSocket para recibir datos
                byte[] buffer = new byte[LONGITUD_MAXIMA];
                DatagramPacket datagram = new DatagramPacket(buffer, LONGITUD_MAXIMA);
                mySocket.receive(datagram);
                String message = new String(buffer);
                System.out.println("Mensaje recibido en el cliente: " + message);
                mySocket.close();
            } catch (SocketException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
