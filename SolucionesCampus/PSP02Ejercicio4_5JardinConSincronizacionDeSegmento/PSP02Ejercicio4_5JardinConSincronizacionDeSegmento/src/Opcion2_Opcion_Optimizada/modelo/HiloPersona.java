package Opcion2_Opcion_Optimizada.modelo;

/*
usamos un solo hilo que podrá ser de entrada o salida
en funcion de un boolean, que se establecerá cuando
creemos el hilo
*/
public class HiloPersona extends Thread {

    private Jardin j;
    private boolean entrar;

    public boolean isEntrar() {
        return entrar;
    }

    public void setEntrar(boolean entrar) {
        this.entrar = entrar;
    }

    
    public HiloPersona(String nombreHilo, Jardin j) {
        //asigamos la puerta de salida al jardin 
        //y un nombre a dicha puerta
        this.j = j;
        this.setName(nombreHilo); //atributo name del Thread
        this.entrar = (((int) (Math.random()*2))==0)?false:true;
    }

    public void run() {
        //bloqueamos todo el jardin y solo un hilo puede acceder
        //a el, si hubiera más métodos otros hilos no podrían
        //acceder a esos métodos. como solo es un método
        //impediría que cualquier hilo entrara cuando ya lo tiene
        //otro hilo y asi visualiza los mensajes e incrementa o decrementa
        //el contador, evitando que se entremezclen los mensajes
        //en el recurso compartido pantalla.
       synchronized (j){
           j.entraSalirPersonaAlJardin(this);
       }
      }
}
