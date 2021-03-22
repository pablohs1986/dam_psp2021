package opcion1_dosHilos.controlador;


import opcion1_dosHilos.modelo.HiloPersonaEntra;
import opcion1_dosHilos.modelo.HiloPersonaSale;
import opcion1_dosHilos.modelo.Jardin;

/*
    ESTA SOLUCION NO FUNCIONA BIEN YA QUE CUALQUIERA 
    DE LOS  HILOS generado PUEDE ACCEDER AL JARDIN Y CONCRETAMENTE
    AL CONTADOR PUDIENDO PRODUCIRSE SITUACIONES COMO
    QUE DOS HILOS QUE ENTRAN AL JARDIN A LA VEZ (DOS PROCESADORES)
    LEAN EL CONTADOR Y AL ENTRAR LOS DOS A LA VEZ LEEN EL
    MISMO VALOR Y CADA UNO INCREMENTA EN UNO, PERO COMO 
    LEYERON EL MISMO VALOR LOS DOS HILOS AUNQUE ENTRAN LOS
    DOS EL CONTADOR REALMENTE SE INCREMENTARÁ EN 1 SOLO
*/
public class GestionJardin {

    public static void main(String[] args) {
        //creamos el jardin ya con 100 personas
        Jardin jardinCiudad = new Jardin(100);
         
        
        for(int i=1; i<=40;i++){
            new HiloPersonaEntra("entra Persona "+i,jardinCiudad).start();
        }
        
        for(int j=1; j<=35;j++){
            new HiloPersonaSale("sale Persona "+j,jardinCiudad).start();
        }
    }
}
