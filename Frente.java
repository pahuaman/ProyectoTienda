import java.sql.Connection;
import java.sql.SQLException;

//import com.conexion.Conexion;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frente extends JFrame{
	Fondo  Abarrotes;
    Opcion Otro;
    
    public Frente(){
    	super("Abarrotes Don Pancho");
    	setBounds(500,200,265,250);
    	//setBounds(200,200,500,265);
    	setVisible(true);
    	setResizable(false);
    	
    	Container contentpane = getContentPane();
    	contentpane.setLayout(new GridLayout(1,2));
    	
    	Abarrotes  = new Fondo();
        Otro       = new Opcion(); 
        
        contentpane.add(Abarrotes);
        contentpane.add(Otro); 
    	
    	paint(getGraphics());
    }//const

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frente      X = new Frente();
        Contrasenia C = new Contrasenia();
        C.mostrarMarco();
        
		try {
			Connection con1 = Oconexion.crearConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
	

	}

}
