package excepciones;

import java.io.IOException;

public class CbuRepetidoException extends IOException {
	
	private static final long serialVersionUID = 1L;
	
	public CbuRepetidoException() {}
	
	@Override
	public String getMessage() {
		return "El CBU ingresado ya esta asociado a una cuenta.";
	}

}
