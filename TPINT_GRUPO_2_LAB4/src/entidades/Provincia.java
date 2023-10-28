package entidades;

public class Provincia {
	private int id;
	private String nombre_provincia;

	public Provincia() {}

	public Provincia(int id, String nombre_provincia) {
		super();
		this.id = id;
		this.nombre_provincia = nombre_provincia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_provincia() {
		return nombre_provincia;
	}

	public void setNombre_provincia(String nombre_provincia) {
		this.nombre_provincia = nombre_provincia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nombre_provincia == null) ? 0 : nombre_provincia.hashCode());
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
		Provincia other = (Provincia) obj;
		if (id != other.id)
			return false;
		if (nombre_provincia == null) {
			if (other.nombre_provincia != null)
				return false;
		} else if (!nombre_provincia.equals(other.nombre_provincia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id: " + id + ", nombre_provincia: " + nombre_provincia;
	}
}
