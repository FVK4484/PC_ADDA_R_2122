package tests;

import ejercicios.Ejercicio1;

public class TestEjercicio1 {

	public static void main(String[] args) {
		
		System.out.println(" Recursiva No Final: " + 
				Ejercicio1.fRecursivaNoFinal(7, 9, 7));
		System.out.println(" Recursiva Final: " + 
				Ejercicio1.fRecursivaFinal(7, 9, 7));
		System.out.println(" Iterativa Funcional: " + 
				Ejercicio1.fIterativaFuncional(7, 9, 7));
		System.out.println(" Iterativa Funcional: " + 
				Ejercicio1.fIterativaImperativa(7, 9, 7));

	}

}
