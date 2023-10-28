package entidades;

public class Localidad {
	private int id;
    private Provincia id_provincia;
	private String nombre_localidad;
	
	public Localidad() {}

	public Localidad(int id, Provincia id_provincia, String nombre_localidad) {
		super();
		this.id = id;
		this.id_provincia = id_provincia;
		this.nombre_localidad = nombre_localidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Provincia getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(Provincia id_provincia) {
		this.id_provincia = id_provincia;
	}

	public String getNombre_localidad() {
		return nombre_localidad;
	}

	public void setNombre_localidad(String nombre_localidad) {
		this.nombre_localidad = nombre_localidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((id_provincia == null) ? 0 : id_provincia.hashCode());
		result = prime * result + ((nombre_localidad == null) ? 0 : nombre_localidad.hashCode());
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
		Localidad other = (Localidad) obj;
		if (id != other.id)
			return false;
		if (id_provincia == null) {
			if (other.id_provincia != null)
				return false;
		} else if (!id_provincia.equals(other.id_provincia))
			return false;
		if (nombre_localidad == null) {
			if (other.nombre_localidad != null)
				return false;
		} else if (!nombre_localidad.equals(other.nombre_localidad))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id: " + id + ", id_provincia: " + id_provincia.getNombre_provincia() + ", nombre_localidad: " + nombre_localidad;
	}
}
