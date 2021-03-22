package controlador;


import modelo.Consumidor;
import modelo.DatosCompartidos;
import modelo.Productor;


public class ProductorConsumidorConWaitMain {

    public static void main(String[] args) {
        DatosCompartidos almacen = new DatosCompartidos();
        int numDatos=10;
        Productor p1 = new Productor(almacen, "prod1 ",numDatos);
       
        Consumidor c1 = new Consumidor(almacen, "consumidor1 ");
        Consumidor c2 = new Consumidor(almacen, "consumidor2 ");
          Consumidor c3 = new Consumidor(almacen, "consumidor3 ");
        p1.start();
       
        c1.start();
        c2.start();
        c3.start();
   

    }
}
