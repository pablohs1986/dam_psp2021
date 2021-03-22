/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pablo Herrero
 */
public class HiloTerminal extends Thread {
    private Servidor servidor;

    public HiloTerminal(String nombreUsuario, Servidor servidor) {
        this.setName(nombreUsuario);
        this.servidor = servidor;
    }

    @Override
    public void run() {
        synchronized (servidor){
            servidor.anadirAcceso();
        }
    }

    
    

    
    
    
}
