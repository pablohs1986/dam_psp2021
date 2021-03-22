package solucion2.modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import solucion2.modelo.*;

public class Productor extends Thread {

    public DatosCompartidos datos;
    public String nombre;
    int totalDatos;

    public Productor(DatosCompartidos dc, String nmbr, int totalDatos) {
        datos = dc;
        nombre = nmbr;
        this.totalDatos = totalDatos;
    }

    public void run() {
        int i;
        for (i=1;i<=totalDatos;i++){
            
            //intento almacenar el dato en datos compartido
            datos.newDato(nombre + i); 
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        System.out.println("se acaba el hilo "+ nombre);
    }
}
