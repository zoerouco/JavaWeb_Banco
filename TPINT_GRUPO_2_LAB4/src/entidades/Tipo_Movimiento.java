package entidades;

public class Tipo_Movimiento {

	private String id_tipo;
	private String descripcion;
	public String getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(String id_tipo) {
		this.id_tipo = id_tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Tipo_Movimiento [id_tipo=" + id_tipo + ", descripcion=" + descripcion + "]";
	}
	
	
}
