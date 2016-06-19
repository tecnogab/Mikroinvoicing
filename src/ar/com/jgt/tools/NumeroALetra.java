package ar.com.jgt.tools;

import java.util.regex.Pattern;

/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class NumeroALetra {

	private final String[] UNIDADES = { "", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ",
			"nueve " };
	private final String[] DECENAS = { "diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
			"diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ", "cincuenta ", "sesenta ",
			"setenta ", "ochenta ", "noventa " };
	private final String[] CENTENAS = { "", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ",
			"seiscientos ", "setecientos ", "ochocientos ", "novecientos " };

	public NumeroALetra() {
	}

	public String convertir(String p_numero, boolean p_mayusculas) {
		String l_literal = "";
		String l_parteDecimal;
		// si el numero utiliza (.) en lugar de (,) -> se reemplaza
		p_numero = p_numero.replace(".", ",");
		// si el numero no tiene parte decimal, se le agrega ,00
		if (p_numero.indexOf(",") == -1) {
			p_numero = p_numero + ",00";
		}
		// se valida formato de entrada -> 0,00 y 999 999 999,00
		if (Pattern.matches("\\d{1,9},\\d{1,2}", p_numero)) {
			// se divide el numero 0000000,00 -> entero y decimal
			String l_numArray[] = p_numero.split(",");
			// de da formato al numero decimal
			l_parteDecimal = "con " + l_numArray[1] + "/100 ARS";

			// se convierte el numero a literal
			if (Integer.parseInt(l_numArray[0]) == 0) {// si el valor es cero
				l_literal = "cero ";
			} else if (Integer.parseInt(l_numArray[0]) > 999999) {// si es
																	// millon
				l_literal = getMillones(l_numArray[0]);
			} else if (Integer.parseInt(l_numArray[0]) > 999) {// si es miles
				l_literal = getMiles(l_numArray[0]);
			} else if (Integer.parseInt(l_numArray[0]) > 99) {// si es centena
				l_literal = getCentenas(l_numArray[0]);
			} else if (Integer.parseInt(l_numArray[0]) > 9) {// si es decena
				l_literal = getDecenas(l_numArray[0]);
			} else {// sino unidades -> 9
				l_literal = getUnidades(l_numArray[0]);
			}
			// devuelve el resultado en mayusculas o minusculas
			if (p_mayusculas) {
				return (l_literal + l_parteDecimal).toUpperCase();
			} else {
				return (l_literal + l_parteDecimal);
			}
		} else {// error, no se puede convertir
			return l_literal = null;
		}
	}

	/* funciones para convertir los numeros a literales */

	private String getUnidades(String p_numero) {// 1 - 9
		// si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
		String l_numero = p_numero.substring(p_numero.length() - 1);
		return UNIDADES[Integer.parseInt(l_numero)];
	}

	private String getDecenas(String p_numero) {// 99
		int l_num = Integer.parseInt(p_numero);
		if (l_num < 10) {// para casos como -> 01 - 09
			return getUnidades(p_numero);
		} else if (l_num > 19) {// para 20...99
			String u = getUnidades(p_numero);
			if (u.equals("")) { // para 20,30,40,50,60,70,80,90
				return DECENAS[Integer.parseInt(p_numero.substring(0, 1)) + 8];
			} else {
				return DECENAS[Integer.parseInt(p_numero.substring(0, 1)) + 8] + "y " + u;
			}
		} else {// numeros entre 11 y 19
			return DECENAS[l_num - 10];
		}
	}

	private String getCentenas(String p_numero) {// 999 o 099
		if (Integer.parseInt(p_numero) > 99) {// es centena
			if (Integer.parseInt(p_numero) == 100) {// caso especial
				return " cien ";
			} else {
				return CENTENAS[Integer.parseInt(p_numero.substring(0, 1))] + getDecenas(p_numero.substring(1));
			}
		} else {// por Ej. 099
				// se quita el 0 antes de convertir a decenas
			return getDecenas(Integer.parseInt(p_numero) + "");
		}
	}

	private String getMiles(String p_numero) {// 999 999
		// obtiene las centenas
		String l_centenas = p_numero.substring(p_numero.length() - 3);
		// obtiene los miles
		String l_miles = p_numero.substring(0, p_numero.length() - 3);
		String l_num = "";
		// se comprueba que miles tenga valor entero
		if (Integer.parseInt(l_miles) > 0) {
			l_num = getCentenas(l_miles);
			return l_num + "mil " + getCentenas(l_centenas);
		} else {
			return "" + getCentenas(l_centenas);
		}

	}

	private String getMillones(String p_numero) { // 000 000 000
		// se obtiene los miles
		String l_miles = p_numero.substring(p_numero.length() - 6);
		// se obtiene los millones
		String l_millon = p_numero.substring(0, p_numero.length() - 6);
		String l_num = "";
		if (l_millon.length() > 1) {
			l_num = getCentenas(l_millon) + "millones ";
		} else {
			l_num = getUnidades(l_millon) + "millon ";
		}
		return l_num + getMiles(l_miles);
	}
}
