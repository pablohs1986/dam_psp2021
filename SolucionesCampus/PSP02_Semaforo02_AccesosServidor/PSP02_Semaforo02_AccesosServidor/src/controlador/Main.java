package controlador;

import modelo.ServidorWeb;
import modelo.Hilo_Terminal;
import java.util.concurrent.Semaphore;
/**Se trata de simular el acceso simultáneo de 4 terminales (hilos) a un servidor
 * y llevar la cuenta de accesos en cada instante. Desde cada terminal se
 * simularán 10 accesos.
 */
public class Main {
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(1);
       //semáforo para las secciones críticas de esta clase (permisos 1)
        ServidorWeb servidor = new ServidorWeb();
       //crea un objeto ServidorWeb
        Hilo_Terminal hterminal1 = new Hilo_Terminal("terminal1",servidor, semaforo);
        Hilo_Terminal hterminal2 = new Hilo_Terminal("terminal2",servidor, semaforo);
        Hilo_Terminal hterminal3 = new Hilo_Terminal("terminal3",servidor, semaforo);
        Hilo_Terminal hterminal4 = new Hilo_Terminal("terminal4",servidor, semaforo);
        //Se crean cuatro hilos

        hterminal1.start();
        hterminal2.start();
        hterminal3.start();
        hterminal4.start();
        //se inician los cuatro hilos
    }

}
