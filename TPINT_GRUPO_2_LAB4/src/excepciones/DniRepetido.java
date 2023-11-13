package excepciones;

import java.io.IOException;

public class DniRepetido extends IOException{
	
	private static final long serialVersionUID = 1L;

	public DniRepetido() {}
	
	@Override
	public String getMessage() {
		return "El DNI ingresado ya esta vinculado a un cliente.";
	}
}
