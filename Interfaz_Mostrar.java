import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.sql.*;

public class Interfaz_Mostrar extends WindowAdapter implements ActionListener {
	
	Frame    FrenteMostrar, MostEmpleado, MostAdministrador, MostProveedor, MostProducto, MostVenta;
	Button   EMostrar, AMostrar, PMostrar, OMostrar, Vmostrar;
	TextArea MEmpleado, MAdministrador, MProveedor, MProducto, MVenta;
	
    public Interfaz_Mostrar() {
    	
    	//Frame frente mostrar
    	FrenteMostrar = new Frame("Mostrar");
    	EMostrar      = new Button("Empleado"); 
        AMostrar      = new Button("Administrador"); 
    	PMostrar      = new Button("Proveedor"); 
    	OMostrar      = new Button("Producto"); 
    	Vmostrar      = new Button("Venta");
    	
    	//Creamos y mostramos ventana FRENTE MOSTRAR
    	FrenteMostrar.setLayout(new GridLayout(5,0));
    	FrenteMostrar.setBounds(400,250,300,200);
        FrenteMostrar.add(EMostrar);
        FrenteMostrar.add(AMostrar);
        FrenteMostrar.add(PMostrar);
        FrenteMostrar.add(OMostrar);
        FrenteMostrar.add(Vmostrar);
        FrenteMostrar.setResizable(false);
        EMostrar.addActionListener(this);
        AMostrar.addActionListener(this);
        PMostrar.addActionListener(this);
        OMostrar.addActionListener(this);
        Vmostrar.addActionListener(this);
        FrenteMostrar.setVisible(true); 
        FrenteMostrar.addWindowListener(this);//escuchadores de nuestros botones frente mostrar
        
        //componentes de nuestro frame MostrEmpleado
        MostEmpleado = new Frame("Mostrar Empleados");
        MEmpleado    = new TextArea(40,4);
        
        MostEmpleado.setLayout(new GridLayout(1,1));
    	MostEmpleado.setBounds(400,250,300,400);
    	MostEmpleado.add(MEmpleado); 
    	MostEmpleado.addWindowListener(this); //escuchador
    	
    	//Componentes de nuestro frame MostAdministrador
    	MostAdministrador = new Frame("Mostrar Administradores");
        MAdministrador    = new TextArea(40,4);
        
        MostAdministrador.setLayout(new GridLayout(1,1));
    	MostAdministrador.setBounds(400,250,300,400);
    	MostAdministrador.add(MAdministrador); 
    	MostAdministrador.addWindowListener(this); //escuchador
    	
    	//componentes de nuestro frame MostProveedor
    	MostProveedor = new Frame("Mostrar Proveedores");
        MProveedor    = new TextArea(40,4);
        
        MostProveedor.setLayout(new GridLayout(1,1));
    	MostProveedor.setBounds(400,250,300,400);
    	MostProveedor.add(MProveedor); 
    	MostProveedor.addWindowListener(this); //escuchador
    	
    	//componentes de nuestro frame MostProducto
    	MostProducto = new Frame("Mostrar Productos");
        MProducto    = new TextArea(40,4);
        
        MostProducto.setLayout(new GridLayout(1,1));
    	MostProducto.setBounds(400,250,300,400);
    	MostProducto.add(MProducto); 
    	MostProducto.addWindowListener(this); //escuchador
    	
    	//componentes de nuestro frame mostVenta
    	MostVenta = new Frame("Mostrar Ventas");
        MVenta    = new TextArea(40,4);
        
        MostVenta.setLayout(new GridLayout(1,1));
    	MostVenta.setBounds(400,250,300,400);
    	MostVenta.add(MVenta); 
    	MostVenta.addWindowListener(this); //escuchador
    	
    	      //Objetos para la concexion a la base <--------------------
    	/*try{
    	    
    	    Connection miconexion  = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tienda","root","");
    	    Statement  mistatemen  = miconexion.createStatement();
    	    ResultSet  miresultset = null;
    	    
        }catch(Exception e){
        	
        	JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
        	
        }//catch
    	      //Objetos para la concexion a la base <-------------------- */
    	
    }//Constructor
    
    
public void MostrarEmpleados(){
	/*try{
	    ResultSet miresulset = null;
	    Statement mistatemen = null;
	    miresulset = mistatemen.executeQuery("SELECT* FROM empleado");
	    
	    while(miresulset.next()){
	    	
	    	MEmpleado.append(miresulset.getString(1));
	    	MEmpleado.append(", ");
	    	MEmpleado.append(miresulset.getString(2));
	    	MEmpleado.append(", ");
	    	MEmpleado.append(miresulset.getString(3));
	    	MEmpleado.append(", ");
	    	MEmpleado.append(miresulset.getString(4));
	    	MEmpleado.append(", ");
	    	MEmpleado.append(miresulset.getString(5));
	    	MEmpleado.append(", ");
	    	MEmpleado.append(miresulset.getString(6));
	    	MEmpleado.append("/n");
	    	
	    }//while
	    
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
	}//catch */
	
}//Metodo mostrar empleado

public void MostrarAdmistrador(){
	/*try{
	    ResultSet miresulset = null;
	    Statement mistatemen = null;
	    miresulset = mistatemen.executeQuery("SELECT* FROM administrador");
	    
	    while(miresulset.next()){
	    	
	    	MAdministrador.append(miresulset.getString(1));
	    	MAdministrador.append(", ");
	    	MAdministrador.append(miresulset.getString(2));
	    	MAdministrador.append(", ");
	    	MAdministrador.append(miresulset.getString(3));
	    	MAdministrador.append("/n");
	    	
	    }//while
	    
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
	}//catch */
}//metodo para mostrar administradores

public void MostrarProducto(){
	/*try{
	    ResultSet miresulset = null;
	    Statement mistatemen = null;
	    miresulset = mistatemen.executeQuery("SELECT* FROM producto");
	    
	    while(miresulset.next()){
	    	
	    	MProducto.append(miresulset.getString(1));
	    	MProducto.append(", ");
	    	MProducto.append(miresulset.getString(2));
	    	MProducto.append(", ");
	    	MProducto.append(miresulset.getString(3));
	    	MProducto.append(", ");
	    	MProducto.append(miresulset.getString(4));
	    	MProducto.append("/n");
	    	
	    }//while
	    
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
	}//catch */
}//Mostrar Producto

public void MostrarProveedor(){
	/*try{
	    ResultSet miresulset = null;
	    Statement mistatemen = null;
	    miresulset = mistatemen.executeQuery("SELECT* FROM proveedor");
	    
	    while(miresulset.next()){
	    	
	    	MProveedor.append(miresulset.getString(1));
	    	MProveedor.append(", ");
	    	MProveedor.append(miresulset.getString(2));
	    	MProveedor.append(", ");
	    	MProveedor.append(miresulset.getString(3));
	    	MProveedor.append(", ");
	    	MProveedor.append(miresulset.getString(4));
	    	MProveedor.append("/n");
	    	
	    }//while
	    
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
	}//catch*/
}//mostrar proveedor

public void mostrarVenta(){
	/*try{
	    ResultSet miresulset = null;
	    Statement mistatemen = null;
	    miresulset = mistatemen.executeQuery("SELECT* FROM venta");
	    
	    while(miresulset.next()){
	    	
	    	MVenta.append(miresulset.getString(1));
	    	MVenta.append(", ");
	    	MVenta.append(miresulset.getString(2));
	    	MVenta.append(", ");
	    	MVenta.append(miresulset.getString(3));
	    	MVenta.append(", ");
	    	MVenta.append(miresulset.getString(4));
	    	MVenta.append(", ");
	    	MVenta.append(miresulset.getString(5));
	    	MVenta.append(", ");
	    	MVenta.append(miresulset.getString(6));
	    	MVenta.append("/n");
	    	
	    }//while
	    
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
	}//catch */
}//Mostrar venta
    
