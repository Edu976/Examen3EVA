package examen_3EVA_Ejercicio4;

/**
 * 
 * pre:--- 
 * post: En esta clase java vamos a implementar un método recursivo que
 * nos mostrara la tabla de multiplicar de un numero hasta que este sea
 * multipilicado por el 100 aumentando de 2 en 2
 *
 */
public class Main {

	public static void main(String[] args) {
		int indice = 100;
		int numero = 1;
		// tablaMultiplicar(numero, indice);
		tablaMultiplicar(numero, indice);
	}

	public static void tablaMultiplicar(int numero, int indice) {
		// System.out.println("indice " + indice + " " + "numero " + numero);
		if ((indice) > 1) {
			tablaMultiplicar(numero, indice - 2);

		}
		System.out.println(numero + " * " + indice + " = " + (numero * indice));

	}
}
