package Opcion2_Opcion_Optimizada.modelo;



//las visualizaciones de los mensajes lo
//hacemos en el propio método sincronizado
//evitando que se mezcle con otros mensajes de
//otros hilos 

public class Jardin {

    private int contPersonas;

    public Jardin(int totalPersonas) {
        contPersonas = totalPersonas;
    }

    public int getContPersonas() {
        return contPersonas;
    }

    public void setContPersonas(int contPersonas) {
        this.contPersonas = contPersonas;
    }

    public void entraSalirPersonaAlJardin(HiloPersona hilo) {
        
        if (hilo.isEntrar()) {
            System.out.println("++++El hilo " + hilo.getName() + " ENTRA en el jardin");
            contPersonas++;
        } else {
            System.out.println("------El hilo " + hilo.getName() + " SALE en el jardin");
            contPersonas--;
        }

        System.out.println("En número de personas en el jardin = "+contPersonas);
    }

}
