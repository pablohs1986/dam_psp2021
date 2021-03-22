
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pablo Herrero
 */
public class Usuario extends Thread {

    private MulticastSocket msocket;
    private DatagramPacket recv;

    public Usuario(MulticastSocket msock) {
        msocket = msock;
    }

    public void run() {

        String mensaje;
        try {
            for (;;) {
                byte[] buf = new byte[1000];
                recv = new DatagramPacket(buf, buf.length);
                msocket.receive(recv);
                //para coger el tamaño justo del mensaje

                mensaje = (new String(buf)).trim();

                System.out.println("\n\nRecibido: \"" + mensaje + "\"\nMensaje Longitud: " + mensaje.length());
            }

        } catch (IOException e) {
            System.out.println("Cerrando el hilo");
            //e.printStackTrace();
        } finally {
            msocket.close();
        }
    }
    
}
