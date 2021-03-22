/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emisor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;

/**
 *
 * @author Pablo Herrero
 */
public class Emisor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObjectOutputStream flujoSalida = null;
        final int longitud = 4096;
        String nombreMaquina = "localhost";
        
        try {
            // Preparo socket y objeto persona
            InetAddress direccionIp = InetAddress.getByName(nombreMaquina);
            int puerto = 2000;
            DatagramSocket dsocket = new DatagramSocket();
            Persona persona = new Persona("Persona_1", 20);
            
            // Convierto objeto a bytes y envío
            ByteArrayOutputStream objetoByte = new ByteArrayOutputStream(longitud);
            flujoSalida = new ObjectOutputStream(objetoByte);
            flujoSalida.writeObject(persona);
            DatagramPacket datagrama = new DatagramPacket(objetoByte.toByteArray(), objetoByte.size(), direccionIp, puerto);
            dsocket.send(datagrama);
            System.out.println("Enviando: " + persona.toString());
            dsocket.close();
            
        } catch (SocketException ex) {
            Logger.getLogger(Emisor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Emisor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
