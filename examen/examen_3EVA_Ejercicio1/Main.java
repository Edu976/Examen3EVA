package examen_3EVA_Ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import ejerciciosRepaso_3EVA.Paises2;

/**
 * 
 * pre:--- post: En esta clase de java vamos a leer un fichero, del cual vamos a
 * sacar una lista de palabras que empiezan o acaban por una letra que le
 * indicamos y la linea en la que se encuentran, por último las añadiremos a una
 * base de datos
 *
 */
public class Main {

	public static void main(String[] args) {
		String fichero = "C:\\Users\\Gestor\\eclipse-workspace\\Programacion\\src\\examen_3EVA_Ejercicio1\\HablanosDelDon.txt";
		String letra = "a";
		// pasamos la ruta al metodo de lectura
		lectura(fichero, letra);
	}

	private static void lectura(String nombre, String letra) {

		ArrayList<Letras> palabras = new ArrayList<Letras>();
		// para poder leer un archivo hay que crear un objeto de clase file con la ruta
		// del archivo
		File file = new File(nombre);
		try {
			Scanner f = new Scanner(file);
			// bucle para recorrer el fichero de texto
			while (f.hasNextLine()) {
				String linea = f.next(); // lee palabra por palabra
				// String linea = f.nextLine(); para leer linea por linea
				// limpieza de linea
				linea = linea.replaceAll(".", "");
				linea = linea.replaceAll(",", "");
//				linea = linea.replaceAll("�", "ny");
//				linea = linea.replaceAll("�", "a");
//				linea = linea.replaceAll("�", "e");
//				linea = linea.replaceAll("�", "i");
//				linea = linea.replaceAll("�", "o");
//				linea = linea.replaceAll("�", "u");

				// crea una tabla y en cada celda mete lo que haya entre espacio y espacio
				String[] linesep = linea.split(" ");
				// este bucle es para que se muestre el texto por consola no es necesario para
				// nada más
				for (int i = 0; i < linesep.length; i++) {
					palabras.add(linesep[i]);
					int posicion = añadir(palabras, letra);
				}

			}
			f.close();

		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + " no ha podido ser abierto.");
		}
	}

	public static int añadir(ArrayList<Letras> lista, String letra) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getLetra() == letra) {
				return i;
			}
		}
		return -1;

	}

}
