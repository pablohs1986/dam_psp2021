package opcion2_unHiloSolo.controlador;

import opcion2_unHiloSolo.modelo.HiloPersona;
import opcion2_unHiloSolo.modelo.Jardin;


/*
    en esta solución se crea un hilo solo que puede entrar o salir
    en función de un aleatorio cuando crea la persona hilo. Pero 
    estaríamos en el mismo caso que en la solución anterior
    - dos hilos que intentan entrar (dos procesos cada uno en un 
    procesador) pueden leer a la vez el contador y cuando ejecutan
    su run le incrementan 1 pero al leer el mismo valor aunque entran
    dos solo aparece el contador incrementado en una unidad.
    Además tenemos el problema de visualizar la información de los
    dos hilos en la pantalla (donde solo puede pintar uno, nunca
    los dos a la vez)-
*/
public class GestionJardin {

    public static void main(String[] args) {
        //creamos el jardin ya con 100 personas
        Jardin jardinCiudad = new Jardin(100);
         
        
        for(int i=1; i<=40;i++){
            new HiloPersona("P"+i,jardinCiudad).start();
        }
        
    }
}
