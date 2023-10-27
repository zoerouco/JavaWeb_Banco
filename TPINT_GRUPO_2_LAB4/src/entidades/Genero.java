package entidades;

public class Genero {
	
	private String id_genero;
	private String descripcion;
	
	public Genero() {}

	public Genero(String id_genero, String descripcion) {
		super();
		this.id_genero = id_genero;
		this.descripcion = descripcion;
	}

	public String getId_genero() {
		return id_genero;
	}

	public void setId_genero(String id_genero) {
		this.id_genero = id_genero;
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
		result = prime * result + ((id_genero == null) ? 0 : id_genero.hashCode());
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
		Genero other = (Genero) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id_genero == null) {
			if (other.id_genero != null)
				return false;
		} else if (!id_genero.equals(other.id_genero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id_genero: " + id_genero + ", descripcion: " + descripcion;
	}
}
