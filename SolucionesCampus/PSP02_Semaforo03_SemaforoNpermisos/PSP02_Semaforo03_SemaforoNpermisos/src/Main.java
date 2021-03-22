

import java.util.concurrent.Semaphore;
/**
 */
public class Main {
    
    public static void main(String[] args) {
       
        Semaphore semaforoCestaPalillos = new Semaphore(6);
       //semáforo para las secciones críticas de esta clase (permisos 1)
        System.out.println("Número disponible de palillos:"+semaforoCestaPalillos.availablePermits() );      
        Jugador j1 = new Jugador("j1", semaforoCestaPalillos);
        Jugador j2 = new Jugador("j2", semaforoCestaPalillos);
        Jugador j3 = new Jugador("j3", semaforoCestaPalillos);
        j1.start();
        j2.start();
        j3.start();
    }
}