    //metodo para abrir y cerrar ventanas
    public void windowClosing(WindowEvent e){
    	
    	if(e.getSource()== FrenteMostrar){
    		FrenteMostrar.dispose();
    	}
    	if(e.getSource()== MostEmpleado){
    		MostEmpleado.dispose();
    	}
    	if(e.getSource()== MostAdministrador){
    		MostAdministrador.dispose();
    	}
    	if(e.getSource()== MostProveedor){
    		MostProveedor.dispose();
    	}
    	if(e.getSource()== MostProducto){
    		MostProducto.dispose();
    	}
    	if(e.getSource()== MostVenta){
    		MostVenta.dispose();
    	}
    }
    
    //metodo de accion en button
    public void actionPerformed(ActionEvent e){
  
    	if(e.getSource()== EMostrar){
    		MostEmpleado.setVisible(true);
    		MostrarEmpleados();
    	}
    	if(e.getSource()== AMostrar){
    		MostAdministrador.setVisible(true);
    		MostrarAdmistrador();
    	}
    	if(e.getSource()== PMostrar){
    		MostProveedor.setVisible(true);
    		MostrarProveedor();
    	}
    	if(e.getSource()== OMostrar){
    		MostProducto.setVisible(true);
    		MostrarProducto();
    	}
    	if(e.getSource()== Vmostrar){
    		MostVenta.setVisible(true);
    		mostrarVenta();
    	}
    }//actionperformed
    
}//class