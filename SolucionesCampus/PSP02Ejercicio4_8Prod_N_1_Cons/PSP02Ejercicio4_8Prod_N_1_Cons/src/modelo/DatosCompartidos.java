package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DatosCompartidos {

    private String datoProducido;
    private boolean dato_disponible = false;
    private int totalDatosAProducir;  //para ir decrementando hasta que llegue a 0 y parar
    private boolean parar = false; //variable static para controlar cuando 
    //se ha cogido el ultimo dato producido

    public void setDatosCrear(int n) {
        totalDatosAProducir += n; //para saber los datos totales 
        // a generar por  el productor
        System.out.println("total datos a crear por los productores:" + totalDatosAProducir);
    }

    public int getTotalDatosAProducir() {
        return totalDatosAProducir;
    }

    public boolean isParar() {
        return parar;
    }

    public synchronized void newDato(Productor productor, String datoProducido) {
        String mensaje;

        while (dato_disponible) {
            //ya hay un dato que no ha recogido ningun consumidor
            try {
                System.out.println("esperando....." + productor.getNombre());
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrumpido " + Thread.currentThread().getName());
            }
        }
        this.datoProducido = datoProducido;
        totalDatosAProducir--;
        mensaje = productor.getNombre() + " ha producido el dato " + datoProducido;
        mostrarMensaje(mensaje);
        dato_disponible = true;
        notifyAll();
    }

    public synchronized void getDato(Consumidor consumidor) {
        String mensaje = null;
        if (totalDatosAProducir > 0) {
            while (!dato_disponible) {
                //no hay dato para coger
                try {
                    System.out.println("esperando....." + consumidor.getNombre());
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrumpido " + Thread.currentThread().getName());
                }
            }

            if (datoProducido != null) {  //si hay datoel consumidor puede coger el dato y lo contabiliza para ese hilo
                //solo si hay datos cuando llega al final el productor
                //un hilo coge el ultimo dato y los demas hilos al desbloquearse no
                //pasan por aqui para no  contabilizar 

                int numDatosCogidosPorConsumidor = consumidor.getTotalDatosConsumidor();
                numDatosCogidosPorConsumidor++;
                consumidor.setTotalDatosConsumidor(numDatosCogidosPorConsumidor);
                mensaje = consumidor.getNombre() + " ---coge ---> " + datoProducido + " - cont: " + consumidor.getTotalDatosConsumidor();

                mostrarMensaje(mensaje);
                datoProducido = null;  //vaciamos el almacen
                dato_disponible = false;
                notifyAll();
            }

        } else {
            //no hay mas datos
            //el consumidor que coja el ultimo dato vacia el almacen para avisar a los demas
            //consumidores que estan esperando que no se crean mas datos y que puedan desbloquearse
            // y que no cuenten cuando se desbloqueen que cogen un nuevo dato
            datoProducido = null;
            dato_disponible = true;//asi los consumidores salen del desbloqueo
            parar = true; //hace que el consumidor salga del bucle y  muera el hilo
            mensaje = "Ya se ha dejado de producir datos";

            mostrarMensaje(mensaje);
            notifyAll();
        }

    }

    public synchronized void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}
