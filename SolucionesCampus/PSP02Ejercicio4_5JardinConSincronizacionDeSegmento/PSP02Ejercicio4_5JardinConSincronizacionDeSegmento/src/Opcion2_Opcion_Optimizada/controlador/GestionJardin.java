package Opcion2_Opcion_Optimizada.controlador;

import Opcion2_Opcion_Optimizada.modelo.*;


public class GestionJardin {

    public static void main(String[] args) {
        //creamos el jardin ya con 100 personas
        Jardin jardinCiudad = new Jardin(100);
        int valor;
        boolean entrar=false;     
        String nombreHilo;
        
        for(int i=1; i<=30;i++){
            
            nombreHilo= "P"+i;
            System.out.println("Creando el hilo "+nombreHilo);
            new HiloPersona(nombreHilo,jardinCiudad).start();
        }
        

    }
}
