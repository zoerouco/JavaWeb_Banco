package excepciones;

public class SaldoInsuficienteException extends Exception {

	public SaldoInsuficienteException () {
		// llama al constructor del padre con el mensaje por defecto
		super("La cuenta seleccionada no cuenta con fondos suficientes para realizar la transacción.");
	}
}
