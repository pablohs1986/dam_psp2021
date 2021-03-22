package cenafilosofos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

class Mesa {

    private Semaphore palillos[];
    private int TotalFilosofos;

    public Mesa(int TotalFilosofos) {
        this.TotalFilosofos = TotalFilosofos;
        palillos = new Semaphore[TotalFilosofos];
        for (int i = 0; i < TotalFilosofos; i++) {
            //inicializo cada palillo con un semáforo binario
            palillos[i] = new Semaphore(1);
        }
    }

    public int mi_palillo_derecho(int i) {
        return (i + TotalFilosofos - 1) % TotalFilosofos;
    }

    public int mi_palillo_izquierdo(int i) {
        return i;
    }

    //para saber si tiene los palillos disponibles o no
    public boolean tieneLosPalillos(int numFilosofo) {
        int der = mi_palillo_derecho(numFilosofo);
        int izq = mi_palillo_izquierdo(numFilosofo);
        return (palillos[der].availablePermits() == 0 && palillos[izq].availablePermits() == 0) ? true : false;
    }

    public void pensar(int numFilosofo) {
        int der = mi_palillo_derecho(numFilosofo);
        int izq = mi_palillo_izquierdo(numFilosofo);
        //aqui miramos si el filosofo no tiene los palillos o 
        //si por el contrario sus palillos estan cogidos pero no
        //por el sino por sus vecinos de los lados que podría llevar a 
        //confusión pensando que si los palillos suyos estan cogidos
        //el filosofo quiere comer, cuando quien los tiene cogidos son
        //los filosofos de al lado
        if (!tieneLosPalillos(numFilosofo)|| !((palillos[der].availablePermits() != 0) && (palillos[izq].availablePermits() != 0))) {
            //si no tiene los palillos se pone a pensar
            try {
                System.out.println("Filosofo " + numFilosofo + " se pone a PENSAR");
                int delay = (int) (Math.random() * 500) + 2000;
                Thread.sleep(delay);
                System.out.println("Filosofo " + numFilosofo + " ha dejado de pensar");
            } catch (InterruptedException e) {
            }
        }
    }

    public void comer(int numFilosofo) {
        if (tieneLosPalillos(numFilosofo)) {
            System.out.println("Filosofo " + numFilosofo + " COMIENDO");
            int delay = (int) (Math.random() * 500) + 1000;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Filosofo " + numFilosofo + " ha terminado de comer");
        }
    }

    // EL FILOSOFO id intenta SUS TENEDORES
    public boolean cogerPalillos(int numFilosofo) {
        boolean tieneLosPalillos;
        System.out.print(" Tengo hambre, intentando coger sus palillos. ");
        int der = mi_palillo_derecho(numFilosofo);
        int izq = mi_palillo_izquierdo(numFilosofo);
        //solo coge los palillos si estan disponibles
        if ((palillos[der].availablePermits() != 0) && (palillos[izq].availablePermits() != 0)) // si los palillos libres
        {
            try {
                palillos[der].acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            try {
                palillos[izq].acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("f" + numFilosofo + " He podido coger mis palillos izd:" + izq + " dcho:" + der);
            tieneLosPalillos = true;
        } else {
            System.out.println(" Algún palillo está ocupado. Vuelvo a PENSAR");
            tieneLosPalillos = false;
        }
        return tieneLosPalillos;
    }

    // EL FILOSOFO id SUELTA SUS TENEDORES
    public void soltarPalillos(int numFilosofo) {
        //localizo la situacion de los tenedores del filosofo
        if (tieneLosPalillos(numFilosofo)) {
            //localizo la situacion de los tenedores del filosofo
            int der = mi_palillo_derecho(numFilosofo);
            int izq = mi_palillo_izquierdo(numFilosofo);
            System.out.println("f" + numFilosofo + " DEJA sus palillos izd:" + izq + " dcho:" + der);
            palillos[der].release();
            palillos[izq].release();
        }
    }
}
