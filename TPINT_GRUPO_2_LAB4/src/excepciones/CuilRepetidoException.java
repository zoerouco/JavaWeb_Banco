package excepciones;

import java.io.IOException;

public class CuilRepetidoException extends IOException{

	private static final long serialVersionUID = 1L;
	
	public CuilRepetidoException() {}
	
	@Override
	public String getMessage() {
		return "El CUIL ingresado ya esta vinculado a un cliente.";
	}

}
