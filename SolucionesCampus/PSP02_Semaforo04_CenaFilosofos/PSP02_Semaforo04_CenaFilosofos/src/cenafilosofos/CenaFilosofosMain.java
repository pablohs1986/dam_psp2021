package cenafilosofos;

public class CenaFilosofosMain {
    public static void main(String[] args) {
        //creo una mesa de 5 filosofos
        int numfilosofos= 5;
        Mesa m = new Mesa(numfilosofos);
        System.out.println("Poniendo la mesa para los "+numfilosofos+" filosofos");
        
        //creo la tabla de filosofos
        Filosofo f[]=new Filosofo[5];
        //Creando los filosofos
        for (int i=0; i<numfilosofos;i++){
            f[i]=new Filosofo(i, m);
            //lanzamos los hilos filosofos f[i]: 1 filosofo = 1 hilo
            f[i].start();
        }
    }
}
