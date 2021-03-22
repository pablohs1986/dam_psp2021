package barberodormilon;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Peluquero extends Thread{
    Peluqueria peluqueria;
    boolean finJornada=false;
    int nClientes;
            
    public Peluquero (Peluqueria peluqueria, int nClientes){
        this.peluqueria=peluqueria;
        this.nClientes = nClientes;
    }
    
    public void run(){        
      while(!finJornada){ 
        peluqueria.PeluqueroAtenderCliente();
        try {
            Thread.sleep(1000); //simula el tiempo que dura el corte de pelo
        } catch (InterruptedException ex) {
            Logger.getLogger(Peluquero.class.getName()).log(Level.SEVERE, null, ex);
        }
        peluqueria.terminarCorte();
        
        //para saber si se ha terminado la jornada y ya no hay
        //mas clientes ni personas esperando ni cortando
        if (!peluqueria.isHayClientesEsperando())
            finJornada=true;
      }
      System.out.println("Cerrando el hilo Peluquero");
    }    
}
