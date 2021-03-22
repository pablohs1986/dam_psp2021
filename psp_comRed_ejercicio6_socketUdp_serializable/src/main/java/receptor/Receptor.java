/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receptor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;

/**
 *
 * @author Pablo Herrero
 */
public class Receptor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int longitud = 4096;
        int puerto = 2000;
        try {
            // Recepción
            DatagramSocket dsocket = new DatagramSocket(puerto);
            DatagramPacket datagrama = new DatagramPacket(new byte[longitud], longitud);
            dsocket.receive(datagrama);
            
            // Convierto el objetoBytes a objeto
            ByteArrayInputStream in = new ByteArrayInputStream(datagrama.getData());
            ObjectInputStream objIn = new ObjectInputStream(in);
            System.out.println("Origen: " + datagrama.getAddress().getHostName() + ": " + datagrama.getPort());
            Persona persona = (Persona) objIn.readObject();
            System.out.println("Objeto recibido: " + persona.toString());
            
            
        } catch (SocketException ex) {
            Logger.getLogger(Receptor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Receptor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Receptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
