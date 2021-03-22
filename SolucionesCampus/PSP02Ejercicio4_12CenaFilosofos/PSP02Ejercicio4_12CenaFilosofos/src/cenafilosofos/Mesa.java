package cenafilosofos;

class Mesa {

    private boolean[] palilloLibre;
    private int totalFilosofos;

    public Mesa(int filosofos) {        
        this.totalFilosofos = filosofos;
        palilloLibre = new boolean[totalFilosofos];
        for (int i = 0; i < totalFilosofos; i++) {
            palilloLibre[i] = true;
        }
    }

    public int mi_palillo_derecho(int i) {
        return (i + 1) % totalFilosofos;
    }

    public int mi_palillo_izquierdo(int i) {
        return i;
    }

    // EL FILOSOFO id intenta SUS TENEDORES
    public synchronized void cogerPalillos(int numFilosofo) {

        System.out.println("Tengo hambre, intentando coger mis palillos ");
        //localizo la situacion de los tenedores del filosofo
        int der= mi_palillo_derecho(numFilosofo);
        int izq = mi_palillo_izquierdo(numFilosofo);
        while (!palilloLibre[der] || !palilloLibre[izq]) // ESPERA x 2 TENEDORES
        {   
            try { //si entra aquí tiene que esperar, alguno esta ocupado
                System.out.println("f"+numFilosofo+" no puede coger palillos, estan ocupados");
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("f"+numFilosofo +" YA ha podido coger sus palillos izd:"+izq+" dcho:"+der);
        palilloLibre[der]=false;
        palilloLibre[izq]=false;
        notifyAll();
    }

    // EL FILOSOFO id SUELTA SUS TENEDORES
    public synchronized void soltarPalillos(int numFilosofo) {
        //localizo la situacion de los tenedores del filosofo
        int der= mi_palillo_derecho(numFilosofo);
        int izq = mi_palillo_izquierdo(numFilosofo);
        System.out.println("f"+numFilosofo+" YA deja sus palillos izd:"+izq+" dcho:"+der);
        palilloLibre[der]=true;
        palilloLibre[izq]=true;
        notify();
    }    
}
