package entidades;

public class PrestamosXmovimientos {

	
	
	private Movimiento id_movimiento;
	private Cuenta CBU;
	private Prestamo id_prestamo;
	
	
	public PrestamosXmovimientos() {}


	public Movimiento getId_movimiento() {
		return id_movimiento;
	}


	public void setId_movimiento(Movimiento id_movimiento) {
		this.id_movimiento = id_movimiento;
	}


	public Cuenta getCBU() {
		return CBU;
	}


	public void setCBU(Cuenta cBU) {
		CBU = cBU;
	}


	public Prestamo getId_prestamo() {
		return id_prestamo;
	}


	public void setId_prestamo(Prestamo id_prestamo) {
		this.id_prestamo = id_prestamo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CBU == null) ? 0 : CBU.hashCode());
		result = prime * result + ((id_movimiento == null) ? 0 : id_movimiento.hashCode());
		result = prime * result + ((id_prestamo == null) ? 0 : id_prestamo.hashCode());
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
		PrestamosXmovimientos other = (PrestamosXmovimientos) obj;
		if (CBU == null) {
			if (other.CBU != null)
				return false;
		} else if (!CBU.equals(other.CBU))
			return false;
		if (id_movimiento == null) {
			if (other.id_movimiento != null)
				return false;
		} else if (!id_movimiento.equals(other.id_movimiento))
			return false;
		if (id_prestamo == null) {
			if (other.id_prestamo != null)
				return false;
		} else if (!id_prestamo.equals(other.id_prestamo))
			return false;
		return true;
	}


	public PrestamosXmovimientos(Movimiento id_movimiento, Cuenta cBU, Prestamo id_prestamo) {
		super();
		this.id_movimiento = id_movimiento;
		CBU = cBU;
		this.id_prestamo = id_prestamo;
	}


	@Override
	public String toString() {
		return "PrestamosXmovimientos [id_movimiento=" + id_movimiento + ", CBU=" + CBU + ", id_prestamo=" + id_prestamo
				+ "]";
	}
	


}
