package entidades;

public class PrestamosXmovimientos {

	
	
	private int id_movimiento;
	private String CBU;
	private int id_prestamo;
	
	
	public PrestamosXmovimientos() {}
	

	public PrestamosXmovimientos(int id_movimiento, String cBU, int id_prestamo) {
		super();
		this.id_movimiento = id_movimiento;
		CBU = cBU;
		this.id_prestamo = id_prestamo;
		}
	
	
	
	
	public int getId_movimiento() {
		return id_movimiento;
	}


	public void setId_movimiento(int id_movimiento) {
		this.id_movimiento = id_movimiento;
	}


	public String getCBU() {
		return CBU;
	}


	public void setCBU(String cBU) {
		CBU = cBU;
	}


	public int getId_prestamo() {
		return id_prestamo;
	}


	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}


	@Override
	public String toString() {
		return "PrestamosXmovimientos [id_movimiento=" + id_movimiento + ", CBU=" + CBU + ", id_prestamo=" + id_prestamo
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CBU == null) ? 0 : CBU.hashCode());
		result = prime * result + id_movimiento;
		result = prime * result + id_prestamo;
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
		if (id_movimiento != other.id_movimiento)
			return false;
		if (id_prestamo != other.id_prestamo)
			return false;
		return true;
	}
}
