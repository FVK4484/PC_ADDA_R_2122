package ejercicios;

public class Ejercicio1 {
	
	private static String cadena(Integer n) {
		return n.toString();
	}
	
	//	a) Proporcione una solución eficiente recursiva no final.
	public static String fRecursivaNoFinal(Integer a, Integer b, Integer c) {
		String f = null;
		if (a < 3 || b < 3 || c < 3) {
			f = cadena(a + b + c).concat("y");
		} else if (a < 5 || (b < a && b < c) || c < 5) {
			f = cadena(a * b * c).concat("z");
		} else if (a % 2 == 0 && b % 2 == 0 && c % 2 == 0) {
			f = fRecursivaNoFinal(a - 1, b / 2, c - 3).concat("+");
		} else {
			f = fRecursivaNoFinal(a - 4, b / 3, c - 4).concat("#");
		}
		return f;
	}
	
	//	b) Proporcione una solución eficiente recursiva final.
	public static String fRecursivaFinal(Integer a, Integer b, Integer c) {
		String f = null;
		
		
		return f;
	}
	
}
