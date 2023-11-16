package util;
import java.text.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
	public static String formatMoney(float monto) {
		return new DecimalFormat("$ ###,###,###.##", DecimalFormatSymbols.getInstance()).format(monto);
	}
	
	public static String formatDate(LocalDateTime fecha, boolean mostrarHora) {
		return new java.text.SimpleDateFormat("dd/MM/yyyy" + (mostrarHora ? " HH:mm" : "")).format(fecha);
	}
	
	public static String formateador (LocalDateTime fecha) {
	
		DateTimeFormatter formater =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");	
		
	 return  fecha.format(formater);
	}
}
