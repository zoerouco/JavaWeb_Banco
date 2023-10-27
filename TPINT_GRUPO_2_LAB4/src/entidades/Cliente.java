package entidades;

import java.util.Date;

public class Cliente {
	
	private String DNI; 
	private Genero id_genero;
	private int id_nacionalidad;
	private int id_provincia;
	private int id_localidades;
	private String CUIL;
	private String nombre;
	private String apellido;
	private Date fecha_nacimiento;
	private String direccion;
	private String correo_electronico;
	private String telefono_primario;
	private String telefono_secundario;
	private boolean estado;
	
	public Cliente() {}
	
	public Cliente(String DNI, Genero id_genero, int id_nacionalidad, int id_provincia, int id_localidades, String CUIL,
			String nombre, String apellido, Date fecha_nacimiento, String direccion, String correo_electronico,
			String telefono_primario, String telefono_secundario, boolean estado) {
		super();
		this.DNI = DNI;
		this.id_genero = id_genero;
		this.id_nacionalidad = id_nacionalidad;
		this.id_provincia = id_provincia;
		this.id_localidades = id_localidades;
		this.CUIL = CUIL;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.correo_electronico = correo_electronico;
		this.telefono_primario = telefono_primario;
		this.telefono_secundario = telefono_secundario;
		this.estado = estado;
	}
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public Genero getId_genero() {
		return id_genero;
	}
	public void setId_genero(Genero id_genero) {
		this.id_genero = id_genero;
	}
	public int getId_nacionalidad() {
		return id_nacionalidad;
	}
	public void setId_nacionalidad(int id_nacionalidad) {
		this.id_nacionalidad = id_nacionalidad;
	}
	public int getId_provincia() {
		return id_provincia;
	}
	public void setId_provincia(int id_provincia) {
		this.id_provincia = id_provincia;
	}
	public int getId_localidades() {
		return id_localidades;
	}
	public void setId_localidades(int id_localidades) {
		this.id_localidades = id_localidades;
	}
	public String getCUIL() {
		return CUIL;
	}
	public void setCUIL(String cUIL) {
		CUIL = cUIL;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	public String getTelefono_primario() {
		return telefono_primario;
	}
	public void setTelefono_primario(String telefono_primario) {
		this.telefono_primario = telefono_primario;
	}
	public String getTelefono_secundario() {
		return telefono_secundario;
	}
	public void setTelefono_secundario(String telefono_secundario) {
		this.telefono_secundario = telefono_secundario;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CUIL == null) ? 0 : CUIL.hashCode());
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((correo_electronico == null) ? 0 : correo_electronico.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + (estado ? 1231 : 1237);
		result = prime * result + ((fecha_nacimiento == null) ? 0 : fecha_nacimiento.hashCode());
		result = prime * result + ((id_genero == null) ? 0 : id_genero.hashCode());
		result = prime * result + id_localidades;
		result = prime * result + id_nacionalidad;
		result = prime * result + id_provincia;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono_primario == null) ? 0 : telefono_primario.hashCode());
		result = prime * result + ((telefono_secundario == null) ? 0 : telefono_secundario.hashCode());
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
		Cliente other = (Cliente) obj;
		if (CUIL == null) {
			if (other.CUIL != null)
				return false;
		} else if (!CUIL.equals(other.CUIL))
			return false;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (correo_electronico == null) {
			if (other.correo_electronico != null)
				return false;
		} else if (!correo_electronico.equals(other.correo_electronico))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (estado != other.estado)
			return false;
		if (fecha_nacimiento == null) {
			if (other.fecha_nacimiento != null)
				return false;
		} else if (!fecha_nacimiento.equals(other.fecha_nacimiento))
			return false;
		if (id_genero == null) {
			if (other.id_genero != null)
				return false;
		} else if (!id_genero.equals(other.id_genero))
			return false;
		if (id_localidades != other.id_localidades)
			return false;
		if (id_nacionalidad != other.id_nacionalidad)
			return false;
		if (id_provincia != other.id_provincia)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono_primario == null) {
			if (other.telefono_primario != null)
				return false;
		} else if (!telefono_primario.equals(other.telefono_primario))
			return false;
		if (telefono_secundario == null) {
			if (other.telefono_secundario != null)
				return false;
		} else if (!telefono_secundario.equals(other.telefono_secundario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DNI cliente: " + DNI + ", ID genero: " + id_genero.getDescripcion() + ", ID nacionalidad: " + id_nacionalidad
				+ ", ID provincia: " + id_provincia + ", ID localidades: " + id_localidades + ", CUIL: " + CUIL
				+ ", nombre: " + nombre + ", apellido: " + apellido + ", fecha de nacimiento: " + fecha_nacimiento
				+ ", direccion: " + direccion + ", correo electronico: " + correo_electronico + ", telefono primario: "
				+ telefono_primario + ", telefono secundario: " + telefono_secundario + ", estado: " + estado;
	}
}
