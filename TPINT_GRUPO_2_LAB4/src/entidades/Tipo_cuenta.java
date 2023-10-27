package entidades;

public class Tipo_cuenta {
	
	private String id_tipo;
	private String descripcion;
	
	public Tipo_cuenta() {}

	public Tipo_cuenta(String id_tipo, String descripcion) {
		super();
		this.id_tipo = id_tipo;
		this.descripcion = descripcion;
	}

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id_tipo == null) ? 0 : id_tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tipo_cuenta other = (Tipo_cuenta) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id_tipo == null) {
			if (other.id_tipo != null)
				return false;
		} else if (!id_tipo.equals(other.id_tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id_tipo: " + id_tipo + ", descripcion: " + descripcion;
	}
}
