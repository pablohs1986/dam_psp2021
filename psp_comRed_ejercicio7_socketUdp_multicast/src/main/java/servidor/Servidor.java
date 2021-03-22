/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import cliente.Cliente;
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
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Arrancanto el servidor multicast...");

        try {
            MulticastSocket socket = new MulticastSocket();
            // Grupo multicast
            InetAddress group = InetAddress.getByName("231.0.0.1");
            // Datagrama vacío
            byte[] datagrama = new byte[0];
            DatagramPacket datos = new DatagramPacket(datagrama, 0, group, 10000);

            // Datos a encapsular de la entrada de teclado
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String linea;

            // El servidor envía los datos que lea por teclado hasta que se escriba salir
            do {
                // Se lee la entrada
                System.out.println(">");
                linea = br.readLine();
                // Se crea buffer a enviar
                byte[] buffer = linea.getBytes();
                datos.setData(buffer);
                datos.setLength(buffer.length);
                // Envío
                socket.send(datos);
                
            } while(!linea.equals("salir"));
        
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
