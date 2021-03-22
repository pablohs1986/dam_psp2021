package controlador;

import modelo.*;

public class ProductorConsumidorConWaitMain {
    
    public static int numDatosAProducir(){
        //metodo aleatroio para indicar cuantos datos va a producir el consumidor
        return (int) (Math.random()*5 +1);        
    }
    public static void main(String[] args) {
        //creando el recurso compartido almacen
        DatosCompartidos almacen = new DatosCompartidos();
        
        //creando los productores        
        Productor p1 = new Productor(almacen, "prod1 ",numDatosAProducir());
        Productor p2 = new Productor(almacen, "prod2 ",numDatosAProducir());
        Productor p3 = new Productor(almacen, "prod3 ",numDatosAProducir());
        
        //creando el consumidor
        Consumidor c1 = new Consumidor(almacen, "consumidor1 ");      
        
        p1.start();
        p2.start();
        p3.start();
        c1.start();       
         
    }
}
