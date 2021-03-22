package barberodormilon;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Thread{
    Peluqueria peluqueria;
    String nombre; //nombre del cliente
    
    public Cliente(String nombre,Peluqueria peluqueria){
        this.nombre=nombre;
        this.peluqueria=peluqueria;
    }
    
    public void run(){
        System.out.println("Llega el cliente "+nombre);
        peluqueria.entrarCliente(nombre);        
    }
}
