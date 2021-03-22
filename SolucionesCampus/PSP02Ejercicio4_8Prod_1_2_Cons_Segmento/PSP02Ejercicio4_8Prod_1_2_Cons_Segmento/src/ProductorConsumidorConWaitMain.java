
public class ProductorConsumidorConWaitMain {

    public static void main(String[] args) {
        DatosCompartidos datos = new DatosCompartidos();
        int numDatos=10;
        Productor p1 = new Productor(datos, "prod1 ",numDatos);
       
        Consumidor c1 = new Consumidor(datos, "consumidor1 ");
        Consumidor c2 = new Consumidor(datos, "consumidor2 ");
        
        p1.start();
       
        c1.start();
        c2.start();

    }
}
