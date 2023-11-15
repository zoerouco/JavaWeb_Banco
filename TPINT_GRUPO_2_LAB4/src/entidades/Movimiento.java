package entidades;

import java.sql.Date;
import java.time.LocalDateTime;

public class Movimiento {
	
	public static void setID_Movimiento(int iD_Movimiento) {
		ID_Movimiento = iD_Movimiento;
	}

	private static int ID_Movimiento = 0;
	
	private int id_movimiento;
	private Cuenta CBU;	
	private Cuenta CBU_Destino;
	private LocalDateTime Fecha_Transaccion;
	private float Importe;
	private String Detalle;	
	private Tipo_Movimiento TipoMovimiento;
	private boolean estado;

	// Constructor para Id_Mov
	public Movimiento () {
		ID_Movimiento++;
	}

	public Movimiento(int id_movimiento, Cuenta cBU, Cuenta cBU_Destino, LocalDateTime fecha_Transaccion, float importe,
			String detalle, Tipo_Movimiento tipoMovimiento, boolean estado) {
		super();
		this.id_movimiento = id_movimiento;
		CBU = cBU;
		CBU_Destino = cBU_Destino;
		Fecha_Transaccion = fecha_Transaccion;
		Importe = importe;
		Detalle = detalle;
		TipoMovimiento = tipoMovimiento;
		this.estado = estado;
	}

	public int getId_movimiento() {
		return id_movimiento;
	}

	public void setId_movimiento(int id_movimiento) {
		this.id_movimiento = id_movimiento;
	}

	public Cuenta getCBU() {
		return CBU;
	}

	public void setCBU(Cuenta cBU) {
		CBU = cBU;
	}

	public Cuenta getCBU_Destino() {
		return CBU_Destino;
	}

	public void setCBU_Destino(Cuenta cBU_Destino) {
		CBU_Destino = cBU_Destino;
	}


	public float getImporte() {
		return Importe;
	}

	public void setImporte(float importe) {
		Importe = importe;
	}

	public String getDetalle() {
		return Detalle;
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
	}

	public Tipo_Movimiento getTipoMovimiento() {
		return TipoMovimiento;
	}

	public void setTipoMovimiento(Tipo_Movimiento tipoMovimiento) {
		TipoMovimiento = tipoMovimiento;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public static int getID_Movimiento() {
		return ID_Movimiento;
	}

	public void setFecha_Transaccion(LocalDateTime fecha_Transaccion) {
		Fecha_Transaccion = fecha_Transaccion;
	}

	public LocalDateTime getFecha_Transaccion() {
		return Fecha_Transaccion;
	}	
	
}
