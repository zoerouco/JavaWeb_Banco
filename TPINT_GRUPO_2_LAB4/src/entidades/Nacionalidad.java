package entidades;

public class Nacionalidad {
	private int id;
    private short code;
	private String iso3166a1;
    private	String iso3166a2;
    private String nombre_pais;
    
    public Nacionalidad() {}

	public Nacionalidad(int id, short code, String iso3166a1, String iso3166a2, String nombre_pais) {
		super();
		this.id = id;
		this.code = code;
		this.iso3166a1 = iso3166a1;
		this.iso3166a2 = iso3166a2;
		this.nombre_pais = nombre_pais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public short getCode() {
		return code;
	}

	public void setCode(short code) {
		this.code = code;
	}

	public String getIso3166a1() {
		return iso3166a1;
	}

	public void setIso3166a1(String iso3166a1) {
		this.iso3166a1 = iso3166a1;
	}

	public String getIso3166a2() {
		return iso3166a2;
	}

	public void setIso3166a2(String iso3166a2) {
		this.iso3166a2 = iso3166a2;
	}

	public String getNombre_pais() {
		return nombre_pais;
	}

	public void setNombre_pais(String nombre_pais) {
		this.nombre_pais = nombre_pais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + id;
		result = prime * result + ((iso3166a1 == null) ? 0 : iso3166a1.hashCode());
		result = prime * result + ((iso3166a2 == null) ? 0 : iso3166a2.hashCode());
		result = prime * result + ((nombre_pais == null) ? 0 : nombre_pais.hashCode());
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
		Nacionalidad other = (Nacionalidad) obj;
		if (code != other.code)
			return false;
		if (id != other.id)
			return false;
		if (iso3166a1 == null) {
			if (other.iso3166a1 != null)
				return false;
		} else if (!iso3166a1.equals(other.iso3166a1))
			return false;
		if (iso3166a2 == null) {
			if (other.iso3166a2 != null)
				return false;
		} else if (!iso3166a2.equals(other.iso3166a2))
			return false;
		if (nombre_pais == null) {
			if (other.nombre_pais != null)
				return false;
		} else if (!nombre_pais.equals(other.nombre_pais))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id: " + id + ", code: " + code + ", iso3166a1: " + iso3166a1 + ", iso3166a2: " + iso3166a2
				+ ", nombre_pais: " + nombre_pais;
	}
}
