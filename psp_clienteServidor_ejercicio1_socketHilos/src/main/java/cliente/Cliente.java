/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

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
public class Cliente extends Thread {
    static final String HOST = "localhost";
    static final int PORT = 2000;
    private Socket socketCliente;
    private int contador;

    public Cliente(int contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        try {
            socketCliente = new Socket(HOST, PORT);
            
            // Flujos salida y entrada
            DataInputStream flujoEntrada = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(socketCliente.getOutputStream());
            flujoSalida.writeByte(contador);
            
            // Tareas del cliente
            String datos = flujoEntrada.readUTF();
            System.out.println(datos);
            socketCliente.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
