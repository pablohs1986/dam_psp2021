package solucion2.controlador;


import solucion2.controlador.*;
import solucion2.modelo.Productor;
import solucion2.modelo.Consumidor;
import solucion2.modelo.DatosCompartidos;

/* 
ESTA solución funciona pero parece que no va bien si ponemos mensajes en los hilos 
indicando que esta esperando para acceder al almacen para conseguir los datos o para 
guardar un dato
*/
public class ProductorConsumidorConWaitMain {

    public static void main(String[] args) {
        DatosCompartidos datos = new DatosCompartidos();
        int totalDatos = 5;
        Productor p1 = new Productor(datos, "prod1 ",totalDatos);
        Consumidor c1 = new Consumidor(datos, "consumidor1 ",totalDatos);
             
         p1.start();      
         c1.start();
    }
}
