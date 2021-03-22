package modelo;


import static java.lang.Thread.yield;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloPingPong extends Thread {

    private String sonidoJugador;
    Semaphore semaforoPelota;
    static private String ultimoJugadorGolpeo = null;

    public HiloPingPong(String sonidoJugador, Semaphore s) {
        this.sonidoJugador = sonidoJugador;
        this.semaforoPelota = s;
    }

    public void run() {
        int i = 0;
        do {
            //para garantizar que golpean alternativamente los jugafores
            if (ultimoJugadorGolpeo != sonidoJugador) {
                i++;
                //bloqueo el recurso
                try {
                    semaforoPelota.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloPingPong.class.getName()).log(Level.SEVERE, null, ex);
                }
                //imprimo
                System.out.println(sonidoJugador + " ");
                //libero el recurso
                ultimoJugadorGolpeo = sonidoJugador;
                semaforoPelota.release();
            }
            yield();
        } while (i <= 10);
    }
}

