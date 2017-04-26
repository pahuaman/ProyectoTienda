import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Interfaz_Eliminar extends WindowAdapter implements ActionListener {
	
	Frame     FrenteEliminar, BuscEmpleadoE, BuscAdministradorE, BuscProveedorE, BuscProductoE, BuscVentaE;
	Button    IempleadoME, IAdminME, IProvME, IProductoME, IVentaME; //botones para FrenteEliminar
	Label     Etiqueta1E, Etiqueta2E, Etiqueta3E, Etiqueta4E, Etiqueta5E;
	TextField Texto1E, Texto2E, Texto3E, Texto4E, Texto5E; 
	Button	  Btn1E, Btn2E, Btn3E, Btn4E, Btn5E, Btn6E, Btn7E, Btn8E, Btn9E, Btn0E;
	
	//Objetos para manejar e insertar datos a nuestra base de datos
	Empleado      EX;
	Administrador EZ;
	Productos     PD;
	Proveedor     PROV;
	Venta         VY;

    public Interfaz_Eliminar() {
    	
    	FrenteEliminar = new Frame("Eliminar");
    	IempleadoME    = new Button("Empleado"); 
    	IAdminME       = new Button("Administrador"); 
    	IProvME        = new Button("Proveedor"); 
    	IProductoME    = new Button("Producto"); 
    	IVentaME       = new Button("Venta");
    	
    	//Creamos y mostramos ventana FRENTE ELIMINAR
    	FrenteEliminar.setLayout(new GridLayout(5,0));
    	FrenteEliminar.setBounds(400,250,300,200);
        FrenteEliminar.add(IempleadoME);
        FrenteEliminar.add(IAdminME);
        FrenteEliminar.add(IProvME);
        FrenteEliminar.add(IProductoME);
        FrenteEliminar.add(IVentaME);
        FrenteEliminar.setResizable(false);
        IempleadoME.addActionListener(this);
        IAdminME.addActionListener(this);
        IProvME.addActionListener(this);
        IProductoME.addActionListener(this);
        IVentaME.addActionListener(this);
        FrenteEliminar.setVisible(true); 
        FrenteEliminar.addWindowListener(this);//escuchadores de nuestra ventana eliminar
    	
    	//Ventanas para buscar el id Empleado
    	BuscEmpleadoE = new Frame("Buscar empleado");
    	Etiqueta1E    = new Label("No. empleado");
        Texto1E       = new TextField(10);
        Btn1E         = new Button("Aceptar");
        Btn2E         = new Button("Cancelar");
        
        //Creamos y mostramos ventana buscar id empleado
        BuscEmpleadoE.setLayout(new GridLayout(2,2));
    	BuscEmpleadoE.setBounds(300,250,300,90);
    	BuscEmpleadoE.add(Etiqueta1E); BuscEmpleadoE.add(Texto1E);
    	BuscEmpleadoE.add(Btn1E);      BuscEmpleadoE.add(Btn2E);
    	BuscEmpleadoE.setResizable(false);
    	BuscEmpleadoE.addWindowListener(this);
    	BuscEmpleadoE.setBackground(Color.orange);
    	Btn1E.addActionListener(this);
    	Btn2E.addActionListener(this);//escuchadores de nuestra ventana buscar empleado
    	
    	//ventana para buscar administrador
    	BuscAdministradorE = new Frame("Buscar administrador");
    	Etiqueta2E         = new Label("No. empleado");
        Texto2E            = new TextField(10);
        Btn3E              = new Button("Aceptar");
        Btn4E              = new Button("Cancelar");
        
        //Creamos y mostramos ventana buscar id administrador
        BuscAdministradorE.setLayout(new GridLayout(2,2));
    	BuscAdministradorE.setBounds(300,250,300,90);
    	BuscAdministradorE.add(Etiqueta2E); BuscAdministradorE.add(Texto2E);
    	BuscAdministradorE.add(Btn3E);      BuscAdministradorE.add(Btn4E);
        BuscAdministradorE.setResizable(false);
    	BuscAdministradorE.addWindowListener(this);
    	BuscAdministradorE.setBackground(Color.orange);
    	Btn3E.addActionListener(this);
    	Btn4E.addActionListener(this);
    	
    	//Ventana buscar proveedor
    	BuscProveedorE = new Frame("Buscar proveedor");
    	Etiqueta3E     = new Label("No. Proveedor");
        Texto3E        = new TextField(10);
        Btn5E          = new Button("Aceptar");
        Btn6E          = new Button("Cancelar");
        
        //Creamos y mostramos ventana buscar id proveedor
        BuscProveedorE.setLayout(new GridLayout(2,2));
    	BuscProveedorE.setBounds(300,250,300,90);
    	BuscProveedorE.add(Etiqueta3E); BuscProveedorE.add(Texto3E);
    	BuscProveedorE.add(Btn5E);      BuscProveedorE.add(Btn6E);
        BuscProveedorE.setResizable(false);
    	BuscProveedorE.addWindowListener(this);
    	BuscProveedorE.setBackground(Color.orange);
    	Btn5E.addActionListener(this);
    	Btn6E.addActionListener(this);
    	
    	//ventana buscar producto
    	BuscProductoE = new Frame("Buscar producto");
    	Etiqueta4E    = new Label("No. Producto");
        Texto4E       = new TextField(10);
        Btn7E         = new Button("Aceptar");
        Btn8E         = new Button("Cancelar");
        
        //Creamos y mostramos ventana buscar codigo de producto
        BuscProductoE.setLayout(new GridLayout(2,2));
    	BuscProductoE.setBounds(300,250,300,90);
    	BuscProductoE.add(Etiqueta4E); BuscProductoE.add(Texto4E);
    	BuscProductoE.add(Btn7E);       BuscProductoE.add(Btn8E);
        BuscProductoE.setResizable(false);
    	BuscProductoE.addWindowListener(this);
    	BuscProductoE.setBackground(Color.orange);
    	Btn7E.addActionListener(this);
    	Btn8E.addActionListener(this);
    	
    	//ventana para buscar venta
    	BuscVentaE = new Frame("Buscar Venta");
    	Etiqueta5E = new Label("No. Venta");
        Texto5E    = new TextField(10);
        Btn9E      = new Button("Aceptar");
        Btn0E      = new Button("Cancelar");
        
        //Creamos y mostramos ventana buscar codigo de venta
        BuscVentaE.setLayout(new GridLayout(2,2));
    	BuscVentaE.setBounds(300,250,300,90);
    	BuscVentaE.add(Etiqueta5E); BuscVentaE.add(Texto5E);
    	BuscVentaE.add(Btn9E);      BuscVentaE.add(Btn0E);
        BuscVentaE.setResizable(false);
    	BuscVentaE.addWindowListener(this);
    	BuscVentaE.setBackground(Color.orange);
    	Btn9E.addActionListener(this);
    	Btn0E.addActionListener(this);
    	
    	Empleado      EX   = new Empleado(" "," "," "," ",0,0);
    	Administrador EZ   = new Administrador(" "," "," "," ",0,0,0,"");
    	Productos     PD   = new Productos(0,0," "," ",0," "," "," ");
    	Proveedor     PROV = new Proveedor(0," "," "," "); 
    	Venta         VY   = new Venta(0,0,0,0," ",0);
    	
    	/*try{
    	    
    	    Connection miconexion  = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tienda","root","");
    	    Statement  mistatemen  = miconexion.createStatement();
    	    ResultSet  miresultset = null;
    	    
        }catch(Exception e){
        	
        	JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
        	
        }//catch
    	      //Objetos para la concexion a la base <--------------------*/
    	
    }//CONSTRUCTOR
    
public void EliminaEmpleado(){
	EX.ID = Integer.parseInt(Texto1E.getText());
	 
	/*try{ 
	  Statement mistatemen = null;
	  mistatemen.execute("DELETE FROM empleado WHERE id=?"+EX.ID);
	  JOptionPane.showMessageDialog(null,"Eliminado con exito");
	  
	  Texto1E.setText("");
	  
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
        	
	}*/
	
}//elimina empleado

public void EliminaAdministrador(){
	EZ.ID_administrador = Integer.parseInt(Texto2E.getText());
	 
	/*try{ 
	  Statement mistatemen = null;
	  mistatemen.execute("DELETE FROM administrador WHERE id_administrador=?"+EZ.ID_administrador);
	  JOptionPane.showMessageDialog(null,"Eliminado con exito");
	  
	  Texto2E.setText("");
	  
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
        	
	}*/
}//Elimina administrador

public void EliminaProveedor(){
	PROV.ID_proveedor = Integer.parseInt(Texto3E.getText());
	 
	/*try{ 
	  Statement mistatemen = null;
	  mistatemen.execute("DELETE FROM proveedor WHERE id=?"+PROV.ID_proveedor);
	  JOptionPane.showMessageDialog(null,"Eliminado con exito");
	  
	  Texto3E.setText("");
	  
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
        	
	}*/
}//elimina proveedor

public void EliminaProducto(){
	PD.ID_producto = Integer.parseInt(Texto4E.getText());
	 
	/*try{ 
	  Statement mistatemen = null;
	  mistatemen.execute("DELETE FROM Producto WHERE codigo=?"+PD.ID_producto);
	  JOptionPane.showMessageDialog(null,"Eliminado con exito");
	  
	  Texto4E.setText("");
	  
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
        	
	}*/
}//elimina producto

public void EliminaVenta(){
	VY.Numero_venta = Integer.parseInt(Texto5E.getText());
	 
	/*try{ 
	  Statement mistatemen = null;
	  mistatemen.execute("DELETE FROM venta WHERE nventa=?"+VY.Numero_venta);
	  JOptionPane.showMessageDialog(null,"Eliminado con exito");
	  
	  Texto5E.setText("");
	  
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
        	
	}*/
}//elimina Venta
    
    public void windowClosing(WindowEvent e){
     if(e.getSource()== FrenteEliminar){
  		FrenteEliminar.dispose();
  	 }
  	 if(e.getSource()== BuscEmpleadoE){
  		BuscEmpleadoE.dispose();
  	}
  	if(e.getSource()== BuscAdministradorE){
  		BuscAdministradorE.dispose();
  	}
  	if(e.getSource()== BuscProveedorE){
  		BuscProveedorE.dispose();
  	}
  	if(e.getSource()== BuscProductoE){
  		BuscProductoE.dispose();
  	}
  	if(e.getSource()== BuscVentaE){
  		BuscVentaE.dispose();
  	}
    }
    
    public void actionPerformed(ActionEvent e){
    
    //BOTONES DEL FRAME INSERTPRIM
  	if(e.getSource()== IempleadoME){
  		//ModifEmpleado.setVisible(true);
  		BuscEmpleadoE.setVisible(true);
  	}
  	if(e.getSource()== IAdminME){
  		//ModifAdministrador.setVisible(true);
  		BuscAdministradorE.setVisible(true);
  	}
  	if(e.getSource()== IProductoME){
  		//ModifProducto.setVisible(true);
  		BuscProductoE.setVisible(true);
  	}
  	if(e.getSource()== IProvME){
  		//ModifProveedor.setVisible(true);
  		BuscProveedorE.setVisible(true);
  	}
  	if(e.getSource()== IVentaME){
  		//ModifVenta.setVisible(true);
  		BuscVentaE.setVisible(true);
  	}
    
    //BOTONES DEL FRAME BUSCEMPLEADO
  	if(e.getSource()== Btn1E){
  		EliminaEmpleado();
  	}
  	if(e.getSource()== Btn2E){
  		BuscEmpleadoE.setVisible(false);
  	}
  	
  	//BOTONES DEL FRAME BUSCAMINISTRADOR
  	if(e.getSource()== Btn3E){
  		EliminaAdministrador();
  	}
  	if(e.getSource()== Btn4E){
  		BuscAdministradorE.setVisible(false);
  	}
  	
  	//BOTONES DEL FRAME BUSCPROVEEDOR
  	if(e.getSource()== Btn5E){
  		EliminaProveedor();
  	}
  	if(e.getSource()== Btn6E){
  		BuscProveedorE.setVisible(false);
  	}
  	
  	//BOTONES DEL FRAME BUSCPRODUCTO
  	if(e.getSource()== Btn7E){
  		EliminaProducto();
  	}
  	if(e.getSource()== Btn8E){
  		BuscProductoE.setVisible(false);
  	}
  	
  	//BOTONES DEL FRAME BUSCVENTA
  	if(e.getSource()== Btn9E){
  	     EliminaVenta();
  	}
  	if(e.getSource()== Btn0E){
  		BuscVentaE.setVisible(false);
  	}
  	
   }//BOTONES
   
}//CLASS