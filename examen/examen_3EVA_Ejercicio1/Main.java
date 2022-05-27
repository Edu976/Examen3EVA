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
		String letraElegida = "a";
		String fichero = "C:\\Users\\Gestor\\eclipse-workspace\\Programacion\\src\\examen_3EVA_Ejercicio1\\HablanosDelDon.txt";
		ArrayList<Palabras> palabras = new ArrayList<Palabras>();
		ArrayList<Palabras> palabras2 = new ArrayList<Palabras>();
		// pasamos la ruta al metodo de lectura
		// para poder leer un archivo hay que crear un objeto de clase file con la ruta
		// del archivo
		File file = new File(fichero);
		try {
			Scanner f = new Scanner(file);
			// bucle para recorrer el fichero de texto
			while (f.hasNextLine()) {

				// String linea = f.next(); // lee palabra por palabra
				String linea = f.nextLine(); // para leer linea por linea
				// limpieza de linea
				linea = linea.replaceAll("\\.", "");
				linea = linea.replaceAll(",", "");
//						linea = linea.replaceAll("�", "ny");
//						linea = linea.replaceAll("�", "a");
//						linea = linea.replaceAll("�", "e");
//						linea = linea.replaceAll("�", "i");
//						linea = linea.replaceAll("�", "o");
//						linea = linea.replaceAll("�", "u");

				// crea una tabla y en cada celda mete lo que haya entre espacio y espacio
				String[] linesep = linea.split(" ");
				// este bucle es para que se muestre el texto por consola no es necesario para
				// nada m�s

				for (int i = 0; i < linesep.length; i++) {
					// System.out.println(palabras.get(i));
					palabras.add(new Palabras(null, linesep[i]));
					// System.out.println(palabras.get(i));

				}

			}
			for (int i = 0; i < palabras.size(); i++) {
				if (palabras.get(i).getPalabra().substring(0, 1).equalsIgnoreCase(letraElegida)) {
					palabras2.add(new Palabras(null, palabras.get(i).getPalabra()));
				}

				else if (palabras.get(i).getPalabra().substring(palabras.get(i).getPalabra().length() - 1)
						.equalsIgnoreCase(letraElegida)) {
					palabras2.add(new Palabras(null, palabras.get(i).getPalabra()));
				}
			}
			f.close();
			for (int i = 0; i < palabras2.size(); i++) {
				System.out.println(palabras2.get(i).getPalabra());
			}

		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + fichero + " no ha podido ser abierto.");
		}
	}

	public static int buscarLetra(ArrayList<String> texto) {
		String letraElegida = "a";
		for (int i = 0; i < texto.size(); i++) {
			if (texto.get(i).substring(0, 1) == letraElegida
					|| texto.get(i).substring(texto.get(i).length() - 1) == letraElegida) {
				System.out.println("primera letra" + texto.get(i).substring(0, 1));
				System.out.println("letra elegida " + letraElegida);
				System.out.println("letra fin palabra " + texto.get(i).substring(texto.get(i).length() - 1));
				return 0;
			}
		}
		return -1;
	}

}
