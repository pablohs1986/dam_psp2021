
public class Consumidor extends Thread {

    public DatosCompartidos almacen;
    public String nombre;

    public Consumidor(DatosCompartidos dc, String nmbr) {
        almacen = dc;
        nombre = nmbr;
    }

    public void run() {
        String datoAux; //para recoger el valor mientras no se finaliza la produccion        
        int totalDatosConsumidor = 0;
        synchronized (almacen) {
            while (!almacen.isParar()) {
                datoAux = almacen.getDato(nombre);
                //si cogemos el dato
                if (almacen.getTotalDatos() >= 0 && datoAux != null) {
                    totalDatosConsumidor++;
                    System.out.println(nombre + " " + datoAux + " - cont: " + totalDatosConsumidor);
                    Thread.yield();
                }
            }
        }
        System.out.println("Cierro Hilo consumidor :" + nombre + " Ha cogido " + totalDatosConsumidor);
    }
}
