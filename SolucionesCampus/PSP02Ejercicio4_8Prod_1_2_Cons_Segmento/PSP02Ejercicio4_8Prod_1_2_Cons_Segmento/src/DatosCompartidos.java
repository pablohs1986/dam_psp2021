                                                                                                            
import java.util.logging.Level;
import java.util.logging.Logger;

class DatosCompartidos {

    private String dato;
    private boolean dato_disponible = false;
    private int totalDatos ;
    private boolean parar=false; //variable para controlar cuando 
    //se ha cogido el ultimo dato producido

    public void setDatosCrear(int n) {
        totalDatos = n; //para saber los datos totales 
        // a generar por  el productor
        System.out.println("total datos a crear:" + totalDatos);
    }
    
    public int getTotalDatos(){
        return totalDatos;
    }
    
    public boolean isParar(){
        return parar;
    }

    public void newDato(String dato, String nomHilo) {
        while (dato_disponible) {
            //ya hay un dato que no ha recogido ningun consumidor
            try {
                System.out.println("esperando....." + nomHilo+ "para almacenar..."+dato);
                Thread.yield();
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrumpido " + Thread.currentThread().getName());
            }
        }
        this.dato = dato;
        dato_disponible = true;
        System.out.println("Almacenado: "+this.dato);
        Thread.yield();
        notifyAll();
    }

    public String getDato(String nomHilo) {
        if (totalDatos >0) {
            while (totalDatos >0 && !dato_disponible) {
                //no hay dato para coger
                try {
                    System.out.println("esperando....." + nomHilo);
                    Thread.yield();
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrumpido " + Thread.currentThread().getName());
                }
            }
            dato_disponible = false;
            totalDatos--;
            notifyAll();

        } else {
            //no hay mas datos 
            dato = null;
            dato_disponible = true;//asi los consumidores salen
            parar = true;
            notifyAll();
        }
        return dato;
    }
}
