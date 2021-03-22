
public class Consumidor extends Thread {

    public DatosCompartidos almacenDato;
    public String nombre;
    int totalDatosConsumidor = 0;

    public Consumidor(DatosCompartidos dc, String nmbr) {
        almacenDato = dc;
        nombre = nmbr;
    }

    public void run() {
        String datoAux; //para recoger el valor
        synchronized (almacenDato) {
            while (!almacenDato.isParar()) {
                datoAux = almacenDato.getDato(nombre);
                if (almacenDato.getTotalDatos() >= 0 && datoAux != null) {
                    totalDatosConsumidor++;
                    System.out.println(nombre + " coge " + datoAux + " - cont: " + totalDatosConsumidor);

                }
            }
        }
        System.out.println("Cerrando hilo consumidor " + nombre + ". ha cogido " + totalDatosConsumidor);
    }
}
