public class Productos extends Proveedor{
	//atributos de la clase
	int    ID_producto, Cantidad;
	String Nombre_Producto, Descripcion;

    public Productos(int id_producto,int cantidad, String nombre_producto, String descripcion,
                     int ID_proveedor, String Nombre_prov, String Tele_prov, String Direccion) {
    	super( ID_proveedor, Nombre_prov, Tele_prov, Direccion);
    	this.ID_producto     = id_producto;
    	this.Nombre_Producto = nombre_producto;
    	this.Descripcion     = descripcion;
    	this.Cantidad        = cantidad;
    }//constructor
    
    //metodos get
    public int GetID_producto(){
    	return ID_producto;
    }//get id producto
    
}//Class