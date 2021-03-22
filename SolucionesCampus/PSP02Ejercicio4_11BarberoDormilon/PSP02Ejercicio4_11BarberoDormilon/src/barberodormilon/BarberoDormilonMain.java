package barberodormilon;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BarberoDormilonMain {
    public static void main(String[] args) {
   
      //objeto representa al peluquero
      Peluquero peluquero;
            
      //objeto que representa la peluquería
      Peluqueria peluqueria;
      
      //numero clientes llegan a la peluquería, por ejemplo 10
      int nClientes=10;
      Cliente cli;
      
      //creo la peluqueria con 5 sillas de espera
      peluqueria=new Peluqueria(5,nClientes);
      //creo el peluquero
      peluquero=new Peluquero(peluqueria, nClientes);
      //arranco el peluquero
      peluquero.start();
      for(int i=0;i<nClientes;i++)
      {//a cada cliente le paso su nombre y la peluqueria
         cli=new Cliente("Cliente"+i,peluqueria);
        //arranco el cliente
        cli.start(); 
            try {
              Thread.sleep(500);
          } catch (InterruptedException ex) {
              Logger.getLogger(BarberoDormilonMain.class.getName()).log(Level.SEVERE, null, ex);
          }
        }      
}
}