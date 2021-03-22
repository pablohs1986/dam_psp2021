
import static java.lang.Thread.yield;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jugador extends Thread {

    private String idJugador;
    private int contPalillosJugador;
    Semaphore semaforoCestaPalillos;

    Jugador(String idJugador, Semaphore s) {
        this.idJugador = idJugador;
        this.semaforoCestaPalillos = s;
        contPalillosJugador = 0;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("------"+idJugador+" INTENTO nº "+ i+" ------");
            //calculo el número de palillos a coger
            int numPalillosACoger = (int) (Math.random() * 3) + 1;

            //compruebo que hay suficientes palillos disponibles para evitar
            //una posible situación de bloqueo de los 3 jugadores
            //de forma que todos estén intentando coger y nadie suelte
            if (semaforoCestaPalillos.availablePermits() > numPalillosACoger) {
                //coge palillos
                try {
                    System.out.println(idJugador + " intenta pillar " + numPalillosACoger + " palillos");
                    semaforoCestaPalillos.acquire(numPalillosACoger);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Ha conseguido coger los " + numPalillosACoger + " palillos");
                contPalillosJugador += numPalillosACoger;
                //imprimo
                System.out.println(idJugador + " tiene " + contPalillosJugador);
                System.out.println(" PALILLOS EN EL CESTO:" + semaforoCestaPalillos.availablePermits());
                //los tiene durante un tiempo
                try {
                    Thread.sleep((int) (Math.random() * 1000) + 500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }

                //libero N palillos
                //calculo el número de palillos a coger
                int numPalillosADejar = (int) (Math.random() * contPalillosJugador) + 1;
                System.out.println(idJugador + " suelta " + numPalillosADejar);

                semaforoCestaPalillos.release(numPalillosADejar);
                contPalillosJugador -= numPalillosADejar;
                System.out.print(idJugador + " se queda con " + contPalillosJugador + " palillos");
                System.out.println("  - PALILLOS EN EL CESTO:" + semaforoCestaPalillos.availablePermits());
            } else {
                System.out.print(idJugador + " no quedan " + numPalillosACoger + " palillos, ");
                System.out.print("solo quedan en el cesto " + semaforoCestaPalillos.availablePermits());
                System.out.println(" PIERDES TURNO ");
            }
            
            //para que el hilo deje el procesador, auqneu no se 
           //garantiza que volverá a entrar el mismo
           Thread.yield();
           //dormimos el hilo para garantizar que pasa su quantum 
            try {
                sleep((int)(Math.random()*500)+500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //salgo del bucle  y finalizo el juego del jugador
        System.out.println("********"+idJugador + " AL FINAL SE QUEDA CON " + contPalillosJugador);
    }
}
