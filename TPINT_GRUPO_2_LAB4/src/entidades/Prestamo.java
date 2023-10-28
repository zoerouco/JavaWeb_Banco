package entidades;

import java.sql.Date;

public class Prestamo {

	private static String cod_idPrestamo = "P";
	private static int aux_id_prestamo = 0;
	
	private String id_prestado;
	private Cuenta CBU;
	private Date fecha_realizacion;
	private float importe_con_intereses;
	private float importe_pedido;
	private float monto_x_mes;
	private int cant_cuotas;
	private boolean estado; //solicitado-aprobado-rechazado-concluido
	
	public Prestamo() { //cuando llamamos al constructor, se le setea el id_prestamo :)
		aux_id_prestamo++;
		this.id_prestado = cod_idPrestamo + aux_id_prestamo;
	}
	
	public Prestamo(String id_prestado, Cuenta cBU, Date fecha_realizacion, float importe_con_intereses,
	        float importe_pedido, float monto_x_mes, int cant_cuotas, boolean estado) {
		aux_id_prestamo++;
		this.id_prestado = cod_idPrestamo + aux_id_prestamo;
		CBU = cBU;
		this.fecha_realizacion = fecha_realizacion;
		this.importe_con_intereses = importe_con_intereses;
		this.importe_pedido = importe_pedido;
		this.monto_x_mes = monto_x_mes;
		this.cant_cuotas = cant_cuotas;
		this.estado = estado;
	}
	
	
	public static String getCod_idPrestamo() {
		return cod_idPrestamo;
	}

	public static void setCod_idPrestamo(String cod_idPrestamo) {
		Prestamo.cod_idPrestamo = cod_idPrestamo;
	}

	public static int getAux_id_prestamo() {
		return aux_id_prestamo;
	}

	public static void setAux_id_prestamo(int aux_id_prestamo) {
		Prestamo.aux_id_prestamo = aux_id_prestamo;
	}

	public String getId_prestado() {
		return id_prestado;
	}

	public void setId_prestado(String id_prestado) {
		this.id_prestado = id_prestado;
	}

	public Cuenta getCBU() {
		return CBU;
	}

	public void setCBU(Cuenta cBU) {
		CBU = cBU;
	}

	public Date getFecha_realizacion() {
		return fecha_realizacion;
	}

	public void setFecha_realizacion(Date fecha_realizacion) {
		this.fecha_realizacion = fecha_realizacion;
	}

	public float getImporte_con_intereses() {
		return importe_con_intereses;
	}

	public void setImporte_con_intereses(float importe_con_intereses) {
		this.importe_con_intereses = importe_con_intereses;
	}

	public float getImporte_pedido() {
		return importe_pedido;
	}

	public void setImporte_pedido(float importe_pedido) {
		this.importe_pedido = importe_pedido;
	}

	public float getMonto_x_mes() {
		return monto_x_mes;
	}

	public void setMonto_x_mes(float monto_x_mes) {
		this.monto_x_mes = monto_x_mes;
	}

	public int getCant_cuotas() {
		return cant_cuotas;
	}

	public void setCant_cuotas(int cant_cuotas) {
		this.cant_cuotas = cant_cuotas;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "ID Prestado=" + id_prestado + ", CBU=" + CBU.getCBU() + ", fecha_realizacion=" + fecha_realizacion
				+ ", importe_con_intereses=" + importe_con_intereses + ", importe_pedido=" + importe_pedido
				+ ", monto_x_mes=" + monto_x_mes + ", cant_cuotas=" + cant_cuotas + ", estado=" + estado + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CBU == null) ? 0 : CBU.hashCode());
		result = prime * result + cant_cuotas;
		result = prime * result + (estado ? 1231 : 1237);
		result = prime * result + ((fecha_realizacion == null) ? 0 : fecha_realizacion.hashCode());
		result = prime * result + ((id_prestado == null) ? 0 : id_prestado.hashCode());
		result = prime * result + Float.floatToIntBits(importe_con_intereses);
		result = prime * result + Float.floatToIntBits(importe_pedido);
		result = prime * result + Float.floatToIntBits(monto_x_mes);
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
		Prestamo other = (Prestamo) obj;
		if (CBU == null) {
			if (other.CBU != null)
				return false;
		} else if (!CBU.equals(other.CBU))
			return false;
		if (cant_cuotas != other.cant_cuotas)
			return false;
		if (estado != other.estado)
			return false;
		if (fecha_realizacion == null) {
			if (other.fecha_realizacion != null)
				return false;
		} else if (!fecha_realizacion.equals(other.fecha_realizacion))
			return false;
		if (id_prestado == null) {
			if (other.id_prestado != null)
				return false;
		} else if (!id_prestado.equals(other.id_prestado))
			return false;
		if (Float.floatToIntBits(importe_con_intereses) != Float.floatToIntBits(other.importe_con_intereses))
			return false;
		if (Float.floatToIntBits(importe_pedido) != Float.floatToIntBits(other.importe_pedido))
			return false;
		if (Float.floatToIntBits(monto_x_mes) != Float.floatToIntBits(other.monto_x_mes))
			return false;
		return true;
	}
}
