package examen_3EVA_Ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * 
 * pre:--- 
 * post: En esta clase de java vamos a leer un fichero, del cual vamos a
 * sacar una lista de palabras que empiezan o acaban por una letra que le
 * indicamos y la linea en la que se encuentran, por último las añadiremos a una
 * base de datos
 *
 */
public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		int con = 0;
		int sin = 0;
		int suma = 0;
		ArrayList<Divorcio> divorcios = new ArrayList<Divorcio>();
		String nombre = "C:\\Users\\Gestor\\eclipse-workspace\\Programacion\\src\\examen_3EVA_Ejercicio2\\Divorcios.csv";
		File file = new File(nombre);
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			// bucle para recorrer el fichero de texto
			while (f.hasNextLine()) {
				// String linea = f.next(); // lee palabra por palabra
				String linea = f.nextLine(); // para leer linea por linea
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
					if (linesep[i].equalsIgnoreCase("si") && Integer.parseInt(linesep[2]) < 2019) {
						con++;
					} else if (linesep[i].equalsIgnoreCase("no") && Integer.parseInt(linesep[2]) < 2018) {
						sin++;
					}
					// else if(linesep[i].equalsIgnoreCase("no"))
					// System.out.println(linesep[2]);
				}

//				int posicion = buscarProvincia(divorcios, linesep[0]);
//				if(posicion == 1) {
//					divorcios.get(posicion).setContador(divorcios.get(posicion).getContador() + 1);
//				}
//				else {
//					divorcios.add(new Divorcio(linesep[0], 1));
//				}

			}

			f.close();
			System.out.println("El número total de divorcios CON separación previa en el año 2019 es: " + con);
			System.out.println("El número total de divorcios SIN separación previa en el año 2018 es: " + sin);
			System.out.println("---------------------");
			Collections.sort(divorcios);

		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto.");
		}
	}

	public static int buscarProvincia(ArrayList<Divorcio> divorcios, String provincia) {
		for (int i = 0; i < divorcios.size(); i++) {
			if (divorcios.get(i).getCiudad().equalsIgnoreCase(provincia)) {
				return 1;
			}
		}
		return 0;
	}

}
