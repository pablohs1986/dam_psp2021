/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Servidor;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int PUERTO = 2000;
        Socket socketCliente;
        CyclicBarrier barrera = new CyclicBarrier(4);
        int arrayNumeros[] = new int[3];
        
        try {
            ServerSocket socketServidor = new ServerSocket(PUERTO);
            System.out.println("Escuchando en el puerto " + PUERTO);
            System.out.println("Servidor esperando el mensaje que tiene que mostrar procedente desde el cliente que se conecta...");
            for (int i = 0; i < 3; i++) {
                socketCliente = socketServidor.accept(); // se acepta la conexión
                new Servidor(barrera, socketCliente, arrayNumeros, i).start();
            }
            
            // Se espera a que los 3 clientes estén conectados para seguir...
            barrera.await();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int suma = 0;
        String mensaje = "";
        for (int i = 0; i <= 2; i++) {
            suma += arrayNumeros[i];
            if (i < 3)
                mensaje += arrayNumeros[i] + "+";
            else
                mensaje += arrayNumeros[i] + "=";
        }
        mensaje+=suma;
        System.out.println(mensaje);
        System.out.println("Se ha atendido a todos los clientes.");
        
        
    }
    
}
