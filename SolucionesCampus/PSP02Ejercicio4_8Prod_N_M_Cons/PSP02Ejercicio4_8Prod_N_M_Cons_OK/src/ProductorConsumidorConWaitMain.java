
public class ProductorConsumidorConWaitMain {

    public static void main(String[] args) {
        DatosCompartidos datos = new DatosCompartidos();
        Productor p1 = new Productor(datos, "prod1 ",2);
        Productor p2 = new Productor(datos, "prod2 ",3);
        Productor p3 = new Productor(datos, "prod3 ",4);
        Consumidor c1 = new Consumidor(datos, "consumidor1 ");
        Consumidor c2 = new Consumidor(datos, "consumidor2 ");
        Consumidor c3 = new Consumidor(datos, "consumidor3 ");
        Consumidor c4 = new Consumidor(datos, "consumidor4 ");
        
        Consumidor c5 = new Consumidor(datos, "consumidor5 ");
        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
         
    }
}
