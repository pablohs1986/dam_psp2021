/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Servidor extends Thread {
    
    private Socket socketCliente;
    private int contador;

    public Servidor(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    @Override
    public void run() {
        try {
            // Flujos entrada y salida
            DataInputStream flujoEntrada = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(socketCliente.getOutputStream());
            
            // Atiendo la petición del cliente
            contador = flujoEntrada.readByte();
            System.out.println("Acepto la petición del cliente " + contador);
            flujoSalida.writeUTF("Hola, cliente " + contador + ", te atiendo de forma correcta.");
            
            // Se cierra la conexión
            socketCliente.close();
            System.out.println("Cliente " + contador + " desconectado.");
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
