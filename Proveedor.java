public class Proveedor {
	//atributos de la clase
	int    ID_proveedor;
	String Nombre_prov, Tele_prov, Direccion;

    public Proveedor(int id_proveedor, String nombre_prov, String tele_prov, String direccion) {
    	this.ID_proveedor = id_proveedor;
    	this.Nombre_prov  = nombre_prov;
    	this.Tele_prov    = tele_prov;
    	this.Direccion    = direccion;
    }//constructor
    
    //metodos Get
    public int GetId_proveedor (){
    	return ID_proveedor;
    }//get id_proveedor
  
}//Class