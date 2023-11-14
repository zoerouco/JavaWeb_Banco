package excepciones;

import java.io.IOException;

public class DniRepetidoException extends IOException{
	
	private static final long serialVersionUID = 1L;

	public DniRepetidoException() {}
	
	@Override
	public String getMessage() {
		return "El DNI ingresado ya esta vinculado a un cliente.";
	}
}
