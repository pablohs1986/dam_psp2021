/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

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
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Se necesitan 3 argumentos en el main (servidor, puerto, mensaje");
        } else {
            System.out.println(args[0] + " " + args[1] + " " + args[2]);
            try {
                InetAddress receiverHost = InetAddress.getByName(args[0]);
                int receiverPort = Integer.parseInt(args[1]);
                String message = args[2];
                System.out.println("host: " + receiverHost);
                System.out.println("port: " + receiverPort);
                System.out.println("message: " + message);
                
                // Instancia de datagramSocket para enviar datos
                DatagramSocket mySocket = new DatagramSocket(); // conexión
                byte[] buffer = message.getBytes();
                DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, receiverHost, receiverPort); // datos a enviar
                mySocket.send(datagram);
                System.out.println("Enviando datagrama");
                mySocket.close();
            } catch (UnknownHostException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SocketException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
