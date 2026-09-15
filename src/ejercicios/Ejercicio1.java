package ejercicios;

import java.util.stream.Stream;

public record Ejercicio1(Integer a, Integer b, Integer c, String ac) {
	
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
		return fRecursivaFinal(a, b, c, "");
	}
	
	public static String fRecursivaFinal(Integer a, Integer b, Integer c, String ac) {
		if (a < 3 || b < 3 || c < 3) {
			return cadena(a + b + c) + "y" + ac;
		} else if (a < 5 || (b < a && b < c) || c < 5) {
			return cadena(a * b * c) + "z" + ac;
		} else if (a % 2 == 0 && b % 2 == 0 && c % 2 == 0) {
			return fRecursivaFinal(a - 1, b / 2, c - 3, "+" + ac);
		} else {
			return fRecursivaFinal(a - 4, b / 3, c - 4, "#" + ac);
		}
	}
	
	//	c) Solución en notación funcional
	public static String fIterativaFuncional(Integer a, Integer b, Integer c) {
		Ejercicio1 res = Stream.iterate(Ejercicio1.of(a, b, c, ""), 
				t -> t.siguiente())
				.filter(p -> p.esCasoBase())
				.findFirst()
				.get();
		
		return solucionBase(res.a(), res.b(), res.c()) + res.ac();
	}
	
	public static Ejercicio1 of(Integer a, Integer b, Integer c, String ac) {
		return new Ejercicio1(a,b,c,ac);
	}
	
	public Boolean esCasoBase() {
		return Ejercicio1.esCasoBase(a, b, c);
	}
	
	public static Boolean esCasoBase(Integer a, Integer b, Integer c) {
		Boolean caso1 = a < 3 || b < 3 || c < 3;
		Boolean caso2 = a < 5 || (b < a && b < c) || c < 5;
		return caso1 || caso2;
	}
	
	public static String solucionBase(Integer a, Integer b, Integer c) {
		String r = "";
		if (a < 3 || b < 3 || c < 3) {
			r = (a + b + c) + "y";
		} else if (a < 5 || (b < a && b < c) || c < 5) {
			r = (a * b * c) + "z";
		}
		return r;
	}
	
	public Ejercicio1 siguiente() {
		Integer a1 = a(), b1 = b(), c1 = c();
		String ac1 = ac();
		if (a1 % 2 == 0 && b1 % 2 == 0 && c1 % 2 == 0) {
			ac1 = String.format("%s", "+") + ac1;
			a1 = a1 - 1;
			b1 = b1 / 2;
			c1 = c1 - 3;
		} else {
			ac1 = String.format("%s", "#") + ac1;
			a1 = a1 - 4;
			b1 = b1 / 3;
			c1 = c1 - 4;
		}
		return Ejercicio1.of(a1, b1, c1, ac1);
	}
	
	//	d) Solución iterativa con while
	public static String fIterativaImperativa(Integer a, Integer b, Integer c) {
		Integer a_w = a;
		Integer b_w = b;
		Integer c_w = c;
		String acum = "";
		while (!esCasoBase(a_w, b_w, c_w)) {
			if (a_w % 2 == 0 && b_w % 2 == 0 && c_w % 2 == 0) {
				acum = "+" + acum;
				a_w = a_w - 1;
				b_w = b_w / 2;
				c_w = c_w - 3;
			} else {
				acum = "#" + acum;
				a_w = a_w - 4;
				b_w = b_w / 3;
				c_w = c_w - 4;
			}
		}
		acum = solucionBase(a_w, b_w, c_w) + acum;
		return acum;
	}
	
}
