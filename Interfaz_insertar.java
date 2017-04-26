import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Interfaz_insertar extends WindowAdapter implements ActionListener {
	
	//Variables que necesitamos para las ventanas de insertar
	Frame     InsertPrim, insertEmpleado, InsertAdministrador, InsertProveedor, InsertProducto, InsertVenta;
	Button    Iempleado, IAdmin, IProv, IProducto, IVenta; //botones para InsertPrim
	TextField TID, TNombre, TTel, TTipo, TTurno, Tsueldo;  //TexFields para frame empleado
    Label     LID, LNombre, LTel, LTipo, LTurno, Lsueldo;  //Labels para frame empleado
    TextField AID, ANombre; //Textfields para frame admin
    Label     IID, INombre, IClave; //Labels para frame admin
    TextField OID, ONombre, OTel, ODir; //textfields para frame Proveedor
    Label     PID, PNombre, PTel, PDir; //labels para frame proveedor
    TextField ZID, ZNombre, ZDescripcion, ZCantidad; //textfields para frame producto
    Label     DID, DNombre, DDescripcion, DCantidad; //labels para frame producto
    TextField VID, VIDProducto, VVendido, VIDEmpleado, VFecha, VTotal;//Textfields para frame Venta
    Label     RID, RIDProducto, RVendido, RIDEmpleado, RFecha, RTotal;//Labels para frame Venta
    Button    EAceptar, ECancelar, IAceptar, ICancelar, PAceptar, PCancelar, OAceptar, OCancelar, RGuardar, RCancelar; //Botones
    JPasswordField AClave;//unico passwordfield para el frame administrador
	
	//Objetos para manejar e insertar datos a nuestra base de datos
	Empleado      EM;
	Administrador EA;
	Productos     PV;
	Proveedor     Pro;
	Venta         VX;

    public Interfaz_insertar() {
    	
    	//Frame InsertPrim
    	InsertPrim = new Frame("Insertar");
    	Iempleado  = new Button("Empleado"); 
    	IAdmin     = new Button("Administrador"); 
    	IProv      = new Button("Proveedor"); 
    	IProducto  = new Button("Producto"); 
    	IVenta     = new Button("Venta");
    	
    	//Creamos y mostramos ventana InsertPrim
    	InsertPrim.setLayout(new GridLayout(5,0));
    	InsertPrim.setBounds(400,250,300,200);
        InsertPrim.add(Iempleado);
        InsertPrim.add(IAdmin);
        InsertPrim.add(IProv);
        InsertPrim.add(IProducto);
        InsertPrim.add(IVenta);
        InsertPrim.setResizable(false);
        Iempleado.addActionListener(this);
        IAdmin.addActionListener(this);
        IProv.addActionListener(this);
        IProducto.addActionListener(this);
        IVenta.addActionListener(this);
        InsertPrim.setVisible(true); 
        InsertPrim.addWindowListener(this);//Escuchadores del frame InsertPrim
        
        //Frame Insertar Empleado
        insertEmpleado = new Frame("Datos Empleado");
        LID            = new Label("ID Empleado");
        LNombre        = new Label("Nombre");
        LTel           = new Label("Telefono");
        LTipo          = new Label("Tipo");
        LTurno         = new Label("Turno");
        Lsueldo        = new Label("Sueldo");
        TID            = new TextField(15);
        TNombre        = new TextField(40);
        TTel           = new TextField(15);
        TTipo          = new TextField(15);
        TTurno         = new TextField(15);
        Tsueldo        = new TextField(15);
        EAceptar       = new Button("Aceptar");
        ECancelar      = new Button("Cancelar");
        
        //Creamos y mostramos ventana datos Empleado
        insertEmpleado.setLayout(new GridLayout(7,2));
    	insertEmpleado.setBounds(400,250,300,200);
    	insertEmpleado.add(LID);      insertEmpleado.add(TID);
    	insertEmpleado.add(LNombre);  insertEmpleado.add(TNombre);  
    	insertEmpleado.add(LTel);     insertEmpleado.add(TTel);
    	insertEmpleado.add(LTipo);    insertEmpleado.add(TTipo);
    	insertEmpleado.add(LTurno);   insertEmpleado.add(TTurno);
    	insertEmpleado.add(Lsueldo);  insertEmpleado.add(Tsueldo);
    	insertEmpleado.add(EAceptar); insertEmpleado.add(ECancelar);
    	insertEmpleado.setResizable(false);
    	insertEmpleado.setBackground(Color.pink);
    	EAceptar.addActionListener(this);
    	ECancelar.addActionListener(this);
    	insertEmpleado.addWindowListener(this); //Escuchadores de inserEmpleado
    	
        //Frame insertar Administrador 
        InsertAdministrador = new Frame("Datos Administrador");
        IID                 = new Label("ID admin");
        INombre             = new Label("Nombre");
        IClave              = new Label("Password");
        AID                 = new TextField(15);
        ANombre             = new TextField(40);
        AClave              = new JPasswordField(50);
        IAceptar            = new Button("Aceptar");
        ICancelar           = new Button("Cancelar");
        
        //Creamos y mostramos ventana Administrador
        InsertAdministrador.setLayout(new GridLayout(4,2));
    	InsertAdministrador.setBounds(400,250,300,150);
    	InsertAdministrador.add(IID);      InsertAdministrador.add(AID);
    	InsertAdministrador.add(INombre);  InsertAdministrador.add(ANombre);
    	InsertAdministrador.add(IClave);   InsertAdministrador.add(AClave);
    	InsertAdministrador.add(IAceptar); InsertAdministrador.add(ICancelar);
    	InsertAdministrador.setResizable(false);
        InsertAdministrador.setBackground(Color.PINK);
        IAceptar.addActionListener(this);
        ICancelar.addActionListener(this);
        InsertAdministrador.addWindowListener(this); //Escuchadores del frame administrador
        
        //Frame insetar Proveedor
        InsertProveedor = new Frame("Datos Proveedor");
        PID             = new Label("ID proveedor");
        PNombre         = new Label("Nombre");
        PTel            = new Label("Telefono");
        PDir            = new Label("Direccion");
        OID             = new TextField(10);
        ONombre         = new TextField(30);
        OTel            = new TextField(15);
        ODir            = new TextField(50);
        PAceptar        = new Button("Aceptar");
        PCancelar       = new Button("Cancelar");
        
        //Creamos y mostramos ventana insetar Proveedor
        InsertProveedor.setLayout(new GridLayout(5,2));
    	InsertProveedor.setBounds(400,250,300,170);
    	InsertProveedor.add(PID);      InsertProveedor.add(OID);
    	InsertProveedor.add(PNombre);  InsertProveedor.add(ONombre);
    	InsertProveedor.add(PTel);     InsertProveedor.add(OTel);
    	InsertProveedor.add(PDir);     InsertProveedor.add(ODir);
    	InsertProveedor.add(PAceptar); InsertProveedor.add(PCancelar);
    	InsertProveedor.setResizable(false);
    	InsertProveedor.setBackground(Color.pink);
    	PAceptar.addActionListener(this);
    	PCancelar.addActionListener(this);
    	InsertProveedor.addWindowListener(this);//Escuchadores de nuestra ventana proveedor
    	
    	//Frame insertar producto
    	InsertProducto = new Frame("Datos de producto");
    	DID            = new Label("codigo");
    	DNombre        = new Label("Nombre");
    	DDescripcion   = new Label("Descripcion");
    	DCantidad      = new Label("Articulos");
    	ZID            = new TextField(10);
    	ZNombre        = new TextField(50);
    	ZDescripcion   = new TextField(100);
    	ZCantidad      = new TextField(10);
    	OAceptar       = new Button("Guardar");
    	OCancelar      = new Button("Cancelar");
    	
    	//Creamos y mostramos ventana producto
    	InsertProducto.setLayout(new GridLayout(5,2));
    	InsertProducto.setBounds(400,250,300,160);
    	InsertProducto.add(DID);          InsertProducto.add(ZID);
    	InsertProducto.add(DNombre);      InsertProducto.add(ZNombre);
    	InsertProducto.add(DDescripcion); InsertProducto.add(ZDescripcion);
    	InsertProducto.add(DCantidad);    InsertProducto.add(ZCantidad);
    	InsertProducto.add(OAceptar);     InsertProducto.add(OCancelar);
    	InsertProducto.setResizable(false);
    	InsertProducto.setBackground(Color.pink);
    	InsertProducto.addWindowListener(this);
    	OAceptar.addActionListener(this);
    	OCancelar.addActionListener(this);//Escuchadores de nuestro frame Producto
    	
    	//frame insertVenta
    	InsertVenta = new Frame("Venta");
    	RID         = new Label("No. venta");
    	RIDProducto = new Label("Codigo producto");
    	RVendido    = new Label("No. Articulos");
    	RIDEmpleado = new Label("codigo empleado");
    	RFecha      = new Label("Fecha");
    	RTotal      = new Label("Total");
    	VID         = new TextField(10);
    	VVendido    = new TextField(10);
    	VIDEmpleado = new TextField(10);
    	VIDProducto = new TextField(10);
    	VFecha      = new TextField(10);
    	VTotal      = new TextField(10);
    	RGuardar    = new Button("Guardar");
    	RCancelar   = new Button("Cancelar"); 
    	
    	//Creamos y mostramos ventana insertVenta
    	InsertVenta.setLayout(new GridLayout(7,2));
    	InsertVenta.setBounds(400,250,300,200);
    	InsertVenta.add(RID);         InsertVenta.add(VID);
    	InsertVenta.add(RIDProducto); InsertVenta.add(VIDProducto);
    	InsertVenta.add(RVendido);    InsertVenta.add(VVendido);
    	InsertVenta.add(RIDEmpleado); InsertVenta.add(VIDEmpleado);
    	InsertVenta.add(RFecha);      InsertVenta.add(VFecha);
    	InsertVenta.add(RTotal);      InsertVenta.add(VTotal);
    	InsertVenta.add(RGuardar);    InsertVenta.add(RCancelar);
    	InsertVenta.setResizable(false);
    	InsertVenta.addWindowListener(this);
    	InsertVenta.setBackground(Color.pink);
    	RCancelar.addActionListener(this);
    	RGuardar.addActionListener(this);//escuchadores de nuestro frame insertVenta
    	
    	//Desde aqui manejamos la base de datos y dichas incersiones
    	Empleado      EM  = new Empleado(" "," "," "," ",0,0);
    	Administrador EA  = new Administrador(" "," "," "," ",0,0,0,"");
    	Productos     Pv  = new Productos(0,0," "," ",0," "," "," ");
    	Proveedor     Pro = new Proveedor(0," "," "," "); 
    	Venta         VX  = new Venta(0,0,0,0," ",0);
    	
    	/*try{
    	    
    	    Connection miconexion  = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tienda","root","");
    	    Statement  mistatemen  = miconexion.createStatement();
    	    ResultSet  miresultset = null;
    	    
        }catch(Exception e){
        	
        	JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
        	
        }//catch
    	      //Objetos para la concexion a la base <--------------------*/
    
    }//constructor
    
public void InsertaEmpleado(){
	/*obtiene los datos de los textfields y los pone en variables locales*/
	EM.ID       = Integer.parseInt(TID.getText());
	EM.Nombre   = TNombre.getText();
	EM.Telefono = TTel.getText();
	EM.Tipo     = TTipo.getText();
	EM.Turno    = TTurno.getText();
	EM.Sueldo   = Float.parseFloat(Tsueldo.getText());
	
	/*try{ 
	  Statement mistatemen = null;
	  mistatemen.execute("INSERT INTO empleado VALUES("+EM.ID+","+EM.Nombre+","+EM.Telefono+","+EM.Tipo+","+EM.Turno+","+EM.Sueldo+")");
	  JOptionPane.showMessageDialog(null,"Registro Exitoso");
	  
	  TID.setText("");
	  TNombre.setText("");
	  TTel.setText("");
	  TTipo.setText("");
	  TTurno.setText("");
	  Tsueldo.setText("");
	  
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
        	
	}*/
	
}//metodo insertaEmpleado

public void InsertaAdministrador(){
	EA.ID_administrador = Integer.parseInt(AID.getText());
	EA.Nombre           = ANombre.getText();
	EA.Clave            = AClave.getText();
	
	/*try{
		Statement mistatemen = null;
	    mistatemen.execute("INSERT INTO administrador VALUES("+EA.ID+","+EA.Nombre+","+EA.Clave+")");
	    JOptionPane.showMessageDialog(null,"Registro Exitoso");
	    
	    AID.setText("");
	    ANombre.setText("");
	    AClave.setText("");
	    
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
	}*/
}//Insertar administrador

public void insertaProducto(){
	PV.ID_producto     = Integer.parseInt(ZID.getText());
	PV.Nombre_Producto = ZNombre.getText();
	PV.Descripcion     = ZDescripcion.getText();
	PV.Cantidad        = Integer.parseInt(ZCantidad.getText());
	
	/*try{
		Statement mistatemen = null;
	    mistatemen.execute("INSERT INTO productos VALUES("+PV.ID_producto+","+PV.Nombre_Producto+","+PV.Descripcion+","+PV.Cantidad+")");
	    JOptionPane.showMessageDialog(null,"Registro Exitoso");
	    
	    ZID.setText("");
	    ZNombre.setText("");
	    ZDescripcion.setText("");
	    ZCantidad.setText("");
	    
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
	}*/
		
}//inserta producto

public void insertaProveedor(){
	Pro.ID_proveedor = Integer.parseInt(OID.getText());
	Pro.Nombre_prov  = ONombre.getText();
	Pro.Tele_prov    = OTel.getText();
	Pro.Direccion    = ODir.getText();
	
	/*try{
		Statement mistatemen = null;
	    mistatemen.execute("INSERT INTO proveedor VALUES("+Pro.ID_proveedor+","+Pro.Nombre_prov+","+Pro.Tele_prov+","+Pro.Direccion+")");
	    JOptionPane.showMessageDialog(null,"Registro Exitoso");
	    
	    OID.setText("");
	    ONombre.setText("");
	    OTel.setText("");
	    ODir.setText("");
	    
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
	}*/
		
}//inserta proveedor

public void insertaVenta(){
	VX.Numero_venta = Integer.parseInt(VID.getText());
	VX.ID_producto  = Integer.parseInt(VIDProducto.getText());
	VX.Vendido      = Integer.parseInt(VVendido.getText());
	VX.ID_empleado  = Integer.parseInt(VIDEmpleado.getText());
	VX.Fecha        = VFecha.getText();
	VX.Total        = Float.parseFloat(VTotal.getText());
	
	/*try{
		Statement mistatemen = null;
	    mistatemen.execute("INSERT INTO venta VALUES("+VX.Numero_venta+","+VX.ID_producto+","+VX.Vendido+","+VX.ID_empleado+","+VX.Fecha+","+VX.Total+")");
	    JOptionPane.showMessageDialog(null,"Registro Exitoso");
	    
	    VID.setText("");
	    VIDProducto.setText("");
	    VVendido.setText("");
	    VIDEmpleado.setText("");
	    VFecha.setText("");
	    VTotal.setText("");
	    
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
	}*/
}//inserta venta
    
  //metodo para abrir y cerrar ventanas
  public void windowClosing(WindowEvent e){
  	if(e.getSource()== InsertPrim){
  		InsertPrim.dispose();
  	}
  	if(e.getSource()== insertEmpleado){
  		insertEmpleado.dispose();
  	}
  	if(e.getSource()== InsertAdministrador){
  		InsertAdministrador.dispose();
  	}
  	if(e.getSource()== InsertProveedor){
  		InsertProveedor.dispose();
  	}
  	if(e.getSource()== InsertProducto){
  		InsertProducto.dispose();
  	}
  	if(e.getSource()== InsertVenta){
  		InsertVenta.dispose();
  	}
	
  }//metodo para las ventanas
  
  //metodo de accion en button
  public void actionPerformed(ActionEvent e){
  	
  	//BOTONES DEL FRAME INSERTPRIM
  	if(e.getSource()== Iempleado){
  		insertEmpleado.setVisible(true);
  	}
  	if(e.getSource()== IAdmin){
  		InsertAdministrador.setVisible(true);
  	}
  	if(e.getSource()== IProducto){
  		InsertProducto.setVisible(true);
  	}
  	if(e.getSource()== IProv){
  		InsertProveedor.setVisible(true);
  	}
  	if(e.getSource()== IVenta){
  		InsertVenta.setVisible(true);
  	}
  	
  	//BOTONES DEL FRAME EMPLEADO
  	if(e.getSource()== ECancelar){
  		insertEmpleado.setVisible(false);
  	}
  	if(e.getSource()== EAceptar){
  		InsertaEmpleado();
  	}
  	
  	//BOTONES FRAME ADMINISTRADOR
  	if(e.getSource()== IAceptar){
  		InsertaAdministrador();
  	}
  	if(e.getSource()== ICancelar){
  		InsertAdministrador.setVisible(false);
  	}
  	
  	//BOTONES DEL FRAME PROVEEDOR
  	if(e.getSource()== PAceptar){
  		insertaProveedor();
  	}
  	if(e.getSource()== PCancelar){
  		InsertProveedor.setVisible(false);
  	}
    //BOTONES DEL FRAME PRODUCTO
    if(e.getSource()== OAceptar){
    	insertaProducto();
    }
    if(e.getSource()== OCancelar){
    	InsertProducto.setVisible(false);
    }
    //BOTONES DEL FRAME INSERTVENTA
    if(e.getSource()== RGuardar){
    	insertaVenta();
    }
    if(e.getSource()== RCancelar){
    	InsertVenta.setVisible(false);
    }
    
  }//metodo para los botones
  
}//CLASS