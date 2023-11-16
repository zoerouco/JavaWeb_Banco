package negocio;

import java.util.ArrayList;
import entidades.Cuenta;
import excepciones.CbuRepetidoException;
import excepciones.SaldoInsuficienteException;

public interface CuentaNegocio {
	
	public boolean insert (Cuenta cuenta);
	public boolean delete (Cuenta cuenta);
	public ArrayList<Cuenta> readAll();
	public boolean update (Cuenta cuenta);
	public Cuenta getCuentaxCBU (String CBU);
	public ArrayList<Cuenta> getCuentasxDNI (String DNI);
	ArrayList<Cuenta> readAllActivos();
	ArrayList<Cuenta> readAllInactivos();
	public void validarSaldo(Cuenta cuenta, float importeMovimiento) throws SaldoInsuficienteException;
    public boolean esNumero(String texto);
	boolean verificarCbuRepetido(String cbu) throws CbuRepetidoException;
}
