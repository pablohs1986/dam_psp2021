/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
    final static int PUERTO = 2000;
    int sumaNumeros = 0;
    String cadenaNumeros = "";
    int numeroRecibido = 0;
    
    // Array de sockets
    Socket arraySockets[] = new Socket[3];

    public Servidor() {

        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("Escuchando en el puerto " + PUERTO);

            for (int i = 0; i < 3; i++) {
                System.out.println("Servidor esperando el mensaje que tiene que mostrar procedente desde el cliente que se conecta...");
                arraySockets[i] = serverSocket.accept(); // acepto la conexión

                // Peticiones cliente
                System.out.println("Sirvo al cliente " + i);
                InputStream is = arraySockets[i].getInputStream();
                DataInputStream dis = new DataInputStream(is);

                numeroRecibido = dis.read();
                sumaNumeros += numeroRecibido;
                if (i != 2) {
                    cadenaNumeros += String.valueOf(numeroRecibido) + " + ";
                } else {
                    cadenaNumeros += String.valueOf(numeroRecibido);
                }

                System.out.println(cadenaNumeros + " = " + sumaNumeros);
                // Envío al cliente
                OutputStream os = arraySockets[i].getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF(cadenaNumeros + " = " + sumaNumeros);

                arraySockets[i].close();
            }
            System.out.println("Ya se ha atendido a los 3 clientes.");

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        new Servidor();
    }
}
