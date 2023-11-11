package entidades;

import java.sql.Date;

public class Movimiento {
	
	public static void setID_Movimiento(int iD_Movimiento) {
		ID_Movimiento = iD_Movimiento;
	}

	private static int ID_Movimiento = 0;
	
	private int id_movimiento;
	private Cuenta CBU;	
	private Cuenta CBU_Destino;
	private Date Fecha_Transaccion;
	private float Importe;
	private String Detalle;	
	private Tipo_Movimiento TipoMovimiento;
	private boolean estado;
	
	 
	
	
	
	// Constructor para Id_Mov
	public Movimiento () {
		ID_Movimiento++;
	}
	
	
	
	
		public Movimiento(int id_Movimiento,Cuenta CBU, Cuenta CBU_Destino, float Importe , Date Fecha_Transaccion,String Detalle, Tipo_Movimiento TipoMovimiento, boolean estado) {
			
			this.id_movimiento=id_Movimiento;
			this.CBU=CBU;	
			this.CBU_Destino=CBU_Destino;
			this.Importe = Importe;
			this.Fecha_Transaccion = Fecha_Transaccion;
			this.Detalle = Detalle;
			this.Importe = Importe;
			this.TipoMovimiento=TipoMovimiento;
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
		
		public void setCBU(Cuenta CBU) {
			this.CBU = CBU;
		}
		
		public Cuenta getCBU_Destino() {
			return CBU_Destino;
		}
		
		public void setCBU_Destino(Cuenta CBU_Destino) {
			this.CBU_Destino = CBU_Destino;
		}
		
		public Date getFecha_Transaccion() {
			return Fecha_Transaccion;
		}
		
		public void setFecha_Transaccion(Date Fecha_Transaccion) {
			this.Fecha_Transaccion = Fecha_Transaccion;
		}
		
		public float getImporte() {
			return Importe;
		}
		
		public void setImporte(float Importe) {
			this.Importe = Importe;
		}
		
		public String getDetalle() {
			return Detalle;
		}
		
		public void setDetalle(String Detalle) {
			this.Detalle = Detalle;
		}
		
		public Tipo_Movimiento getTipoMovimiento() {
			return TipoMovimiento;
		}
		
		public void setTipoMovimiento(Tipo_Movimiento TipoMovimiento) {
			this.TipoMovimiento = TipoMovimiento;
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
		
		public int getID_MovimientoInstancia() {
			return this.ID_Movimiento;
		}
		
	
}
