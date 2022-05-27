package examen_3EVA_Ejercicio2;

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
		// para poder leer un archivo hay que crear un objeto de clase file con la ruta
		// del archivo
		String nombre = "C:\\Users\\Gestor\\eclipse-workspace\\Programacion\\src\\examen_3EVA_Ejercicio2\\Divorcios.csv";
		File file = new File(nombre);
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			// bucle para recorrer el fichero de texto
			while (f.hasNextLine()) {
				//String linea = f.next(); // lee palabra por palabra
				String linea = f.nextLine(); //para leer linea por linea
				// limpieza de linea
				linea = linea.replaceAll("\\.", "");
				linea = linea.replaceAll(",", "");
				linea = linea.replaceAll("�", "ny");
				linea = linea.replaceAll("�", "a");
				linea = linea.replaceAll("�", "e");
				linea = linea.replaceAll("�", "i");
				linea = linea.replaceAll("�", "o");
				linea = linea.replaceAll("�", "u");

				// crea una tabla y en cada celda mete lo que haya entre espacio y espacio
				String[] linesep = linea.split(";");
				// este bucle es para que se muestre el texto por consola no es necesario para
				// nada m�s
				for (int i = 0; i < linesep.length; i++) {
					System.out.println(linesep[i]);
				}
			}
			f.close();

		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto.");
		}
	}
}
