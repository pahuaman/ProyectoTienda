import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fondo extends JPanel {

    public Fondo() {
    	
        FlowLayout Z = new FlowLayout();
		Z.setAlignment(FlowLayout.CENTER);
		Z.setHgap(20);
		Z.setVgap(30);
		setLayout(Z);
		
	}//constructor
	
  public void paintComponent (Graphics g){
     
     Dimension tamanio = getSize();
     
     ImageIcon imagenFondo = new ImageIcon(getClass().getResource("logo1.png")); //si dice .JPEG poner ".jpg"
     
     g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
     
     setOpaque(false);
     
     super.paintComponent(g);
     }//metodo paintComponent
    
}//class

class Opcion extends JPanel implements ActionListener{
	//atributos
	JButton Insertar, Modificar, Eliminar, mostrar;

    public Opcion() {
    	
        FlowLayout M = new FlowLayout();
    	M.setAlignment(FlowLayout.CENTER);
    	//M.setHgap(20);
    	M.setVgap(20);
        setLayout(M);
    	
    	//Creamos los botones de nuestro menu inicial admnistrador
        Insertar   = new JButton("Insertar");
        Modificar  = new JButton("Modificar");
        mostrar    = new JButton("Mostrar");
        Eliminar   = new JButton("Eliminar");
       
        add(Insertar);
        add(Modificar);
        add(mostrar);
        add(Eliminar);
        
        //Escuchadores para los botones
        Insertar.addActionListener(this);
        Modificar.addActionListener(this);
        mostrar.addActionListener(this);
        Eliminar.addActionListener(this);
        
    }//constructor
    
  //metodo de accion en button
  public void actionPerformed(ActionEvent e){
  	//Falta para que aparezcan las demás interfaces
  	if(e.getSource()== Insertar){
  		//InsertPrim.setVisible(true);
  		Interfaz_insertar I = new Interfaz_insertar();
  	}//insertar
  	
  	if(e.getSource()== Modificar){
  		Interfaz_Modificar M = new Interfaz_Modificar();
  	}//modificar
  	
  	if(e.getSource()== mostrar){
  		Interfaz_Mostrar O = new Interfaz_Mostrar();
  	}//mostrar
  	
  	if(e.getSource()== Eliminar){
  		Interfaz_Eliminar E = new Interfaz_Eliminar();
  	}//eliminar
  	
  }//accion en boton
    
}//Class