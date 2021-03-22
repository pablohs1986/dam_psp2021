package controlador;



import modelo.HiloPingPong;
import java.util.concurrent.Semaphore;
/**Se trata de simular el acceso simultáneo de 4 terminales (hilos) a un servidor
 * y llevar la cuenta de accesos en cada instante. Desde cada terminal se
 * simularán 10 accesos.
 */
public class Main {
    public static void main(String[] args) {
        Semaphore semaforoPelota = new Semaphore(1);
       //semáforo para las secciones críticas de esta clase (permisos 1)
                
        HiloPingPong j1 = new HiloPingPong("PING", semaforoPelota);
        HiloPingPong j2 = new HiloPingPong("pong", semaforoPelota);

        j1.start();
        j2.start();
    }
}
