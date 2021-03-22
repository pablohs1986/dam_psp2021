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
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Servidor extends Thread {
    
    private CyclicBarrier barrera;
    private Socket socketCliente;
    private int[] arrayNumeros;
    private int idCliente;

    public Servidor(CyclicBarrier barrera, Socket socketCliente, int[] arrayNumeros, int idCliente) {
        this.barrera = barrera;
        this.socketCliente = socketCliente;
        this.arrayNumeros = arrayNumeros;
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        InputStream entradaDatos = null;
        OutputStream salidaDatos = null;
        
        System.out.println("Servidor esperando el id del cliente...");
        try {
            entradaDatos = socketCliente.getInputStream();
            DataInputStream dis = new DataInputStream(entradaDatos);
            // Cargo datos y muestro
            arrayNumeros[idCliente] = dis.readInt();
            System.out.println("El cliente con id: " + idCliente + " envía un... " + arrayNumeros[idCliente]);
            
            // Se frena al cliente para que espere a que se conecten y envien 
            // el resto de clientes su número. Una vez enviado el últomo, el programa
            // levanta la barrera y cada servidor calcula su suma.
            barrera.await();
            
            // Una vez levantada la barrera, se calcula la suma
            int suma = 0;
            String mensaje = "";
            for (int idCliente = 0; idCliente <= 2; idCliente++) {
                suma+=arrayNumeros[idCliente];
                if (idCliente < 2) {
                    mensaje += arrayNumeros[idCliente];
                } else {
                    mensaje += arrayNumeros[idCliente];
                }
                mensaje += suma;
            }
            
            // Envio del mensaje
            salidaDatos = socketCliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(salidaDatos);
            dos.writeUTF(mensaje);
            
            // Cierre
            socketCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
