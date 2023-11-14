package util;
import java.text.*;

public class Utils {
	public static String formatMoney(float monto) {
		return new DecimalFormat("$ ###,###,###.##", DecimalFormatSymbols.getInstance()).format(monto);
	}
	
	public static String formatDate(java.sql.Date fecha, boolean mostrarHora) {
		return new java.text.SimpleDateFormat("dd/MM/yyyy" + (mostrarHora ? " HH:mm" : "")).format(fecha);
	}
}
