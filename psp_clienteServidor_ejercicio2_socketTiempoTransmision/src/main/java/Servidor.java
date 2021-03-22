
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
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
public class Servidor {

    static final int PUERTO = 2000;
    
    public Servidor() {
        try {
            ServerSocket socketServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho en el puerto " + PUERTO);
            
            // Acepto conexión de cliente
            Socket socketCliente = socketServidor.accept();
            System.out.println("Cliente conectado");
            
            // Flujos entrada y salida
            DataInputStream flujoEntrada = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(socketCliente.getOutputStream());
            
            // Gestión tiempo
            long tiempo = (new Date()).getTime(); // envía el tiempo actual
            flujoSalida.writeUTF(Long.toString(tiempo));
            
            // Cierre de conexión
            socketCliente.close();
            System.out.println("Cliente desconectado");
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) {
        new Servidor();
    }
    
}
