
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class Cliente {

    static final String HOST = "localhost";
    static final int PUERTO = 2000;
    
    public Cliente() {
        String datos = new String();
        String idCliente = new String();

        // Entrada teclado
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            // Conexion
            Socket socketCliente = new Socket(HOST, PUERTO);
            
            // Flujos entrada y salida
            DataInputStream flujoEntrada = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(socketCliente.getOutputStream());
            
            // Gestión del tiempo -> El cliente calcula el tiempo de la transmision
            datos = flujoEntrada.readUTF();
            long tiempo1 = Long.valueOf(datos); // tiempo recibido del cliente
            long tiempo2 = (new Date()).getTime(); // tiempo actual
            long duracionTransmision = tiempo2 - tiempo1;
            
            System.out.println("El tiempo es: " + duracionTransmision + "ms");
            
            // Cierre conexión
            socketCliente.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) {
        new Cliente();
    }
    
}
