public class Venta {
	//atributos de clase
	int    Numero_venta, ID_producto, Vendido=0, ID_empleado;
	String Fecha;
	float  Total=0;

    public Venta(int numer_venta, int id_producto, int vendido, int id_empleado, String fecha, float total) {
    	this.Numero_venta = numer_venta;
    	this.ID_producto  = id_producto;
    	this.Vendido      = vendido;
    	this.ID_empleado  = id_empleado;
    	this.Fecha        = fecha;
    	this.Total        = total;
    }//Constructor
    
    //Metodos get
    public int Get_numeroVenta(){
    	return Numero_venta;
    }//get numero venta
    
}//Class