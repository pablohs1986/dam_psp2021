package opcion2_unHiloSolo.modelo;


public class Jardin {
        private int contPersonas;
        
        public Jardin(int totalPersonas){
            contPersonas= totalPersonas;
        }
        
        public  void EntraOSalePersona_Jardin(){
            //muestra el hilo que entra en el método
            System.out.println("hilo "+ Thread.currentThread().getName()+
                    " ----- Entra en el jardín ");
         
            //incrementa el número de personas que hay en el jardin
            contPersonas++;
           
            //mostramos el total de personas que hay
            System.out.println("personas en el jardín: "+contPersonas);
        }        
      
}