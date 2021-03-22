package ejhilosgrafico;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.*;
/**
 *
 * @author Mª Alejandra Tomás Fernández
 */
public class HiloPestania2 extends Thread {
    private JPanel p2;
    private JLabel lb;
    JTextArea textoCuenta;
    private boolean terminar=false; //controla la parada del bucle de contar
    private int cont=0; //contador para la cuenta
    private JTabbedPane panelconpestanias; //panel que contendrá las pestañas
    
    
    //CONSTRUCTOR
    public HiloPestania2(JTabbedPane panel){
        super();
        //le paso el panel con pestañas para luego añadir una pestaña nueva desde aquí
        this.panelconpestanias=panel;
    }
    
    /** método que cuenta infinitamente y lo muestra en el textarea*/
    public void contar(){
         while(!terminar){
            //inserto cada nueva cuenta arriba del todo del Textarea, para que lo vea siempre
            //Es la posición 0.
            this.textoCuenta.insert("CONTADOR = "+cont+"\n",0);
            cont++;
            try {
                //uso sleep para ralentizar un poco el contador y poder verlo
		Thread.sleep(1000);
            } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }
        }
    
    }
    
    public void parar(boolean parando){
        if (parando==true)
            this.terminar=true;
    }
    
    @Override
    public void run(){
        
        //creo el panel para situar luego en la pestaña 2
        p2=new JPanel(null);
        
        //etiqueta que muestra "ESTOY CONTANDO!!!"
        lb=new JLabel();
        //sitúa la etiqueta donde quiero
        lb.setBounds(10,10,200,25);
        //pongo el texto a la etiqueta
        lb.setText("ESTOY CONTANDO!!!!!!!!!!");
        //añado la etiqueta al panel
        p2.add(lb);
        
        //textarea para mostrar el contenido de la cuenta que hace el hilo
        textoCuenta=new JTextArea();
        //coloco el textarea donde quiero
        textoCuenta.setBounds(10,50,200,200);
        //añado el textarea al panel
        p2.add(textoCuenta);
        
        //añado el panel p2 que ejecuta este hilo al panel de pestañas
        panelconpestanias.addTab("PESTAÑA 2 ", null, this.p2, "Hilo que está contando");
        
        //´Código que hace la cuenta infinita
       this.contar();
       
       
     
        
    
        
       
    }
}
