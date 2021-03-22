
import java.util.logging.Level;
import java.util.logging.Logger;

class Productor extends Thread {

    public DatosCompartidos almacen;
    public String nombre;
    public int totalDatosProducidos;

    public Productor(DatosCompartidos dc, String nmbr, int n) {
        almacen = dc;
        nombre = nmbr;
        this.totalDatosProducidos = n;

        dc.setDatosCrear(n);//indico al almacen cuantos datos voy a crear
    }

    public void run() {
        for (int i = 1; i <= totalDatosProducidos; i++) {
            synchronized (almacen) {
                almacen.newDato(nombre + i, nombre);
                Thread.yield();
            }
        }
        System.out.println("el productor " + nombre + " ha finalizado de generar datos, cerrando hilo ");
    }
}
