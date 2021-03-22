package modelo;
import java.util.concurrent.Semaphore;

public class Hilo_Terminal extends Thread {
//clase derivada de Thread que define un hilo

    private ServidorWeb servidor;
    private Semaphore semaforo;
    private String nombreTerminal;

    public Hilo_Terminal(String nombreTerminal,ServidorWeb s, Semaphore se) {
        this.servidor = s;
        this.semaforo = se;
        this.nombreTerminal= nombreTerminal;
       }

    @Override
    public void run() {
        //la tarea del hilo es invocar a incrementaCuenta()simulando un acceso
        // al servidor

        for (int i = 1; i <= 10; i++) //se simulan 10 accesos al servidor
        {
            try {
                semaforo.acquire();
                //en cada acceso se adquiere el recurso 
                //y si está ocupado se bloquea
            } catch (InterruptedException ex) {
            }
            
            servidor.incrementaCuenta(nombreTerminal);
            //adquirido el recurso, invoca a este método para simular el acceso 
            //al servidor incrementado la cuenta de accesos
            semaforo.release();
            //libera el recurso o permiso
            yield();
        }



    }
}
