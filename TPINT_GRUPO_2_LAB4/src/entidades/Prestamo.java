package entidades;

import java.sql.Date;

public class Prestamo {

	
	private static int cont_id_prestamo = 0;
	
	private int id_prestamo;
	private Cuenta CBU;
	private Date fecha_realizacion;
	private float importe_con_intereses;
	private float importe_pedido;
	private float monto_x_mes;
	private int cant_cuotas;
	private String estado; //solicitado-aprobado-rechazado-concluido
	
	public Prestamo() { //cuando llamamos al constructor, se le setea el id_prestamo :)
		cont_id_prestamo++;
		this.id_prestamo = cont_id_prestamo ;
	}
	
	public Prestamo (String estado) {
		this.estado = estado;
	}

	public static int getCont_id_prestamo() {
		return cont_id_prestamo;
	}

	public static void setCont_id_prestamo(int cont_id_prestamo) {
		Prestamo.cont_id_prestamo = cont_id_prestamo;
	}

	public int getId_prestamo() {
		return id_prestamo;
	}

	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CBU == null) ? 0 : CBU.hashCode());
		result = prime * result + cant_cuotas;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fecha_realizacion == null) ? 0 : fecha_realizacion.hashCode());
		result = prime * result + id_prestamo;
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
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fecha_realizacion == null) {
			if (other.fecha_realizacion != null)
				return false;
		} else if (!fecha_realizacion.equals(other.fecha_realizacion))
			return false;
		if (id_prestamo != other.id_prestamo)
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
