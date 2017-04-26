import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Interfaz_Modificar extends WindowAdapter implements ActionListener {
	
	Frame     FrenteModificar, ModifEmpleado, ModifAdministrador, ModifProveedor, ModifProducto, ModifVenta;
	Frame     BuscEmpleado, BuscAdministrador, BuscProveedor, BuscProducto, BuscVenta;
	Label     Etiqueta1, Etiqueta2, Etiqueta3, Etiqueta4, Etiqueta5;
	TextField Texto1, Texto2, Texto3, Texto4, Texto5; 
	Button	  Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9, Btn0; 
	Button    IempleadoM, IAdminM, IProvM, IProductoM, IVentaM; //botones para InsertPrim
	TextField TIDM, TNombreM, TTelM, TTipoM, TTurnoM, TsueldoM;  //TexFields para frame empleado
    Label     LIDM, LNombreM, LTelM, LTipoM, LTurnoM, LsueldoM;  //Labels para frame empleado
    TextField AIDM, ANombreM; //Textfields para frame admin
    Label     IIDM, INombreM, IClaveM; //Labels para frame admin
    TextField OIDM, ONombreM, OTelM, ODirM; //textfields para frame Proveedor
    Label     PIDM, PNombreM, PTelM, PDirM; //labels para frame proveedor
    TextField ZIDM, ZNombreM, ZDescripcionM, ZCantidadM; //textfields para frame producto
    Label     DIDM, DNombreM, DDescripcionM, DCantidadM; //labels para frame producto
    TextField VIDM, VIDProductoM, VVendidoM, VIDEmpleadoM, VFechaM, VTotalM;//Textfields para frame Venta
    Label     RIDM, RIDProductoM, RVendidoM, RIDEmpleadoM, RFechaM, RTotalM;//Labels para frame Venta
    Button    EAceptarM, ECancelarM, IAceptarM, ICancelarM, PAceptarM, PCancelarM, OAceptarM, OCancelarM, RGuardarM, RCancelarM; //Botones
    JPasswordField AClaveM;//unico passwordfield para el frame administrador
    
    //Objetos para manejar e insertar datos a nuestra base de datos
	Empleado      E1;
	Administrador E2;
	Productos     P3;
	Proveedor     Pr4;
	Venta         V5;

    public Interfaz_Modificar() {
    	
    	//Ventanas para buscar el id Empleado
    	BuscEmpleado = new Frame("Buscar empleado");
    	Etiqueta1    = new Label("No. empleado");
        Texto1       = new TextField(10);
        Btn1         = new Button("Aceptar");
        Btn2         = new Button("Cancelar");
        
        //Creamos y mostramos ventana buscar id empleado
        BuscEmpleado.setLayout(new GridLayout(2,2));
    	BuscEmpleado.setBounds(300,250,300,90);
    	BuscEmpleado.add(Etiqueta1); BuscEmpleado.add(Texto1);
    	BuscEmpleado.add(Btn1);      BuscEmpleado.add(Btn2);
    	BuscEmpleado.setResizable(false);
    	BuscEmpleado.addWindowListener(this);
    	BuscEmpleado.setBackground(Color.green);
    	Btn1.addActionListener(this);
    	Btn2.addActionListener(this);//escuchadores de nuestra ventana buscar empleado
    	
    	//ventana para buscar administrador
    	BuscAdministrador = new Frame("Buscar administrador");
    	Etiqueta2         = new Label("No. empleado");
        Texto2            = new TextField(10);
        Btn3              = new Button("Aceptar");
        Btn4              = new Button("Cancelar");
        
        //Creamos y mostramos ventana buscar id administrador
        BuscAdministrador.setLayout(new GridLayout(2,2));
    	BuscAdministrador.setBounds(300,250,300,90);
    	BuscAdministrador.add(Etiqueta2); BuscAdministrador.add(Texto2);
    	BuscAdministrador.add(Btn3);      BuscAdministrador.add(Btn4);
        BuscAdministrador.setResizable(false);
    	BuscAdministrador.addWindowListener(this);
    	BuscAdministrador.setBackground(Color.green);
    	Btn3.addActionListener(this);
    	Btn4.addActionListener(this);
    	
    	//Ventana buscar proveedor
    	BuscProveedor = new Frame("Buscar proveedor");
    	Etiqueta3     = new Label("No. Proveedor");
        Texto3        = new TextField(10);
        Btn5          = new Button("Aceptar");
        Btn6          = new Button("Cancelar");
        
        //Creamos y mostramos ventana buscar id proveedor
        BuscProveedor.setLayout(new GridLayout(2,2));
    	BuscProveedor.setBounds(300,250,300,90);
    	BuscProveedor.add(Etiqueta3); BuscProveedor.add(Texto3);
    	BuscProveedor.add(Btn5);      BuscProveedor.add(Btn6);
        BuscProveedor.setResizable(false);
    	BuscProveedor.addWindowListener(this);
    	BuscProveedor.setBackground(Color.green);
    	Btn5.addActionListener(this);
    	Btn6.addActionListener(this);
    	
    	//ventana buscar producto
    	BuscProducto = new Frame("Buscar producto");
    	Etiqueta4    = new Label("No. Producto");
        Texto4       = new TextField(10);
        Btn7         = new Button("Aceptar");
        Btn8         = new Button("Cancelar");
        
        //Creamos y mostramos ventana buscar codigo de producto
        BuscProducto.setLayout(new GridLayout(2,2));
    	BuscProducto.setBounds(300,250,300,90);
    	BuscProducto.add(Etiqueta4); BuscProducto.add(Texto4);
    	BuscProducto.add(Btn7);      BuscProducto.add(Btn8);
        BuscProducto.setResizable(false);
    	BuscProducto.addWindowListener(this);
    	BuscProducto.setBackground(Color.green);
    	Btn7.addActionListener(this);
    	Btn8.addActionListener(this);
    	
    	//ventana para buscar venta
    	BuscVenta = new Frame("Buscar Venta");
    	Etiqueta5 = new Label("No. Venta");
        Texto5    = new TextField(10);
        Btn9      = new Button("Aceptar");
        Btn0      = new Button("Cancelar");
        
        //Creamos y mostramos ventana buscar codigo de venta
        BuscVenta.setLayout(new GridLayout(2,2));
    	BuscVenta.setBounds(300,250,300,90);
    	BuscVenta.add(Etiqueta5); BuscVenta.add(Texto5);
    	BuscVenta.add(Btn9);      BuscVenta.add(Btn0);
        BuscVenta.setResizable(false);
    	BuscVenta.addWindowListener(this);
    	BuscVenta.setBackground(Color.green);
    	Btn9.addActionListener(this);
    	Btn0.addActionListener(this);
    	
    	//FRAME FRENTE MODIFCAR
    	FrenteModificar = new Frame("Modificar");
    	IempleadoM      = new Button("Empleado"); 
    	IAdminM         = new Button("Administrador"); 
    	IProvM          = new Button("Proveedor"); 
    	IProductoM      = new Button("Producto"); 
    	IVentaM         = new Button("Venta");
    	
    	//Creamos y mostramos ventana FRENTE MODIFICAR
    	FrenteModificar.setLayout(new GridLayout(5,0));
    	FrenteModificar.setBounds(400,250,300,200);
        FrenteModificar.add(IempleadoM);
        FrenteModificar.add(IAdminM);
        FrenteModificar.add(IProvM);
        FrenteModificar.add(IProductoM);
        FrenteModificar.add(IVentaM);
        FrenteModificar.setResizable(false);
        IempleadoM.addActionListener(this);
        IAdminM.addActionListener(this);
        IProvM.addActionListener(this);
        IProductoM.addActionListener(this);
        IVentaM.addActionListener(this);
        FrenteModificar.setVisible(true); 
        FrenteModificar.addWindowListener(this);//escuchadores de nuestra ventana modificar
    	
        
        //Frame mofifEmpleado
        ModifEmpleado   = new Frame("Datos Empleado");
        LIDM            = new Label("ID Empleado");
        LNombreM        = new Label("Nombre");
        LTelM           = new Label("Telefono");
        LTipoM          = new Label("Tipo");
        LTurnoM         = new Label("Turno");
        LsueldoM        = new Label("Sueldo");
        TIDM            = new TextField(15);
        TNombreM        = new TextField(40);
        TTelM           = new TextField(15);
        TTipoM          = new TextField(15);
        TTurnoM         = new TextField(15);
        TsueldoM        = new TextField(15);
        EAceptarM       = new Button("Aceptar");
        ECancelarM      = new Button("Cancelar");
        
        //Creamos y mostramos ventana  modifEmpleado
        ModifEmpleado.setLayout(new GridLayout(7,2));
    	ModifEmpleado.setBounds(400,250,300,200);
    	ModifEmpleado.add(LIDM);      ModifEmpleado.add(TIDM);
    	ModifEmpleado.add(LNombreM);  ModifEmpleado.add(TNombreM);  
    	ModifEmpleado.add(LTelM);     ModifEmpleado.add(TTelM);
    	ModifEmpleado.add(LTipoM);    ModifEmpleado.add(TTipoM);
    	ModifEmpleado.add(LTurnoM);   ModifEmpleado.add(TTurnoM);
    	ModifEmpleado.add(LsueldoM);  ModifEmpleado.add(TsueldoM);
    	ModifEmpleado.add(EAceptarM); ModifEmpleado.add(ECancelarM);
    	ModifEmpleado.setResizable(false);
    	//ModifEmpleado.setVisible(true);
    	ModifEmpleado.setBackground(Color.green);
    	EAceptarM.addActionListener(this);
    	ECancelarM.addActionListener(this);
    	ModifEmpleado.addWindowListener(this); //Escuchadores de modifEmpleado
    	
        //Frame insertar modifAdministrador 
        ModifAdministrador   = new Frame("Datos Administrador");
        IIDM                 = new Label("ID admin");
        INombreM             = new Label("Nombre");
        IClaveM              = new Label("Password");
        AIDM                 = new TextField(15);
        ANombreM             = new TextField(40);
        AClaveM              = new JPasswordField(50);
        IAceptarM            = new Button("Aceptar");
        ICancelarM           = new Button("Cancelar");
        
        //Creamos y mostramos ventana modifAdministrador
        ModifAdministrador.setLayout(new GridLayout(4,2));
    	ModifAdministrador.setBounds(400,250,300,150);
    	ModifAdministrador.add(IIDM);      ModifAdministrador.add(AIDM);
    	ModifAdministrador.add(INombreM);  ModifAdministrador.add(ANombreM);
    	ModifAdministrador.add(IClaveM);   ModifAdministrador.add(AClaveM);
    	ModifAdministrador.add(IAceptarM); ModifAdministrador.add(ICancelarM);
    	//ModifAdministrador.setVisible(true);
    	ModifAdministrador.setResizable(false);
        ModifAdministrador.setBackground(Color.green);
        IAceptarM.addActionListener(this);
        ICancelarM.addActionListener(this);
        ModifAdministrador.addWindowListener(this); //Escuchadores del frame modifadministrador
        
        //Frame insetar modifProveedor
        ModifProveedor   = new Frame("Datos Proveedor");
        PIDM             = new Label("ID proveedor");
        PNombreM         = new Label("Nombre");
        PTelM            = new Label("Telefono");
        PDirM            = new Label("Direccion");
        OIDM             = new TextField(10);
        ONombreM         = new TextField(30);
        OTelM            = new TextField(15);
        ODirM            = new TextField(50);
        PAceptarM        = new Button("Aceptar");
        PCancelarM       = new Button("Cancelar");
        
        //Creamos y mostramos ventana modifProveedor
        ModifProveedor.setLayout(new GridLayout(5,2));
    	ModifProveedor.setBounds(400,250,300,170);
    	ModifProveedor.add(PIDM);      ModifProveedor.add(OIDM);
    	ModifProveedor.add(PNombreM);  ModifProveedor.add(ONombreM);
    	ModifProveedor.add(PTelM);     ModifProveedor.add(OTelM);
    	ModifProveedor.add(PDirM);     ModifProveedor.add(ODirM);
    	ModifProveedor.add(PAceptarM); ModifProveedor.add(PCancelarM);
    	//ModifProveedor.setVisible(true);
    	ModifProveedor.setResizable(false);
    	ModifProveedor.setBackground(Color.green);
    	PAceptarM.addActionListener(this);
    	PCancelarM.addActionListener(this);
    	ModifProveedor.addWindowListener(this);//Escuchadores de nuestra ventana modifproveedor
    	
    	//Frame insertar modifproducto
    	ModifProducto   = new Frame("Datos de producto");
    	DIDM            = new Label("codigo");
    	DNombreM        = new Label("Nombre");
    	DDescripcionM   = new Label("Descripcion");
    	DCantidadM      = new Label("Articulos");
    	ZIDM            = new TextField(10);
    	ZNombreM        = new TextField(50);
    	ZDescripcionM   = new TextField(100);
    	ZCantidadM      = new TextField(10);
    	OAceptarM       = new Button("Guardar");
    	OCancelarM      = new Button("Cancelar");
    	
    	//Creamos y mostramos ventana modifproducto
    	ModifProducto.setLayout(new GridLayout(5,2));
    	ModifProducto.setBounds(400,250,300,160);
    	ModifProducto.add(DIDM);          ModifProducto.add(ZIDM);
    	ModifProducto.add(DNombreM);      ModifProducto.add(ZNombreM);
    	ModifProducto.add(DDescripcionM); ModifProducto.add(ZDescripcionM);
    	ModifProducto.add(DCantidadM);    ModifProducto.add(ZCantidadM);
    	ModifProducto.add(OAceptarM);     ModifProducto.add(OCancelarM);
    	//ModifProducto.setVisible(true);
    	ModifProducto.setResizable(false);
    	ModifProducto.setBackground(Color.green);
    	ModifProducto.addWindowListener(this);
    	OAceptarM.addActionListener(this);
    	OCancelarM.addActionListener(this);//Escuchadores de nuestro frame modifProducto
    	
    	//frame modifVenta
    	ModifVenta   = new Frame("Venta");
    	RIDM         = new Label("No. venta");
    	RIDProductoM = new Label("Codigo producto");
    	RVendidoM    = new Label("No. Articulos");
    	RIDEmpleadoM = new Label("codigo empleado");
    	RFechaM      = new Label("Fecha");
    	RTotalM      = new Label("Total");
    	VIDM         = new TextField(10);
    	VVendidoM    = new TextField(10);
    	VIDEmpleadoM = new TextField(10);
    	VIDProductoM = new TextField(10);
    	VFechaM      = new TextField(10);
    	VTotalM      = new TextField(10);
    	RGuardarM    = new Button("Guardar");
    	RCancelarM   = new Button("Cancelar"); 
    	
    	//Creamos y mostramos modifVenta
    	ModifVenta.setLayout(new GridLayout(7,2));
    	ModifVenta.setBounds(400,250,300,200);
    	ModifVenta.add(RIDM);         ModifVenta.add(VIDM);
    	ModifVenta.add(RIDProductoM); ModifVenta.add(VIDProductoM);
    	ModifVenta.add(RVendidoM);    ModifVenta.add(VVendidoM);
    	ModifVenta.add(RIDEmpleadoM); ModifVenta.add(VIDEmpleadoM);
    	ModifVenta.add(RFechaM);      ModifVenta.add(VFechaM);
    	ModifVenta.add(RTotalM);      ModifVenta.add(VTotalM);
    	ModifVenta.add(RGuardarM);    ModifVenta.add(RCancelarM);
    	//ModifVenta.setVisible(true);
    	ModifVenta.setResizable(false);
    	ModifVenta.addWindowListener(this);
    	ModifVenta.setBackground(Color.green);
    	RCancelarM.addActionListener(this);
    	RGuardarM.addActionListener(this);//escuchadores de nuestro frame modifVenta
    	
    	//Objetos para la concexion a la base <--------------------
    	Empleado      E1  = new Empleado(" "," "," "," ",0,0);
    	Administrador E2  = new Administrador(" "," "," "," ",0,0,0,"");
    	Productos     P3  = new Productos(0,0," "," ",0," "," "," ");
    	Proveedor     Pr4 = new Proveedor(0," "," "," "); 
    	Venta         V5  = new Venta(0,0,0,0," ",0);
    	
    	/*try{
    	    
    	    Connection miconexion  = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tienda","root","");
    	    Statement  mistatemen  = miconexion.createStatement();
    	    ResultSet  miresultset = null;
    	    
        }catch(Exception e){
        	
        	JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
        	
        }//catch
    	      //Objetos para la concexion a la base <-------------------- */
    	
    }//Constructor
    
public void ModEmpleado(){
	E1.ID = Integer.parseInt(Texto1.getText());
	
	/*try{ 
	  ResultSet miresulset = null;
	  Statement mistatemen = null;
	  mistatemen.executeQuery("SELECT* FROM empleado WHERE id=?"+E1.ID);
	  
	  ModifEmpleado.setVisible(true);
	  TIDM.setText(Integer.toString(E1.ID));
	  TNombreM.setText(E1.Nombre);
	  TTelM.setText(E1.Telefono);
	  TTipoM.setText(E1.Tipo);
	  TTurnoM.setText(E1.Turno);
	  TsueldoM.setText(Float.toString(E1.Sueldo));
	  Texto1.setText("");
	  
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"No se encontro el registro","Error",JOptionPane.ERROR_MESSAGE);
        	
	}*/
	
}//meodifca empleado */

public void CambiosEmpleado(){
	E1.ID       = Integer.parseInt(TIDM.getText());
	E1.Nombre   = TNombreM.getText();
	E1.Telefono = TTelM.getText();
	E1.Tipo     = TTipoM.getText();
	E1.Turno    = TTurnoM.getText();
	E1.Sueldo   = Float.parseFloat(TsueldoM.getText());
	
	/*try{ 
	  Statement mistatemen = null;
	  mistatemen.execute("INSERT INTO empleado VALUES("+E1.ID+","+E1.Nombre+","+E1.Telefono+","+E1.Tipo+","+E1.Turno+","+E1.Sueldo+")");
	  JOptionPane.showMessageDialog(null,"Registro Exitoso");
	  
	  TIDM.setText("");
	  TNombreM.setText("");
	  TTelM.setText("");
	  TTipoM.setText("");
	  TTurnoM.setText("");
	  TsueldoM.setText("");
	  
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
        	
	}*/
	
}//cambios empleado

public void ModAdministrador(){
	E2.ID_administrador = Integer.parseInt(Texto2.getText());
	
	/*try{ 
	  ResultSet miresulset = null;
	  Statement mistatemen = null;
	  mistatemen.executeQuery("SELECT* FROM administrador WHERE id_administrador=?"+E2.ID_administrador);
	  
	  ModifAdministrador.setVisible(true);
	  AIDM.setText(Integer.toString(E2.ID_administrador));
	  ANombreM.setText(E2.Nombre);
	  AClaveM.setText(E2.Clave);
	  
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"No se encontro el registro","Error",JOptionPane.ERROR_MESSAGE);
	}*/
	
}//Modifica admnistrador

public void CambiosAdministrador(){
    E2.ID_administrador = Integer.parseInt(AIDM.getText());
    E2.Nombre           = ANombreM.getText();
    E2.Clave            = AClaveM.getText();
    	
	/*try{
		Statement mistatemen = null;
	    mistatemen.execute("INSERT INTO administrador VALUES("+E2.ID+","+E2.Nombre+","+E2.Clave+")");
	    
	    AIDM.setText("");
	    ANombreM.setText("");
	    AClaveM.setText("");
	    
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"No se encontro el registro","Error",JOptionPane.ERROR_MESSAGE);
	}*/
	
}//cambios administrador

public void ModProveedor(){
	Pr4.ID_proveedor = Integer.parseInt(Texto3.getText());
	 
	/*try{ 
	  Statement mistatemen = null;
	  mistatemen.executeQuery("SELECT* FROM proveedor WHERE id=?"+Pr4.ID_proveedor);
	  
	  ModifProveedor.setVisible(true);
	  OIDM.setText(Integer.toString(Pr4.ID_proveedor));
	  ONombreM.setText(Pr4.Nombre_prov);
	  OTelM.setText(Pr4.Tele_prov);
	  ODirM.setText(Pr4.Direccion);
	  
	  Texto3.setText("");
	  
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"No se encontro el registro","Error",JOptionPane.ERROR_MESSAGE);	
	}*/
	
}//modifica proveedor

public void cambiosProveedor(){
	Pr4.ID_proveedor = Integer.parseInt(OIDM.getText());
	Pr4.Nombre_prov  = ONombreM.getText();
	Pr4.Tele_prov    = OTelM.getText();
	Pr4.Direccion    = ODirM.getText();
	
	/*try{
		Statement mistatemen = null;
	    mistatemen.execute("INSERT INTO proveedor VALUES("+Pr4.ID_proveedor+","+Pr4.Nombre_prov+","+Pr4.Tele_prov+","+Pr4.Direccion+")");
	    JOptionPane.showMessageDialog(null,"Registro Exitoso");
	    
	    OIDM.setText("");
	    ONombreM.setText("");
	    OTelM.setText("");
	    ODirM.setText("");
	    
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
	}*/
		
}//cambios proveedor

public void modProducto(){
	P3.ID_producto = Integer.parseInt(Texto4.getText());
	 
	/*try{ 
	  Statement mistatemen = null;
	  mistatemen.executeQuery("SELECT* FROM productos WHERE codigo=?"+P3.ID_producto);
	  
	  ModifProducto.setVisible(true);
	  ZIDM.setText(Integer.toString(P3.ID_producto));
	  ZNombreM.setText(P3.Nombre_Producto);
	  ZDescripcionM.setText(P3.Descripcion);
	  ZCantidadM.setText(Integer.toString(P3.Cantidad));
	
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"No se encontro el registro","Error",JOptionPane.ERROR_MESSAGE);	
	}*/
	
}//modificar producto

public void CambiosProducto(){
	P3.ID_producto     = Integer.parseInt(ZIDM.getText());
	P3.Nombre_Producto = ZNombreM.getText();
	P3.Descripcion     = ZDescripcionM.getText();
	P3.Cantidad        = Integer.parseInt(ZCantidadM.getText());
	
	/*try{
		Statement mistatemen = null;
	    mistatemen.execute("INSERT INTO productos VALUES("+P3.ID_producto+","+P3.Nombre_Producto+","+P3.Descripcion+","+P3.Cantidad+")");
	    JOptionPane.showMessageDialog(null,"Registro Exitoso");
	    
	    ZIDM.setText("");
	    ZNombreM.setText("");
	    ZDescripcionM.setText("");
	    ZCantidadM.setText("");
	    
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
	}*/
		
}//cambios producto

public void modVenta(){
	V5.Numero_venta = Integer.parseInt(Texto5.getText());
	
	/*try{ 
	  Statement mistatemen = null;
	  mistatemen.executeQuery("SELECT* FROM venta WHERE nventa=?"+V5.Numero_venta);
	  
	  ModifVenta.setVisible(true);
	  VIDM.setText(Integer.toString(V5.Numero_venta));
	  VVendidoM.setText(Integer.toString(V5.Vendido));
	  VIDEmpleadoM.setText(Integer.toString(V5.ID_empleado));
	  VIDProductoM.setText(Integer.toString(V5.ID_producto));
	  VFechaM.setText(V5.Fecha);
	  VTotalM.setText(Float.toString(V5.Total));
	  
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"No se encontro el registro","Error",JOptionPane.ERROR_MESSAGE);	
	}*/
	
}//modificar venta

public void cambiosVenta(){
	V5.Numero_venta = Integer.parseInt(VIDM.getText());
	V5.ID_producto  = Integer.parseInt(VIDProductoM.getText());
	V5.Vendido      = Integer.parseInt(VVendidoM.getText());
	V5.ID_empleado  = Integer.parseInt(VIDEmpleadoM.getText());
	V5.Fecha        = VFechaM.getText();
	V5.Total        = Float.parseFloat(VTotalM.getText());
	
	/*try{
		Statement mistatemen = null;
	    mistatemen.execute("INSERT INTO venta VALUES("+V5.Numero_venta+","+V5.ID_producto+","+V5.Vendido+","+V5.ID_empleado+","+V5.Fecha+","+V5.Total+")");
	    JOptionPane.showMessageDialog(null,"Registro Exitoso");
	    
	    VIDM.setText("");
	    VIDProductoM.setText("");
	    VVendidoM.setText("");
	    VIDEmpleadoM.setText("");
	    VFechaM.setText("");
	    VTotalM.setText("");
	    
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"Conexion invalida. :C","Error",JOptionPane.ERROR_MESSAGE);
	}*/
}//cambios venta
    
    //metodo para abrir y cerrar ventanas
  public void windowClosing(WindowEvent e){
  	if(e.getSource()== FrenteModificar){
  		FrenteModificar.dispose();
  	}
  	if(e.getSource()== ModifEmpleado){
  		ModifEmpleado.dispose();
  	}
  	if(e.getSource()== ModifAdministrador){
  		ModifAdministrador.dispose();
  	}
  	if(e.getSource()== ModifProveedor){
  		ModifProveedor.dispose();
  	}
  	if(e.getSource()== ModifProducto){
  		ModifProducto.dispose();
  	}
  	if(e.getSource()== ModifVenta){
  		ModifVenta.dispose();
  	}
  	if(e.getSource()== BuscEmpleado){
  		BuscEmpleado.dispose();
  	}
  	if(e.getSource()== BuscAdministrador){
  		BuscAdministrador.dispose();
  	}
  	if(e.getSource()== BuscProveedor){
  		BuscProveedor.dispose();
  	}
  	if(e.getSource()== BuscProducto){
  		BuscProducto.dispose();
  	}
  	if(e.getSource()== BuscVenta){
  		BuscVenta.dispose();
  	}
  
	
  }//metodo para las ventanas
  
  //metodo de accion en button
  public void actionPerformed(ActionEvent e){
  	
  	//BOTONES DEL FRAME INSERTPRIM
  	if(e.getSource()== IempleadoM){
  		BuscEmpleado.setVisible(true);
  	}
  	if(e.getSource()== IAdminM){
  		BuscAdministrador.setVisible(true);
  	}
  	if(e.getSource()== IProductoM){
  		BuscProducto.setVisible(true);
  	}
  	if(e.getSource()== IProvM){
  		BuscProveedor.setVisible(true);
  	}
  	if(e.getSource()== IVentaM){
  		BuscVenta.setVisible(true);
  	}
  	
  	//BOTONES DEL FRAME BUSCEMPLEADO
  	if(e.getSource()== Btn1){
  		ModEmpleado();
  	}
  	if(e.getSource()== Btn2){
  		BuscEmpleado.setVisible(false);
  	}
  	
  	//BOTONES DEL FRAME BUSCAMINISTRADOR
  	if(e.getSource()== Btn3){
  		ModAdministrador();
  	}
  	if(e.getSource()== Btn4){
  		BuscAdministrador.setVisible(false);
  	}
  	
  	//BOTONES DEL FRAME BUSCPROVEEDOR
  	if(e.getSource()== Btn5){
  		ModProveedor();
  	}
  	if(e.getSource()== Btn6){
  		BuscProveedor.setVisible(false);
  	}
  	
  	//BOTONES DEL FRAME BUSCPRODUCTO
  	if(e.getSource()== Btn7){
  		modProducto();
  	}
  	if(e.getSource()== Btn8){
  		BuscProducto.setVisible(false);
  	}
  	
  	//BOTONES DEL FRAME BUSCVENTA
  	if(e.getSource()== Btn9){
  		modVenta();
  	}
  	if(e.getSource()== Btn0){
  		BuscVenta.setVisible(false);
  	}
  	
  	//BOTONES DEL FRAME EMPLEADO
  	if(e.getSource()== ECancelarM){
  		ModifEmpleado.setVisible(false);
  	}
  	if(e.getSource()== EAceptarM){
  		CambiosEmpleado();
  	}
  	
  	//BOTONES FRAME ADMINISTRADOR
  	if(e.getSource()== IAceptarM){
  		CambiosAdministrador();
  	}
  	if(e.getSource()== ICancelarM){
  		ModifAdministrador.setVisible(false);
  	}
  	
  	//BOTONES DEL FRAME PROVEEDOR
  	if(e.getSource()== PAceptarM){
  		cambiosProveedor();
  	}
  	if(e.getSource()== PCancelarM){
  		ModifProveedor.setVisible(false);
  	}
    //BOTONES DEL FRAME PRODUCTO
    if(e.getSource()== OAceptarM){
        CambiosProducto();
    }
    if(e.getSource()== OCancelarM){
    	ModifProducto.setVisible(false);
    }
    //BOTONES DEL FRAME VENTA
    if(e.getSource()== RGuardarM){
    	cambiosVenta();
    }
    if(e.getSource()== RCancelarM){
    	ModifVenta.setVisible(false);
    }
    
  }//metodo para los botones
    
}//Class