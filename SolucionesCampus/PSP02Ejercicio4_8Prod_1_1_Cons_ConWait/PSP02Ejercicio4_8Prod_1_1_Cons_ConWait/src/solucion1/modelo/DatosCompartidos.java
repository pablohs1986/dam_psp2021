package solucion1.modelo;


import java.util.logging.Level;
import java.util.logging.Logger;

public class DatosCompartidos {

    public String dato;
    public boolean dato_disponible = false;

    public  String getDato() {
        //metodo que usará el consumidor
        while (dato_disponible == false) {
            //no se ha producido ningun dato
            try { 
               wait(); //forzamos a que deje procesador y espere notificación de que existe dato
            } catch (InterruptedException e) {
                System.out.println("Interrumpido " + Thread.currentThread().getName());
            }
        }
        dato_disponible = false;      
        notifyAll();
        return dato;
    }

    public  void newDato(String dato) {
        //metodo que ejecutara el productor
        while (dato_disponible == true) {
            //ya hay un dato que no ha recogido ningun consumidor
                 
            try {
                wait(); //si hay dato se le fuerza a dejar el procesador hasta que alguien coja el dato
            } catch (InterruptedException e) {
                System.out.println("Interrumpido " + Thread.currentThread().getName());
            }
        }
        this.dato = dato;
        System.out.println("Almacenado el valor: "+dato);
        dato_disponible = true;
        notifyAll();       
    }
}
