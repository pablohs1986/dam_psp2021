
package bancoparque;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AplicacionBancoParque {

    public static void main(String[] args) {
        //numero de plazas en el banco
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce cuantas plazas tiene el banco:");
        int numPlazasBanco = teclado.nextInt();
        BancoParque banco=new BancoParque(numPlazasBanco);
        
        //creamos 10 personas que pasean por el parque y se van a sentar
        for (int i = 1; i <= 5; i++) {          
            
            Persona p = new Persona("p"+i);
            (new PersonaEnElParque(p, banco)).start();
            //tiempo transcurrido mientras pueda llegar otra persona
            long tiempo = (long) ( Math.random() * 500);
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(AplicacionBancoParque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
