 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

public class Contrasenia extends WindowAdapter implements ActionListener {
	
	//Variables de referencia
	Frame          men, mensaj, mensejErro;
	Button         b1, b2;
	Label          usuar, contra, mensE; 
	TextField      tex1;
	JPasswordField tex2;
	JTextArea      area;  
    
    //constructor
    public Contrasenia() {
    	
    	//Frames
    	men        = new Frame ("Iniciar Sesion");
    	mensaj     = new Frame ("Binevenido(a) al sistema");
    	mensejErro = new Frame ("Error en los datos");
    	
    	//buttons
    	b1 = new Button ("Aceptar");
    	b2 = new Button ("Cancelar");
    	
    	//Labels
    	usuar  = new Label ("Usuario");
    	contra = new Label ("Contraseña");
    	mensE  = new Label ("Lo siento, Vuelva a intentarlo...");
    	
    	//texts
    	tex1 = new TextField(30);
    	tex2 = new JPasswordField(30);
    	men.setBackground(Color.white);
    	tex1.setBackground(Color.white);
    	
    	area = new JTextArea(10,4);
    	
}//constructor

//metodo para crear nuestras ventanas    
public void mostrarMarco(){
	    
	    //creamos Ventana
    	men.setLayout(new GridLayout(3,2));
    	men.add(usuar);
    	men.add(tex1);
    	men.add(contra);
    	men.add(tex2);
    	men.add(b1);
    	men.add(b2);
    	b1.addActionListener(this);//accion en button
    	b2.addActionListener(this);//accion en button
    	men.addWindowListener(this);//oreja
    		
    	//dimensiones de nuestra ventana
    	men.setBounds(400,250,300,100);
    	men.setResizable(false);
    	men.setVisible(true);
    	
    	//creamos ventana bienvenido
    	mensaj.setLayout(new GridLayout(1,0));
    	mensaj.add(area);
    	mensaj.setBounds(400,250,300,100);
    	mensaj.setResizable(false);
    	mensaj.setVisible(false);
    	mensaj.addWindowListener(this);//oreja
    	
    	//creamos ventana de error
    	mensejErro.setLayout(new  GridLayout(1,0));
    	mensejErro.add(mensE);
    	mensejErro.setBounds(400,250,300,100);
    	mensejErro.setResizable(false);
    	mensejErro.setVisible(false);
    	mensejErro.addWindowListener(this);//oreja
    	
    	//color de las ventanas
    	area.setBackground(Color.white);
    	mensaj.setBackground(Color.white);
    	mensejErro.setBackground(Color.white);
	
}//metodo mostrar

//metodo para abrir y cerrar ventanas
public void windowClosing(WindowEvent e){
   
   if(e.getSource()== men){
   	men.dispose();
   }
   if(e.getSource()== mensaj){
   	mensaj.dispose();
   }
   if(e.getSource()== mensejErro){
   	mensejErro.dispose();
   }

}//metodo cerrar ventanas

 public void Capturar(){

  	area.setText("\n\nHola!  "+tex1.getText()+"  bienvenido al sistema.");
    tex2.getText();
}//capturar datos

//metodo de accion en button
public void actionPerformed(ActionEvent e){
  	
	if(e.getSource()== b1){ 
		Capturar();
		if(tex2.getText().equals("yeah")){ //AQUI ESTA LA CONTRASENYA DEL USUARIO <----
			mensaj.setVisible(true);
			men.setVisible(false);
		}
		else {
			mensejErro.setVisible(true);
		}
	   	
  	}//if

  	if(e.getSource()== b2){
  	  men.setVisible(false);
  	  mensejErro.setVisible(false);
  	  mensaj.setVisible(false);
  	}//if
	
  }//accion en button

}//Class