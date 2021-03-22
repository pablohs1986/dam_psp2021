package ejhilosgrafico;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
        

/**
 *
 * @author MªAlejandra Tomás Fernández
 */
public class EjHilosGrafico implements ActionListener{
    /**
     * @param args the command line arguments
     */
    
       
    public static String obtenerPrimeraLinea(JTextArea texto){
    //extraigo el texto del Textarea  entero
    String linea=texto.getText();
    //creo un array de strings con cada línea del textarea
    String []lineas=linea.split("\n");
    //cojo la primera línea del textarea que es la cuenta actual
    return(lineas[0]);
}
    

  public static void main(String[] args) {
           
   
        //ventana principal
        JFrame ventana=new JFrame("PROGRAMA PRINCIPAL");
        ventana.setSize(500, 500);
        
        //control con pestanias, se llama JTabbedPane
        JTabbedPane panelconpestanias=new JTabbedPane();
    
        //pestania 1 que ejecuta el programa principal, será un panel JPanel
        JPanel p1=new JPanel(null);
        
         //final JTextArea ContenidoHiloPestania2=new JTextArea("Hilo pestaña 2");
        final JTextField contenidoHiloPestania2=new JTextField("Contenido hilo pestania 2");
        //coloco el textfield donde quiero "setbounds(x,y,ancho,alto)"
        contenidoHiloPestania2.setBounds(10, 10,200,20);
        //añado el textfield al panel
        p1.add(contenidoHiloPestania2);
        
        //final JTextArea hiloPesta�a3=new JTextArea("Hilo pesta�a 3");
        final JTextField contenidoHiloPestania3=new JTextField("Contenido Hilo Pestaña 3");
        //coloco el textfield donde quiero
        contenidoHiloPestania3.setBounds(10, 50,200,20);
        //añado el textfield al panel
        p1.add(contenidoHiloPestania3);
  
       //boton ACTUALIZAR para capturar informacion de los hilos
        JButton boton=new JButton();
        boton.setText("ACTUALIZAR");
        boton.setBounds(100,130,130,70);
        //añado el botón al panel
        p1.add(boton);
        
        //añado el panel del programa principal al panel de pestañas como pestaña 1
        panelconpestanias.addTab("PESTAÑA 1 ", null, p1, "Pestaña del Programa Principal");
        
        //CREO Y ARRANCO EL HILO DE CONTAR
        final HiloPestania2 hiloCuenta=new HiloPestania2(panelconpestanias);
        hiloCuenta.start();
        
        //CREO Y ARRANCO EL HILO DE SALUDAR
        final HiloPestania3 hiloSaluda=new HiloPestania3(panelconpestanias);
        hiloSaluda.start();
        
        //añado el panel con pestañas al JFrame
        ventana.getContentPane().add(panelconpestanias);
        //es imprescindible para que actualice las pesta�as de los hilos
    
        ventana.setVisible(true);
     
        boton.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent ae){
                    contenidoHiloPestania2.setText(obtenerPrimeraLinea(hiloCuenta.textoCuenta));
                    contenidoHiloPestania3.setText(obtenerPrimeraLinea(hiloSaluda.textoSaludo));
       
        	}

			
        	});
        
        

//Esta línea es imprescindible para que al pulsar la x de cerrar en el JFrame me 
//pare el hilo del main. Si no se pone, el hilo del programa principal sigue 
//funcionando y ocupando memoria, aunque el entorno gráfico se haya cerrado
ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}