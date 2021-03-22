package controlador;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pablo Herrero
 */
public class Cliente {
    
    static final String HOST = "localhost";
    static final int PUERTO = 2000;

    public Cliente() {
        try {
            Socket socketCliente = new Socket(HOST, PUERTO);
            
            // Tareas cliente
            InputStream is = socketCliente.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            System.out.println(dis.readUTF()); // lee lo que le llega del server
            socketCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    public static void main(String[] args) {
        new Cliente();
    }
}
