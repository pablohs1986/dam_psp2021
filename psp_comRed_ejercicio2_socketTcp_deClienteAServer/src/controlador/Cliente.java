/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Cliente {

    final static String HOST = "localhost";
    final static int PUERTO = 2000;

    public Cliente() {
    
        try {
            Socket socketCliente = new Socket(HOST, PUERTO);
            
            // Tareas cliente
            OutputStream os = socketCliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            int numeroAleatorio = (int)(Math.random()*9)+1;
            System.out.println("Número que se envía al servidor: " + numeroAleatorio);
            dos.writeUTF("Mira, server, te paso el número " + numeroAleatorio);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        new Cliente();
    }
    
}
