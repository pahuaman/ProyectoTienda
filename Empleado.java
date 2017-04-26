public class Empleado {
	//atributos de la clase
	int    ID;
	String Nombre, Telefono, Tipo, Turno;
	float  Sueldo;

    public Empleado(String nombre, String telefono, String tipo, String turno, float sueldo, int id) {
    	this.ID       = id;
    	this.Nombre   = nombre;
    	this.Telefono = telefono;
    	this.Tipo     = tipo;
    	this.Turno    = turno;
    }//Constructor
    
    //Metodos Get
    public int Get_id(){
    	return ID;
    }//get
    
    //metodos para los empleados
    public void consultar(){
    	//FALTA IMPLEMENTACION
    }//consultar
    
    public void Realizar_Venta(){
    	//FALTA IMPLEMENTACION
    }//Realizar una venta
    
    public void Realizar_corte_caja(){
    	//FALTA IMPLEMENTACION
    }//realiuzar corte caja
    
}//class