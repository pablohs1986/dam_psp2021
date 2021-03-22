
import java.util.logging.Level;
import java.util.logging.Logger;

class DatosCompartidos {

    private String dato;
    private boolean dato_disponible = false;
    private int totalDatos = 0;
    private boolean parar = false;

    public void totalDatosCrear(int n) {
        totalDatos += n; //para saber los datos totales 
        // agenerar por los distintos productores
        System.out.println("Se ha creado un nuevo productor creara "+n+" datos. total datos a crear ahora es..." + totalDatos);
    }

    public int getTotal() {
        return totalDatos;
    }

    public boolean isParar() {
        return parar;
    }

    public int getTotalDatos() {
        return totalDatos;
    }
    
    public void newDato(String dato, String nomHilo) {
        while (dato_disponible) {
            //ya hay un dato que no ha recogido ningun consumidor
            try {
                System.out.println("esperando...." + nomHilo);
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrumpido " + Thread.currentThread().getName());
            }
        }
        this.dato = dato;
        dato_disponible = true;
        System.out.println("almacenado "+ dato);
        Thread.yield();
        notifyAll();
    }

    public String getDato(String nomHilo) {
        if (totalDatos > 0) {
            while (totalDatos > 0 && !dato_disponible) {
                //no hay dato para coger
                try {
                    System.out.println("esperando.... "+nomHilo+" para coger dato");
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrumpido " + Thread.currentThread().getName());
                }
            }

            dato_disponible = false;
            totalDatos--;
            Thread.yield();
            notifyAll();
        } else {
            //Ya los productores generaron todos los valores 
            dato = null;
            dato_disponible = true;//asi los consumidores que estan pendientes salen
            parar = true;
            notifyAll();
        }
        return dato;
    }
}
