
import java.util.logging.Level;
import java.util.logging.Logger;

class Productor extends Thread {

    public DatosCompartidos almacenDato;
    public String nombre;
    public int n = 0;

    public Productor(DatosCompartidos dc, String nmbr, int n) {
        almacenDato = dc;
        nombre = nmbr;
        this.n = n;
        dc.totalDatosCrear(n);
    }

    public void run() {
        for (int i = 1; i <= n; i++) {
            synchronized (almacenDato) {
                almacenDato.newDato(nombre + i, nombre);
            }
        }
        System.out.println("el productor " + nombre + " ha finalizado de generar sus " + n + " datos");
    }
}
