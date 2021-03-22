/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Cliente {

    static final int PUERTO = 2000;
    static final String HOST = "localhost";

    public Cliente() {

        try {
            Socket socketCliente = new Socket(HOST, PUERTO);

            // Tareas
            OutputStream os = socketCliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            int numeroAleatorio = (int) (Math.random() * 99) + 1;
            System.out.println("He generado el número " + numeroAleatorio
                    + " y se lo envío al servidor para que lo sume");
            dos.write(numeroAleatorio);

            // Recepción de mensaje del server
            InputStream is = socketCliente.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            System.out.println("Respuesta recibida del servidor: " + dis.readUTF());
            socketCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new Cliente();
    }
    
}
