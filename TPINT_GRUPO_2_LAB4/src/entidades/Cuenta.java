package entidades;

import java.sql.Date;

public class Cuenta {
	
	private String CBU;
	private Tipo_cuenta id_tipo;
	private Cliente DNI;
	private Date fecha_creacion;
	private String nro_cuenta;
	private float saldo;
	private Boolean estado;
	
	public Cuenta() {}

	public Cuenta(String cBU, Tipo_cuenta id_tipo, Cliente dNI, Date fecha_creacion, String nro_cuenta, float saldo,
			Boolean estado) {
		super();
		CBU = cBU;
		this.id_tipo = id_tipo;
		DNI = dNI;
		this.fecha_creacion = fecha_creacion;
		this.nro_cuenta = nro_cuenta;
		this.saldo = saldo;
		this.estado = estado;
	}

	public String getCBU() {
		return CBU;
	}

	public void setCBU(String cBU) {
		CBU = cBU;
	}

	public Tipo_cuenta getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(Tipo_cuenta id_tipo) {
		this.id_tipo = id_tipo;
	}

	public Cliente getDNI() {
		return DNI;
	}

	public void setDNI(Cliente dNI) {
		DNI = dNI;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getNro_cuenta() {
		return nro_cuenta;
	}

	public void setNro_cuenta(String nro_cuenta) {
		this.nro_cuenta = nro_cuenta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CBU == null) ? 0 : CBU.hashCode());
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fecha_creacion == null) ? 0 : fecha_creacion.hashCode());
		result = prime * result + ((id_tipo == null) ? 0 : id_tipo.hashCode());
		result = prime * result + ((nro_cuenta == null) ? 0 : nro_cuenta.hashCode());
		result = prime * result + Float.floatToIntBits(saldo);
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
		Cuenta other = (Cuenta) obj;
		if (CBU == null) {
			if (other.CBU != null)
				return false;
		} else if (!CBU.equals(other.CBU))
			return false;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fecha_creacion == null) {
			if (other.fecha_creacion != null)
				return false;
		} else if (!fecha_creacion.equals(other.fecha_creacion))
			return false;
		if (id_tipo == null) {
			if (other.id_tipo != null)
				return false;
		} else if (!id_tipo.equals(other.id_tipo))
			return false;
		if (nro_cuenta == null) {
			if (other.nro_cuenta != null)
				return false;
		} else if (!nro_cuenta.equals(other.nro_cuenta))
			return false;
		if (Float.floatToIntBits(saldo) != Float.floatToIntBits(other.saldo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CBU: " + CBU + ", id_tipo: " + id_tipo + ", DNI: " + DNI + ", fecha_creacion: " + fecha_creacion
				+ ", nro_cuenta: " + nro_cuenta + ", saldo: " + saldo + ", estado: " + estado;
	}
}
