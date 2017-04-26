public class Administrador extends Empleado {
	//atributos de la clase
	int    ID_administrador;
	String Clave; 

    public Administrador(String nombre, String telefono, String tipo, String turno, float sueldo, 
    	                 int id, int id_administrador, String clave) {
    	   super(nombre, telefono, tipo, turno, sueldo, id);
    	   this.ID_administrador = id_administrador;
    	   this.Clave            = clave;
    }//Constructor
    
    //metodos Get
    public int GetID_administrador(){
    	return ID_administrador;
    }//Get id-admnistrador
    
    //Metodos a implementar
    public void Registrar(){
    	//FALTA IMPLEMENTACION
    }//registrar
    
    public void Modificar(){
        //FALTA IMPLEMENTACION
    }//registrar
    
    public void Eliminar (){
       //FALTA IMPLEMENTACION
    }//registrar
    
    public void Consultar_venta(){
       //FALTA IMPLEMENTACION
    }//registrar		
    
}//Class